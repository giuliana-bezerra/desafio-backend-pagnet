package br.com.giulianabezerra.desafiobackendpagnet;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("cnab")
public class CnabController {
  private final CnabService cnabService;
  private final TransacaoService transacaoService;

  public CnabController(CnabService cnabService, TransacaoService transacaoService) {
    this.cnabService = cnabService;
    this.transacaoService = transacaoService;
  }

  @CrossOrigin(origins = { "http://localhost:9090", "https://frontend-pagnet.onrender.com" })
  @PostMapping("upload")
  public String upload(@RequestParam("file") MultipartFile file) throws Exception {
    cnabService.uploadCnabFile(file);
    return "Processamento iniciado!";
  }

  @CrossOrigin(origins = { "http://localhost:9090", "https://frontend-pagnet.onrender.com" })
  @GetMapping
  List<TransacaoReport> listAll() {
    return transacaoService.getTotaisTransacoesByNomeDaLoja();
  }
}
