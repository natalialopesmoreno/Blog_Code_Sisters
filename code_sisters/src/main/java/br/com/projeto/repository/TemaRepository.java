package br.com.projeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.model.TemaModel;

public interface TemaRepository extends JpaRepository<TemaModel, Long> 
{

	public List<TemaModel> findAllByNomeIgnoreCaseContaining(String nome);
	
}
