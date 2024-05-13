package com.example.wesleey.Service;

import com.example.wesleey.Model.M_Aluno;
import com.example.wesleey.Repository.R_Aluno;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class S_Aluno {

    private static R_Aluno rAluno;

    public S_Aluno(R_Aluno rAluno){
        this.rAluno = rAluno;
    }

    public static M_Aluno cadastrarAluno(String nome, String email, String dtNascimento){
        M_Aluno aluno = new M_Aluno();
        aluno.setNome(nome);
        aluno.setEmail(email);


        try{
            aluno.setDtNascimento(LocalDate.parse(dtNascimento));
            aluno = rAluno.save(aluno);
            return aluno;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
