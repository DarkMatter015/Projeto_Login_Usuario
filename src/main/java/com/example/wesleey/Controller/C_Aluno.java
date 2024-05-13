package com.example.wesleey.Controller;

import com.example.wesleey.Service.S_Aluno;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String postCadAluno(@RequestParam("nome") String nome,
                               @RequestParam("dtNascimento") String dtNascimento,
                               @RequestParam("email") String email,
                               Model model){
       if(S_Aluno.cadastrarAluno(nome, email, dtNascimento) != null){
           model.addAttribute("mensagem", "Aluno cadastrado com sucesso!");
           model.addAttribute("bg", "success");
           model.addAttribute("tipo", "Sucesso!");
       }else{
           model.addAttribute("mensagem", "Erro ao cadastrar o aluno!");
           model.addAttribute("bg", "danger");
           model.addAttribute("tipo", "Erro!");

           model.addAttribute("nome", nome);
           model.addAttribute("email", email);
           model.addAttribute(("dtNascimento"), dtNascimento);
       }



        return "Aluno/cadAluno";
    }

}