package com.example.wesleey.Controller;

import com.example.wesleey.Service.S_Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class C_Usuario {

    @GetMapping("/listar")
    public String listaUsuarios(Model model){
        model.addAttribute("usuarios", S_Usuario.listarUsuarios());
        return "Usuario/pv_listaUsuario";
    }

    @GetMapping("/cadastro")
    public String getCadastroUsuario(){
        return "Usuario/cadastro";
    }

    @PostMapping("/cadastro")
    public String postCadastroUsuario(@RequestParam("usuario") String usuario,
                                      @RequestParam("senha") String senha,
                                      @RequestParam("confSenha") String confSenha,
                                      Model model){

        if(S_Usuario.cadastrarUsuario(usuario, senha, confSenha) != null){
            model.addAttribute("error", "Cadastro efetuado com sucesso! Faça seu login.");
            return "index";
        }else{
            model.addAttribute("error", "Cadastro não efetuado! Por favor tente novamente.");
            model.addAttribute("usuario", usuario);
            return "Usuario/cadastro";
        }
    }
}
