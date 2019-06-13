package com.rafael.gerenciador.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.rafael.gerenciador.main.dao.ItemDao;
import com.rafael.gerenciador.main.domain.Items;

@Service
@Transactional(readOnly = false)
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDao dao;

	@Override
	public void salvar(Items item) {
		dao.save(item);

	}

	@Override
	public void editar(Items item) {
		dao.update(item);

	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);

	}

	@Override
	public Items buscarPorId(Long id) {
		return dao.findById(id);

	}

	@Override
	public List<Items> buscarTodos() {
		return dao.findAll();
	}

	@Override
	public List<Items> buscarPorNome(String nome) {
		return dao.findByName(nome);
	}



	/*
	 * @Override public List<Items> buscarPorDatas(LocalDate entrada, LocalDate
	 * saida) { if (entrada != null && saida != null) { return
	 * dao.findByDataEntradaDataSaida(entrada, saida); } else if (entrada != null) {
	 * return dao.findByDataEntrada(entrada); } else if (saida != null) { return
	 * dao.findByDataSaida(saida); } else { return new ArrayList<>(); }
	 * 
	 * }
	 */

}
