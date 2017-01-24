package br.com.crud_restful.service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.crud_restful.model.Usuario;
import br.com.crud_restful.service.AbstractPersistence;

public class UsuarioService extends AbstractPersistence<Usuario, Long>{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public UsuarioService() {
		super(Usuario.class);
	}
	
	public Usuario findByLoginESenha(String login, String senha){
		StringBuilder sb = new StringBuilder();
		
		sb.append("select usuario from Usuario as usuario ");
		sb.append("where usuario.login = :login ");
		sb.append("and usuario.senha = :senha ");
		sb.append("and usuario.ativo = true ");
		
		Query query = em.createQuery(sb.toString());
		query.setParameter("login", login);
		query.setParameter("senha", senha);

		try {  
			return (Usuario) query.getSingleResult();  
		} catch (NoResultException nre) {  
		    return null;  
		} 
	}
	
	public Usuario findByLogin(String login){
		StringBuilder sb = new StringBuilder();
		
		sb.append("select usuario from Usuario as usuario ");
		sb.append("where usuario.login = :login ");
		sb.append("where usuario.ativo = true ");
		
		Query query = em.createQuery(sb.toString());
		query.setParameter("login", login);

		try {  
			return (Usuario) query.getSingleResult();  
		} catch (NoResultException nre) {  
		    return null;  
		} 
	}
		
}
