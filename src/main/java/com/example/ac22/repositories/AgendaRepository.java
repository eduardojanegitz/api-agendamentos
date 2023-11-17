package com.example.ac22.repositories;

import com.example.ac22.models.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    @Query("SELECT A FROM AGENDA A WHERE A.professor.id = :id")
    List<Agenda> agendasDoProfessor(@Param("id") Long id);

    @Query("SELECT A FROM AGENDA A WHERE A.dataInicial <= :data AND A.dataFinal >= :data AND A.professor.id = :id")
    List<Agenda> agendasProfessorPorData(@Param("id") Long id,
            @Param("data") LocalDate data);
}
