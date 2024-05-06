package com.example.wesleey.Service;

import com.example.wesleey.Model.M_Usuario;
import com.example.wesleey.Repository.R_Usuario;
import org.springframework.stereotype.Service;

@Service
public class S_Login {

    private static R_Usuario rUsuario;

    public S_Login(R_Usuario rUsuario){
        this.rUsuario = rUsuario;
    }

    public static M_Usuario validaLogin(String usuario, String senha){
        return rUsuario.buscaUsuarioLogin(usuario, senha);
    }

}
