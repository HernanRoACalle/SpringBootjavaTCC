//Daniel Alves - RM: 251376
//Hernan Rodrigo - RM:251169

package com.etec.fiatuno.controller;

import com.etec.fiatuno.entity.Usuario;
import com.etec.fiatuno.repository.usuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private usuarioRepository repository;

    // 🟢 LISTAR TODOS OS USUÁRIOS
    @GetMapping
    public List<Usuario> listar() {
        return repository.findAll();
    }

    // 🟡 BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable long id) {
        Optional<Usuario> usuario = repository.findById(id);
        return usuario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 🔵 CADASTRAR NOVO USUÁRIO
    @PostMapping
    public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario) {
        Usuario novoUsuario = repository.save(usuario);
        return ResponseEntity.ok(novoUsuario);
    }

    // 🟣 ATUALIZAR USUÁRIO EXISTENTE
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> alterar(@PathVariable long id, @RequestBody Usuario usuarioAtualizado) {
        Optional<Usuario> usuarioExistente = repository.findById(id);

        if (usuarioExistente.isPresent()) {
            Usuario usuario = usuarioExistente.get();
            usuario.setNome(usuarioAtualizado.getNome());
            usuario.setSobrenome(usuarioAtualizado.getSobrenome());
            usuario.setEmail(usuarioAtualizado.getEmail());
            usuario.setTelefone(usuarioAtualizado.getTelefone());
            usuario.setTipoUsuario(usuarioAtualizado.getTipoUsuario());
            usuario.setDescricao(usuarioAtualizado.getDescricao());
            usuario.setMinEntrada(usuarioAtualizado.getMinEntrada());
            usuario.setMaxEntrada(usuarioAtualizado.getMaxEntrada());
            repository.save(usuario);
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 🔴 EXCLUIR USUÁRIO
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable long id) {
        Optional<Usuario> usuario = repository.findById(id);

        if (usuario.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build(); // 204
        } else {
            return ResponseEntity.notFound().build(); // 404
        }
    }
}
