package dao;

import java.sql.Connection;

public class AlunoDAO {

	private Connection conexao;

	public AlunoDAO(Connection conexao) {
		this.conexao = conexao;
		System.out.println(conexao);
	}

	
	
	
	
}
