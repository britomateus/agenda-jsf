package br.com.esig.agendajsf.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Mateus Brito
 */

//Classe para inicializar o processo de tratamento dos dados
public class InitDAO {
	
	private static EntityManagerFactory factory = null;
	
	//Executa apenas uma vez, e cria a tabela no banco, caso ela já não exista
	static {
		if(factory == null) {
			factory = Persistence.createEntityManagerFactory("agendajsf");
		}
	}
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
	
	
	public static Object getPK(Object entity) {
		return factory.getPersistenceUnitUtil().getIdentifier(entity);
	}

}
