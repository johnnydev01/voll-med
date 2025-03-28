package med.voll.api.dtos;

import med.voll.api.models.Endereco;
import med.voll.api.models.enums.Especialidade;
import med.voll.api.models.Medico;

public record DadosDetalhamentoMedico(Long id, String nome, String email, String telefone, String crm, Especialidade especialidade, Endereco endereco) {
    public DadosDetalhamentoMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getTelefone(), medico.getCrm(), medico.getEspecialidade(), medico.getEndereco());
    }
}
