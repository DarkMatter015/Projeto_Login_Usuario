package com.example.wesleey.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class C_Turma {

    @GetMapping("/cadTurma")
    public String getCadTurma(){
        return "Turma/cadTurma";
    }

    @PostMapping("/cadTurma")
    @ResponseBody
    public String postCadTurma(@RequestParam("nome") String nome,
                               @RequestParam("ano") String ano){
        return "chegou certinho";
    }
}
