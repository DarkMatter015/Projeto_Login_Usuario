package com.example.wesleey.Repository;

import com.example.wesleey.Model.M_Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface R_Aluno extends JpaRepository<M_Aluno, Long> {

}