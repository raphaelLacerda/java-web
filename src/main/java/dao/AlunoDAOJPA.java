package dao;

import java.util.List;

import javax.persistence.EntityManager;

import modelo.Aluno;

public class AlunoDAOJPA {

	private EntityManager em;

	public AlunoDAOJPA(EntityManager em) {
		this.em = em;

	}

	public Aluno salvar(Aluno aluno) {

		this.em.getTransaction().begin();
		this.em.persist(aluno);
		this.em.getTransaction().commit();
		return aluno;
	}

	@SuppressWarnings("unchecked")
	public List<Aluno> listar() {

		return this.em.createQuery("SELECT a FROM Aluno a").getResultList();
	}

	
	
	
}
