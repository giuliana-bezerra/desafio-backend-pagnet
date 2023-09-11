package br.com.giulianabezerra.desafiobackendpagnet;

import java.math.BigDecimal;
import java.util.List;

public record TransacaoReport(
    BigDecimal total,
    String nomeDaLoja,
    List<Transacao> transacoes) {

  public TransacaoReport addTotal(BigDecimal valor) {
    return new TransacaoReport(this.total().add(valor), this.nomeDaLoja, this.transacoes);
  }

  public TransacaoReport addTransacao(Transacao transacao) {
    var transacoes = this.transacoes();
    transacoes.add(transacao);
    return new TransacaoReport(this.total(), this.nomeDaLoja, transacoes);
  }

  public TransacaoReport withNomeDaLoja(String nomeDaLoja) {
    return new TransacaoReport(this.total(), nomeDaLoja, this.transacoes);
  }
}
