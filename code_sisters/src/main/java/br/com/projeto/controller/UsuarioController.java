package br.com.projeto.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.model.UserLogin;
import br.com.projeto.model.Usuario;
import br.com.projeto.seguranca.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	
	@PostMapping("/logar")
	public ResponseEntity<UserLogin> Autentication(@RequestBody Optional<UserLogin> user)
	{
		return service.Logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
		
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> Autentication(@RequestBody Usuario usuario)
	{
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(service.CadastrarUsuario(usuario));
				
		
	}
	

	

}

