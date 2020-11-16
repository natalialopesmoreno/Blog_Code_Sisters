package br.com.projeto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> 
{

	public Optional<Usuario> findByUsuario(String usuario);
	
}
