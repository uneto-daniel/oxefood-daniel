// Define o pacote onde essa classe está localizada no projeto.
package br.com.ifpe.oxefood.api.cliente;

// Importa a classe LocalDate para lidar com datas (ex: data de nascimento).
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

// Importa a classe Cliente, que representa a entidade do banco de dados.
import br.com.ifpe.oxefood.modelo.cliente.Cliente;

// As anotações abaixo fazem parte do projeto Lombok e reduzem a quantidade de código repetitivo.

// Gera automaticamente os métodos getters, setters, equals, hashCode e toString.
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Lombok: Gera getters, setters, toString, equals e hashCode.
@Builder // Lombok: Permite usar o padrão de projeto Builder para criar objetos.
@NoArgsConstructor // Lombok: Cria um construtor sem argumentos.
@AllArgsConstructor // Lombok: Cria um construtor com todos os atributos da classe.
public class ClienteRequest {

   // Nome do cliente.
   private String nome;
   // Define o formato da data no JSON como "dia/mês/ano" (ex: 25/12/2024).
// Isso é usado tanto na entrada (requisição) quanto na saída (resposta) da API.
// Sem essa anotação, o formato padrão seria "yyyy-MM-dd" (ex: 2024-12-25).
   @JsonFormat(pattern = "dd/MM/yyyy")

   // Data de nascimento do cliente.
   private LocalDate dataNascimento;

   // CPF do cliente.
   private String cpf;

   // Número de telefone celular do cliente.
   private String foneCelular;

   // Número de telefone fixo do cliente.
   private String foneFixo;

   // Método que converte este DTO (ClienteRequest) em uma entidade Cliente.
   public Cliente build() {

       // Retorna um objeto Cliente usando o padrão Builder,
       // preenchendo os campos com os dados fornecidos neste DTO.
       return Cliente.builder()
           .nome(nome)
           .dataNascimento(dataNascimento)
           .cpf(cpf)
           .foneCelular(foneCelular)
           .foneFixo(foneFixo)
           .build();
   }
}
