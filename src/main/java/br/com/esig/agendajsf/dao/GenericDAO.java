package br.com.esig.agendajsf.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @author Mateus Brito
 */

//Classe de persistência genérica, aplicável à classes diversas e baseada em JPA

public class GenericDAO<T> {
	
	EntityManager entityManager = null;
	EntityTransaction transaction = null;

	//entityClass é uma classe do tipo genérica
	@SuppressWarnings("unchecked")
	private Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

	//inicializa as variáveis necessárias
	private void loadDAO() {
		entityManager = InitDAO.getEntityManager();
		transaction = entityManager.getTransaction();
	}
	
	//Função para salvar uma entidade no banco
	public void save(T entity) { 
		loadDAO();
		transaction.begin(); //inicia uma transação do banco
		
	    entityManager.persist(entity); //realiza a persistência
		
		transaction.commit(); //commita a transação
		entityManager.close(); //e encerra o gerenciador do JPA
	
	}
	
	//Função para alterar uma entidade já cadastrada no banco
	public T update(T entity) { 
		loadDAO();
		transaction.begin();
		
		// metodo do gerenciador JPA que realiza o merge das informações alteradas
		//com o que está no banco e retorna a entidade alterada
		T t = entityManager.merge(entity); 
		
		transaction.commit();
		entityManager.close();
		
		return t;
	
	}
	
	//Função para deletar uma entidade do banco
	public void delete(T entity) { 
		loadDAO();
		transaction.begin();
		
		//remove a entidade do banco, por sua Primary Key
		entityManager.remove(entityManager.getReference(entityClass, InitDAO.getPK(entity))); 
		
		transaction.commit();
		entityManager.close();
	
	}
	
	
	//Função para encontrar uma entidade por sua Primary Key
	public T finById(T entity) {
		loadDAO();
		transaction.begin();
		
		T t = entityManager.find(entityClass, InitDAO.getPK(entity));
		
		transaction.commit();
		entityManager.close();
		
		return t;
	}
	
	
	//Função que retorna todas as entidades salvas no banco
	@SuppressWarnings("unchecked")
    public List<T> findAll() {
		loadDAO();
		transaction.begin();
        
		List<T> entityList = entityManager.createQuery("Select t from " + entityClass.getSimpleName() + " t").getResultList();
		
		transaction.commit();
		entityManager.close();
		
		return entityList;
    }

}
