package com.sanmardan.GestionGastosBackend.Services;

import com.sanmardan.GestionGastosBackend.Model.Usuario;
import java.util.List;

public interface UsuarioService {
    List<Usuario> listarUsuarios();
    Usuario buscarUsuarioPorId(int id);
    Usuario crearUsuario(Usuario usuario);
    Usuario actualizarUsuario(int id, Usuario usuario);
    void eliminarUsuario(int id);
}
