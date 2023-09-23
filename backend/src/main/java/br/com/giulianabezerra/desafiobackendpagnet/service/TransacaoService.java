package br.com.giulianabezerra.desafiobackendpagnet.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.com.giulianabezerra.desafiobackendpagnet.entity.TipoTransacao;
import br.com.giulianabezerra.desafiobackendpagnet.entity.Transacao;
import br.com.giulianabezerra.desafiobackendpagnet.entity.TransacaoReport;
import br.com.giulianabezerra.desafiobackendpagnet.repository.TransacaoRepository;

@Service
public class TransacaoService {
  private final TransacaoRepository repository;

  public TransacaoService(TransacaoRepository repository) {
    this.repository = repository;
  }

  public List<TransacaoReport> getTotaisTransacoesByNomeDaLoja() {
    List<Transacao> transacoes = repository.findAllByOrderByNomeDaLojaAscIdDesc();

    // preserves order
    Map<String, TransacaoReport> reportMap = new LinkedHashMap<>();

    transacoes.forEach(transacao -> {
      String nomeDaLoja = transacao.nomeDaLoja();
      TipoTransacao tipoTransacao = TipoTransacao.findByTipo(transacao.tipo());
      BigDecimal valor = transacao.valor().multiply(BigDecimal.valueOf(tipoTransacao.getSinal()));

      reportMap.compute(nomeDaLoja, (key, existingReport) -> {
        TransacaoReport report = (existingReport != null) ? existingReport
            : new TransacaoReport(BigDecimal.ZERO, key, new ArrayList<>());
        return report.addTotal(valor).addTransacao(transacao.withValor(valor));
      });
    });

    return new ArrayList<>(reportMap.values());
  }
}
