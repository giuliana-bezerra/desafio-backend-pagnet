package br.com.giulianabezerra.desafiobackendpagnet;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TransacaoRepository extends CrudRepository<Transacao, Long> {
  List<Transacao> findAllByOrderByNomeDaLojaAscIdDesc();
}
