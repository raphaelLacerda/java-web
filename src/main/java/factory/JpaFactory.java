package factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaFactory {

	private static EntityManagerFactory emf;

	static {
		emf = Persistence.createEntityManagerFactory("estrategia");
	}

	public static EntityManager getEntityManager() {

		return emf.createEntityManager();
	}

	public static void main(String[] args) {
		System.out.println(getEntityManager());
	}

}
