package med.voll.api.repositories;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.voll.api.models.Medico;
import med.voll.api.models.enums.Especialidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findAllByAtivoTrue(Pageable paginacao);

    @Query("""
        SELECT m FROM Medico m
        WHERE
        m.ativo = true
        AND
        m.especialidade = :especialidade
        AND
        m.id NOT IN(
            SELECT c.medico.id from Consulta c
            WHERE
            c.data = :data
            AND
            c.motivoCancelamento is null
      )
    ORDER BY function('RAND')       
""")
    Page<Medico> escolherMedicoAleatorioLivreNaData(
            @Param("especialidade") Especialidade especialidade,
            @Param("data") LocalDateTime data,
            Pageable pageable
    );

    @Query("""
            select m.ativo
            from Medico m
            where
            m.id = :id
            """)
    Boolean findAtivoById(Long id);
}
