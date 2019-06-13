package com.rafael.gerenciador.main.services;

import java.util.List;

import com.rafael.gerenciador.main.domain.Year;

public interface YearService {
	
	void salvar(Year year );
	
	void editar(Year year);
	
	void excluir(Long id);
	
	Year buscarPorId(Long id);
	
	List<Year> buscarTodos();

	boolean depertamentoTemCargos(Long id);
}
