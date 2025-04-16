// Define o pacote onde esta classe está localizada.
package br.com.ifpe.oxefood.modelo.cliente;

// Importa a anotação @Autowired para injeção de dependência automática.
import org.springframework.beans.factory.annotation.Autowired;
// Importa a anotação @Service para indicar que esta classe é um componente de serviço.
import org.springframework.stereotype.Service;

// Importa a anotação @Transactional para garantir que a operação seja executada dentro de uma transação.
import jakarta.transaction.Transactional;

// Indica que esta classe é um serviço (camada de lógica de negócio) gerenciado pelo Spring.
@Service
public class ClienteService {

   // Injeção automática do repositório ClienteRepository.
   @Autowired
   private ClienteRepository repository;

   // Define que este método será executado dentro de uma transação.
   // Isso garante consistência dos dados caso ocorra alguma falha no meio da operação.
   @Transactional
   public Cliente save(Cliente cliente) {

       // Define que o cliente está habilitado antes de salvar.
       // Pode ser um campo lógico no banco indicando se o cadastro está ativo.
       cliente.setHabilitado(Boolean.TRUE);

       // Salva o cliente no banco de dados usando o repositório e retorna o objeto gravado para ser exibido na tela para o ClienteController.
       return repository.save(cliente);
   }
}
