package br.com.ifpe.oxefood.modelo.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.modelo.cliente.Cliente;
import jakarta.transaction.Transactional;

@Service
public class ProdutoService {

  @Autowired
  private ProdutoRepository repository;

  @Transactional // escopo de transação no banco de dados
  public Produto save(Produto produto) {

    produto.setHabilitado(Boolean.TRUE);
    return repository.save(produto);
  }

    public List<Produto> listarTodos() {

        return repository.findAll();
    }

    public Produto obterPorID(Long id) {

        return repository.findById(id).get();
    }
}
