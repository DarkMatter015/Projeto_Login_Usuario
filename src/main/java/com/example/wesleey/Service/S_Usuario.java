package com.example.wesleey.Service;

import com.example.wesleey.Model.M_Usuario;
import com.example.wesleey.Repository.R_Usuario;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class S_Usuario {

    private static R_Usuario rUsuario;

    public S_Usuario(R_Usuario rUsuario) {
        this.rUsuario = rUsuario;
    }

    public static List<M_Usuario> listarUsuarios() {
        return rUsuario.listarUsuarios();
    }

    public static M_Usuario cadastrarUsuario(String usuario, String senha, String confSenha) {
        boolean podeSalvar = true;

        if (usuario.trim().equals("") || usuario == null) {
            podeSalvar = false;
        } else if (senha.trim().equals("") || senha == null) {
            podeSalvar = false;
        } else if (!senha.equals(confSenha)) {
            podeSalvar = false;
        }

        if (podeSalvar) {
            M_Usuario mUsuario = new M_Usuario();

            mUsuario.setUsuario(usuario.trim());
            mUsuario.setSenha(senha.trim());

            try {
                mUsuario = rUsuario.save(mUsuario);

                return mUsuario;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }

}
