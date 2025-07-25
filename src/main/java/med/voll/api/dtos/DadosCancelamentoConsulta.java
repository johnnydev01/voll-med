package med.voll.api.dtos;

import jakarta.validation.constraints.NotNull;
import med.voll.api.models.enums.MotivoCancelamento;

public record DadosCancelamentoConsulta(
        @NotNull
        Long idConsulta,

        @NotNull
        MotivoCancelamento motivo
) {
}
