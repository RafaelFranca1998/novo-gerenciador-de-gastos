package com.rafael.gerenciador.main.services;

import java.util.List;

import com.rafael.gerenciador.main.domain.Items;

public interface ItemService {
	
	void salvar(Items item);
	
	void editar(Items item);
	
	void excluir(Long id);
	
	Items buscarPorId(Long id);
	
	List<Items> buscarTodos();

	List<Items> buscarPorNome(String nome);
}
