package br.com.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.model.TemaModel;
import br.com.projeto.repository.TemaRepository;

@RestController
@RequestMapping("/tema")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TemaController 
{

	@Autowired
	private TemaRepository repository;
	
	
	@GetMapping
	public ResponseEntity<List<TemaModel>> getAll()
	{
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TemaModel> getById(@PathVariable Long id)
	{
		return  repository.findById(id).map(resposta -> ResponseEntity.ok(resposta)).orElse(ResponseEntity.notFound().build());

	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<TemaModel>> getByNome(@PathVariable String nome)
	{
		return ResponseEntity.ok(repository.findAllByNomeIgnoreCaseContaining(nome));
	}
	
	@PostMapping
	public ResponseEntity<TemaModel> post(@RequestBody TemaModel tema)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TemaModel> post(@PathVariable Long id, @RequestBody TemaModel tema)
	{
		tema.setId_tema(id);
		return  repository.findById(id).map(resposta -> ResponseEntity.ok(repository.save(tema))).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) 
	{
		repository.deleteById(id);
	}
	
	
	
}
