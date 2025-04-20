package br.com.ifpe.oxefood.api.produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProdutoRequest {

    @NotBlank(message = "O código do produto é obrigatório.")
    @Size(max = 50, message = "O código do produto deve ter no máximo 50 caracteres.")
    private String codigo;

    @NotBlank(message = "O título do produto é obrigatório.")
    @Size(max = 100, message = "O título do produto deve ter no máximo 100 caracteres.")
    private String titulo;

    @NotBlank(message = "A descrição do produto é obrigatória.")
    @Size(max = 255, message = "A descrição do produto deve ter no máximo 255 caracteres.")
    private String descricao;

    @NotNull(message = "O valor unitário do produto é obrigatório.")
    private Double valorUnitario;

    @NotNull(message = "O tempo de entrega mínimo é obrigatório.")
    private Integer tempoEntregaMinimo;

    @NotNull(message = "O tempo de entrega máximo é obrigatório.")
    private Integer tempoEntregaMaximo;

    public Object build() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'build'");
    }
}
