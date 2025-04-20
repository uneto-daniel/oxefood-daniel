package br.com.ifpe.oxefood.api.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.ifpe.oxefood.modelo.produto.Produto;
import br.com.ifpe.oxefood.modelo.produto.ProdutoService;

@RestController

@RequestMapping("/api/produto")

@CrossOrigin
public class ProdutoController {
    // Injeção de dependência do ProdutoService
    // O ProdutoService é responsável por gerenciar a lógica de negócios relacionada aos produtos
    // e a persistência dos dados no banco de dados.
    // O @Autowired é uma anotação do Spring que permite a injeção automática de dependências.
    @Autowired//
    private ProdutoService produtoService;

    @PostMapping//  Cria um novo produto
    // O método save é responsável por receber uma requisição HTTP POST com os dados de um novo produto,   
    // criar um objeto Produto a partir desses dados e salvá-lo no banco de dados.
    // O @RequestBody indica que o corpo da requisição deve ser convertido em um objeto ProdutoRequest. 
    public ResponseEntity<Produto> save(@RequestBody ProdutoRequest request) {

        // O método build() da classe ProdutoRequest converte os dados recebidos em um objeto Produto.
        // O ProdutoRequest é um DTO (Data Transfer Object) que contém os dados necessários para criar um novo produto.
        Produto produto = produtoService.save((Produto) request.build());


        return new ResponseEntity<Produto>(produto, HttpStatus.CREATED);
    }
}
