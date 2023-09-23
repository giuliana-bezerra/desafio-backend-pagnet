package br.com.giulianabezerra.desafiobackendpagnet.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.giulianabezerra.desafiobackendpagnet.entity.Transacao;

public interface TransacaoRepository extends CrudRepository<Transacao, Long> {
  List<Transacao> findAllByOrderByNomeDaLojaAscIdDesc();
}
