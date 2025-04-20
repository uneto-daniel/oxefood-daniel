package br.com.ifpe.oxefood.modelo.produto;

import org.hibernate.annotations.SQLRestriction;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Produto")
@Builder // Lombok: Gera automaticamente um construtor com todos os campos como parâmetros
// Hibernate: Restringe a consulta para retornar apenas produtos habilitados
@SQLRestriction("habilitado = true") // Restringe a consulta para retornar apenas produtos habilitados
@SuppressWarnings("serial") // Suprime o aviso relacionado à serialização
@MappedSuperclass // JPA: Indica que esta classe não é uma entidade, mas suas propriedades serão herdadas por entidades concretas
@EntityListeners(AuditingEntityListener.class) // Habilita o uso do recurso de auditoria (preenchimento automático de datas)
@AllArgsConstructor // Gera um construtor com todos os parâmetros
@NoArgsConstructor // Gera um construtor sem parâmetros, necessário para o Hibernate/JPA    
@Getter // Lombok: Gera automaticamente os métodos getters para todos os atributos
@Setter // Lombok: Gera automaticamente os métodos setters para todos os atributos
// Define a classe como uma entidade JPA e mapeia para a tabela "Produto"
public class Produto extends EntidadeAuditavel {

    // Define o campo "nome" como uma coluna na tabela com tamanho máximo de 100 caracteres
    @Column
    private String titulo;

    // Define o campo "descricao" como uma coluna na tabela com tamanho máximo de 255 caracteres
    @Column
    private String descricao;

    // Define o campo "preco" como uma coluna na tabela com precisão de 10 dígitos e escala de 2
    @Column 
    private Double valorUnitario;

    @Column
    private Integer tempoEntregaMinino; // Define o campo "tempoEntregaMinino" como uma coluna na tabela com tamanho máximo de 100 caracteres

    @Column
    private Integer tempoEntregaMaximo; // Define o campo "tempoEntregaMaximo" como uma coluna na tabela com tamanho máximo de 100 caracteres
    
}
