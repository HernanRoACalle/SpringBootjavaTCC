package com.etec.fiatuno.repository;

import com.etec.fiatuno.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface usuarioRepository extends JpaRepository<Usuario, Long> {
}
