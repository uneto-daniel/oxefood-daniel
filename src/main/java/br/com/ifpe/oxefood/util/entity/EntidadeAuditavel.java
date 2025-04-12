package br.com.ifpe.oxefood.util.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe base abstrata que representa uma entidade auditável.
 * 
 * Esta classe herda de EntidadeNegocio e adiciona campos relacionados à auditoria,
 * como datas de criação/modificação e informações sobre o usuário responsável pelas alterações.
 * 
 * As anotações utilizadas permitem que esses dados sejam preenchidos automaticamente
 * com o uso do recurso de auditoria do Spring Data JPA.
 */

@SuppressWarnings("serial") // Suprime o aviso relacionado à serialização
@Getter // Lombok: Gera automaticamente os métodos getters para todos os atributos
@Setter // Lombok: Gera automaticamente os métodos setters para todos os atributos
@MappedSuperclass // JPA: Indica que esta classe é uma superclasse mapeada, não gerando uma tabela própria
@EntityListeners(AuditingEntityListener.class) // Habilita o uso do recurso de auditoria (preenchimento automático de datas)
public abstract class EntidadeAuditavel extends EntidadeNegocio {

   /**
    * Campo utilizado para controle de concorrência otimista.
    * Permite garantir que dois usuários não atualizem simultaneamente a mesma entidade
    * sem que o sistema perceba e trate o conflito.
    *
    * @Version - Controla a versão da entidade.
    * @JsonIgnore - Oculta o campo em respostas JSON.
    */
   @JsonIgnore
   @Version
   private Long versao;

   /**
    * Armazena a data em que a entidade foi criada.
    * Este valor é preenchido automaticamente ao salvar um novo registro no banco de dados.
    *
    * @CreatedDate - Indica que o valor será gerado automaticamente na criação.
    * @JsonIgnore - Oculta o campo nas respostas JSON.
    */
   @JsonIgnore
   @CreatedDate
   private LocalDate dataCriacao;

   /**
    * Armazena a data da última modificação realizada na entidade.
    * É preenchido automaticamente sempre que a entidade for atualizada.
    *
    * @LastModifiedDate - Indica preenchimento automático na última atualização.
    * @JsonIgnore - Oculta o campo nas respostas JSON.
    */
   @JsonIgnore
   @LastModifiedDate
   private LocalDate dataUltimaModificacao;

   /**
    * Armazena o ID do usuário responsável pela criação da entidade.
    * Pode ser preenchido manualmente ou automaticamente, dependendo da lógica da aplicação.
    *
    * @Column - Mapeia este campo como uma coluna no banco de dados.
    * @JsonIgnore - Oculta o campo nas respostas JSON.
    */
   @JsonIgnore
   @Column
   private Long criadoPor;

   /**
    * Armazena o ID do usuário que realizou a última modificação na entidade.
    *
    * @Column - Mapeia este campo como uma coluna no banco de dados.
    * @JsonIgnore - Oculta o campo nas respostas JSON.
    */
   @JsonIgnore
   @Column
   private Long ultimaModificacaoPor;
}
