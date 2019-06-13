package com.rafael.gerenciador.main.services;

import java.util.List;

import com.rafael.gerenciador.main.domain.Month;

public interface MonthService {
	
	void salvar(Month cargo);

	void editar(Month cargo);

	void excluir(Long id);

	Month buscarPorId(Long id);

	List<Month> buscarTodos();

	boolean cargoTemFuncionarios(Long id);
}
