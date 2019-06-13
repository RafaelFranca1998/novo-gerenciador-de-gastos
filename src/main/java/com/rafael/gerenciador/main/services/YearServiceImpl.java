package com.rafael.gerenciador.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafael.gerenciador.main.dao.YearDao;
import com.rafael.gerenciador.main.domain.Year;


@Service
@Transactional(readOnly = false)
public class YearServiceImpl implements YearService {

	@Autowired
	private YearDao dao;

	@Override
	public void salvar(Year departamento) {
		dao.save(departamento);
	}

	@Override
	public void editar(Year departamento) {
		dao.update(departamento);
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Year buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Year> buscarTodos() {
		return dao.findAll();
	}

	@Override
	public boolean depertamentoTemCargos(Long id) {
		// TODO Auto-generated method stub
		return false;
	}



}
