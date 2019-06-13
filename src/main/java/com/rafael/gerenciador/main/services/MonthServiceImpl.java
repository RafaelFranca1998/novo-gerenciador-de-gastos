package com.rafael.gerenciador.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafael.gerenciador.main.dao.MonthDao;
import com.rafael.gerenciador.main.domain.Month;

@Service
@Transactional(readOnly = false)	
public class MonthServiceImpl implements MonthService {

	@Autowired
	private MonthDao dao;
	
	@Override
	public void salvar(Month month) {
		dao.save(month);
	}

	@Override
	public void editar(Month month) {
		dao.update(month);
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Month buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Month> buscarTodos() {
		return dao.findAll();
	}

	@Override
	public boolean cargoTemFuncionarios(Long id) {
		// TODO Auto-generated method stub
		return false;
	}



}
