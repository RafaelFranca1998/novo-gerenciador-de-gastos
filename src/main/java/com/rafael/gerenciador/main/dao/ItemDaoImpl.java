package com.rafael.gerenciador.main.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rafael.gerenciador.main.domain.Items;

@Repository
public class ItemDaoImpl  extends AbstractDao<Items, Long> implements ItemDao {

	@Override
	public List<Items> findByName(String nome) {
		return createQuery("select i from Items t where t.nome like concat ('%',?1,'%')", nome);
	}

}
