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
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.projeto.model.PostagemModel;
import br.com.projeto.repository.PostagemRepository;

@RestController
@CrossOrigin("*") // Aqui significa que vai rodar em qulquer navegador- celular ou desktop
@RequestMapping("/postagem")
public class PostagemController implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry index) {
		index.addViewController("/").setViewName("forward:/index.html");
	}

	// INJETANDO O REPOSITORY
	@Autowired
	private PostagemRepository repository;

	@GetMapping
	public ResponseEntity<List<PostagemModel>> findAllPostagem() {
		return ResponseEntity.ok(repository.findAll());
	}

//	@GetMapping(value = "/maior")
//	public ResponseEntity<List<PostagemModel>> findAllMaior() {
//		return ResponseEntity.ok(repository.findAllMaior());
//	}
//
//	@GetMapping(value = "/ordem")
//	public ResponseEntity<List<PostagemModel>> anosDesc() {
//		return ResponseEntity.ok(repository.anosDesc());
//	}
//
//	@GetMapping(value = "/intervalo")
//	public ResponseEntity<List<PostagemModel>> anosIntervalos() {
//		return ResponseEntity.ok(repository.anosIntervalos());
//	}
//
//	@GetMapping(value = "/asc")
//	public ResponseEntity<List<PostagemModel>> anosAsc() {
//		return ResponseEntity.ok(repository.anosAsc());
//	}

	@GetMapping("/{id}")
	public ResponseEntity<PostagemModel> findByIdPostagem(@PathVariable Long id) {
		return repository.findById(id).map(postagemId -> ResponseEntity.ok(postagemId))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<PostagemModel>> findAllByTitulo(@PathVariable String titulo) {
		return ResponseEntity.ok(repository.findAllByTituloIgnoreCaseContaining(titulo));
	}

	// POST- CREATE

	@PostMapping
	public ResponseEntity<PostagemModel> post(@RequestBody PostagemModel postagem) {

		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
	}

	// PUT-UPDATE
	@PutMapping("/{id}")
	public ResponseEntity<PostagemModel> atualizar(@PathVariable Long id, @RequestBody PostagemModel postagem) {
		postagem.setId(id);

		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
	}

	// DELETE
	@DeleteMapping("/{id}")
	public void remover(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
