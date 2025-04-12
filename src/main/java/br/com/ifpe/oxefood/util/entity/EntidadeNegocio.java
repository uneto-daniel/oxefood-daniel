package br.com.ifpe.oxefood.util.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe base abstrata que representa uma entidade de negócio genérica.
 * 
 * Ela contém atributos comuns que serão herdados por outras entidades do sistema,
 * como por exemplo: id (identificador único) e habilitado (indica se o registro está ativo).
 * 
 * O uso de @MappedSuperclass garante que os campos desta classe serão herdados pelas
 * entidades filhas, mas esta classe não gerará uma tabela própria no banco de dados.
 */
@SuppressWarnings("serial") // Suprime o aviso relacionado à interface Serializable
@Getter // Lombok: Gera automaticamente os métodos get para todos os campos
@Setter // Lombok: Gera automaticamente os métodos set para todos os campos
@EqualsAndHashCode(of = { "id" }) // Lombok: Gera os métodos equals() e hashCode() com base apenas no campo "id"
@MappedSuperclass // JPA: Indica que esta classe não é uma entidade, mas suas propriedades serão herdadas por entidades concretas
public abstract class EntidadeNegocio implements Serializable {

   /**
    * Campo que representa o identificador único da entidade no banco de dados.
    * 
    * @Id - Indica que este campo é a chave primária da entidade.
    * @GeneratedValue - Especifica que o valor será gerado automaticamente usando uma sequência.
    */
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private Long id;

   /**
    * Campo usado para indicar se o registro está habilitado (ativo) ou não.
    * 
    * @JsonIgnore - Evita que esse campo seja exposto nas respostas JSON da API.
    * @Column - Indica que este campo será persistido como uma coluna no banco de dados.
    */
   @JsonIgnore
   @Column
   private Boolean habilitado;
}
