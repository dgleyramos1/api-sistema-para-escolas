package com.escolar.Repository;

import com.escolar.Entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AlunoRepo extends JpaRepository<Aluno, Long> {
}
