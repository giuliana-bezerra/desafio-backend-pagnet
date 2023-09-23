package br.com.giulianabezerra.desafiobackendpagnet.web;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.giulianabezerra.desafiobackendpagnet.entity.TransacaoReport;
import br.com.giulianabezerra.desafiobackendpagnet.service.TransacaoService;

@RestController
@RequestMapping("transacoes")
public class TransacaoController {
  private final TransacaoService transacaoService;

  public TransacaoController(TransacaoService transacaoService) {
    this.transacaoService = transacaoService;
  }

  @CrossOrigin(origins = { "http://localhost:9090", "https://frontend-pagnet.onrender.com" })
  @GetMapping
  List<TransacaoReport> listAll() {
    return transacaoService.getTotaisTransacoesByNomeDaLoja();
  }
}
