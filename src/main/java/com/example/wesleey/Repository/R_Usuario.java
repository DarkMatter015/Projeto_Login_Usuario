package com.example.wesleey.Repository;

import com.example.wesleey.Model.M_Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface R_Usuario extends JpaRepository<M_Usuario, Long> {
    @Query(value = "select * from usuario where usuario = :usuario and senha = :senha LIMIT 1", nativeQuery = true)
    M_Usuario buscaUsuarioLogin(@Param("usuario") String usuario, @Param("senha") String senha);
}
