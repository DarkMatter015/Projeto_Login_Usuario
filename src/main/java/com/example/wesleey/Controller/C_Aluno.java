package com.example.wesleey.Controller;

import com.example.wesleey.Service.S_Aluno;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class C_Aluno {

    @GetMapping("/cadAluno")
    public String getCadAluno(HttpSession session){
        if(session.getAttribute("usuario") != null){
            return "Aluno/cadAluno";
        }else{
            return "redirect:/";
        }
    }

    @PostMapping("/cadAluno")
    @ResponseBody
    public String postCadAluno(@RequestParam("nome") String nome,
                               @RequestParam("dtNascimento") String dtNascimento,
                               @RequestParam("email") String email,
                               Model model){
       if(S_Aluno.cadastrarAluno(nome, email, dtNascimento) != null){


           return "Deu boa";
       }else{


           return "Tenta de novo";
       }

    }

}