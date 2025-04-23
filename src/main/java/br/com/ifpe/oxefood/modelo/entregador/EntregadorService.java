package br.com.ifpe.oxefood.modelo.entregador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class EntregadorService {

  @Autowired
  private EntregadorRepository repository;

  @Transactional // escopo de transação no banco de dados
  public Entregador save(Entregador cliente) {

    cliente.setHabilitado(Boolean.TRUE);
    return repository.save(cliente);
  }

}
