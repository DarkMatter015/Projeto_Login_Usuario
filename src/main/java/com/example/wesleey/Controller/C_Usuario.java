package com.example.wesleey.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class C_Usuario {

    @GetMapping("/listar")
    public String listaUsuarios(){
        return "Usuario/pv_listaUsuario";
    }
}
