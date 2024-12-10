package com.sanmardan.GestionGastosBackend.ServicesImpl;

import com.sanmardan.GestionGastosBackend.Model.Usuario;
import com.sanmardan.GestionGastosBackend.Repository.UsuarioRepository;
import com.sanmardan.GestionGastosBackend.Services.UsuarioService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, BCryptPasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario buscarUsuarioPorId(int id) {
        return usuarioRepository.findById(id).orElseThrow(() -> 
            new RuntimeException("Usuario no encontrado con ID: " + id));
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        usuario.setContraseña(passwordEncoder.encode(usuario.getContraseña()));
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario actualizarUsuario(int id, Usuario usuario) {
        Usuario usuarioExistente = buscarUsuarioPorId(id);

        usuarioExistente.setNombre(usuario.getNombre());
        usuarioExistente.setEmail(usuario.getEmail());

        if (usuario.getContraseña() != null && !usuario.getContraseña().isEmpty()) {
            usuarioExistente.setContraseña(passwordEncoder.encode(usuario.getContraseña()));
        }

        return usuarioRepository.save(usuarioExistente);
    }

    @Override
    public void eliminarUsuario(int id) {
        usuarioRepository.deleteById(id);
    }
}
