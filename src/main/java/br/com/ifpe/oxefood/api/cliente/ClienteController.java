// Define o pacote onde está localizada essa classe.
package br.com.ifpe.oxefood.api.cliente;

import java.util.List;

// Importações das bibliotecas Spring necessárias para o funcionamento do controller.
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Importações das classes do domínio (modelo e serviço).
import br.com.ifpe.oxefood.modelo.cliente.Cliente;
import br.com.ifpe.oxefood.modelo.cliente.ClienteService;

// Indica que essa classe é um controlador REST, ou seja, irá receber e responder requisições HTTP.
@RestController

// Define o caminho base das URLs atendidas por este controller.
// Exemplo: http://localhost:8080/api/cliente
@RequestMapping("/api/cliente")

// Permite requisições de outras origens (como de um frontend rodando em outra porta ou domínio).
@CrossOrigin
public class ClienteController {

   // Injeta automaticamente uma instância do ClienteService. Serve para que ela possa ser utilizada dentro da função.
   @Autowired
   private ClienteService clienteService;

   // Mapeia requisições HTTP POST para o caminho "/api/cliente".
   // Isso é usado, por exemplo, para cadastrar um novo cliente.
   @PostMapping
   public ResponseEntity<Cliente> save(@RequestBody ClienteRequest request) {

       // Converte o DTO ClienteRequest em um objeto Cliente e o envia para o serviço salvar.
       Cliente cliente = clienteService.save(request.build());

       // Retorna uma resposta HTTP com status 201 (CREATED) e o objeto Cliente no corpo da resposta.
       return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
   }
   @GetMapping
    public List<Cliente> listarTodos() {
        return clienteService.listarTodos();
    }

    @GetMapping("/{id}")
    public Cliente obterPorID(@PathVariable Long id) {
        return clienteService.obterPorID(id);
    }

}
