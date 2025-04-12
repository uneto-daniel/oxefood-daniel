package br.com.ifpe.oxefood.modelo.cliente;

// Importação de bibliotecas necessárias
import java.time.LocalDate;
import org.hibernate.annotations.SQLRestriction;
import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Define a classe como uma entidade JPA e mapeia para a tabela "Cliente"
@Entity
@Table(name = "Cliente")
// Restringe a consulta para retornar apenas clientes com 'habilitado = true'
@SQLRestriction("habilitado = true")
// Define o padrão de construção usando o padrão Builder
@Builder
// Gera os métodos getter e setter automaticamente para todos os campos
@Getter
@Setter
// Gera um construtor com todos os parâmetros
@AllArgsConstructor
// Gera um construtor sem parâmetros, necessário para o Hibernate/JPA
@NoArgsConstructor
public class Cliente extends EntidadeAuditavel {

    // Campo 'nome' da tabela Cliente
    @Column
    private String nome;

    // Campo 'dataNascimento' da tabela Cliente
    @Column
    private LocalDate dataNascimento;

    // Campo 'cpf' da tabela Cliente
    @Column
    private String cpf;

    // Campo 'foneCelular' da tabela Cliente
    @Column
    private String foneCelular;

    // Campo 'foneFixo' da tabela Cliente
    @Column
    private String foneFixo;

}