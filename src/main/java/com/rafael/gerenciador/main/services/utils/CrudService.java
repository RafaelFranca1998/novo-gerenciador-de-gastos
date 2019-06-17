package com.rafael.gerenciador.main.services.utils;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.rafael.gerenciador.main.services.exceptions.DataIntegrityException;
import com.rafael.gerenciador.main.services.exceptions.ObjectNotFoundException;

/**
 * @author Michel Mendes	10/01/2019
 * Classe generica de serviços que contem os métodos CRUD
 */
@Service
public abstract class CrudService<Entity, Repo extends JpaRepository<Entity, ID>, ID> {

	@Autowired
	private Repo repository;
	
	public List<Entity> findAll() {
		return repository.findAll();
	}
	
	public List<Entity> findAll(Sort sort) {
		return repository.findAll(sort);
	}
	
	public Entity findById(ID id) {
		Optional<Entity> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: " + id ));
	}
	
	public Page<Entity> findPage(Integer page, Integer size, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}
	
	public Entity insert(Entity obj) {
		return repository.save(obj);
	}
	
	public Entity update(ID id, Entity obj) {
		Entity currentObj = findById(id);
		updateData(currentObj, obj);
		return repository.save(currentObj);
	}
	
	public void delete(ID id) {
		findById(id);
		try {
			repository.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("You can not delete this object because it contains associated child objects");
		} 
	}
	
	/**
	 * Antes de fazer um update em uma tabela, é necessário fazer um findById para obter o objeto com todos os seus atributos, 
	 * e então alterar apenas os campos que deseja ser alterado, evitando que apague atributos que não chegaram por parâmetro.
	 * Esse método faz exatamente isso, diz quais são os campos que podem ser alterados
	 * @param currentObj como está na base de dados
	 * @param newObj obj que será alterado
	 * @return
	 */
	protected abstract void updateData(Entity currentObj, Entity newObj);
		
}
