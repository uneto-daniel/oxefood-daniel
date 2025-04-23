package br.com.ifpe.oxefood.modelo.entregador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.modelo.cliente.Cliente;
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
public List<Entregador> listarTodos() {

        return repository.findAll();
    }

    public Entregador obterPorID(Long id) {

        return repository.findById(id).get();
    }
}
