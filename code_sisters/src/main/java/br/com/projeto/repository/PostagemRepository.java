package br.com.projeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.model.PostagemModel;

public interface PostagemRepository extends JpaRepository<PostagemModel, Long> {

	//INSERINDO MÉTODOS PERSONALIZADOS
	
	
	public List<PostagemModel> findAllByTituloIgnoreCaseContaining(String titulo);

//	@Query(value = "Select * from tb_postagem where ano > 2011", nativeQuery = true)
//	List <PostagemModel> findAllMaior();
//	
//	@Query(value = "Select * from tb_postagem where ano > 2011 ORDER BY ano DESC", nativeQuery = true)
//	List <PostagemModel> anosDesc();
//	
//	@Query(value = "Select * from tb_postagem where ano > 2011 ORDER BY ano ASC", nativeQuery = true)
//	List <PostagemModel> anosAsc();
//	
//	@Query(value = "Select * from tb_postagem where ano >= 2011 and ano <=13 ", nativeQuery = true)
//	List <PostagemModel> anosIntervalos();
	
}
