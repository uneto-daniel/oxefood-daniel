// Define o pacote onde esta interface está localizada.
package br.com.ifpe.oxefood.modelo.cliente;

// Importa a interface JpaRepository, que fornece operações padrão de acesso a dados (CRUD).
import org.springframework.data.jpa.repository.JpaRepository;

// Interface responsável por acessar e manipular os dados da entidade Cliente no banco de dados.
// Ela herda os métodos padrão do JpaRepository, como save, findById, findAll, deleteById, etc.
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
    // Podemos adicionar aqui métodos personalizados, como:
    // Cliente findByCpf(String cpf);
    // List<Cliente> findByNomeContaining(String nome);
    
}
