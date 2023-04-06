package br.com.thesafeway.estagioteste.LojaOnline.services;

import br.com.thesafeway.estagioteste.LojaOnline.dtos.UsuarioDto;
import br.com.thesafeway.estagioteste.LojaOnline.models.Usuario;
import br.com.thesafeway.estagioteste.LojaOnline.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvarUsuario(UsuarioDto usuarioDto) {
        var usuario = new Usuario(
          usuarioDto.getNome(),
          usuarioDto.getCpf(),
          usuarioDto.getEmail(),
          new HashSet<>()
        );
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarUsuario(Long id){
        return buscarPorId(id).orElseThrow();
    }

    public Usuario editarUsuario(UsuarioDto usuarioDto){
        var usuarioData = buscarUsuario(usuarioDto.getId());
        usuarioData.setNome(usuarioDto.getNome());
        usuarioData.setEmail(usuarioDto.getEmail());
        return usuarioRepository.save(usuarioData);
    }

    public void deletarUsuario(Long id){
        usuarioRepository.delete(buscarUsuario(id));
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }
}
