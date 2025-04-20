package br.com.ifpe.oxefood.modelo.produto;
// Importa a classe Produto, que representa a entidade Produto.

import org.springframework.beans.factory.annotation.Autowired;
// Importa a anotação @Autowired para injeção de dependência automática.
// Importa a interface ProdutoRepository, que fornece operações padrão de acesso a dados (CRUD).

import org.springframework.stereotype.Service;
// Importa a anotação @Service para indicar que esta classe é um componente de serviço.
import jakarta.transaction.Transactional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Transactional
    public Produto save(Produto produto) {
        // Aqui é possível adicionar lógica adicional antes de salvar o produto, se necessário.
        // Por exemplo, definir campos padrão ou validar dados.
        produto.setHabilitado(Boolean.TRUE);

        // Salva o produto no banco de dados usando o repositório e retorna o objeto gravado.
        return repository.save(produto);
    }

    
}
