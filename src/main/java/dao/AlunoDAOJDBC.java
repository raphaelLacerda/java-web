package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import modelo.Aluno;

public class AlunoDAOJDBC {

	private Connection conexao;

	public AlunoDAOJDBC(Connection conexao) {
		this.conexao = conexao;
	}

	public Aluno salvar(Aluno aluno) {

		try {
			PreparedStatement ps = conexao.prepareStatement("insert into aluno (nome, email) values (?, ?)");
			ps.setString(1, aluno.getNome());
			ps.setString(2, aluno.getEmail());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return aluno;
	}

	public List<Aluno> listar() {

		List<Aluno> alunos = new ArrayList<>();
		try {
			ResultSet rs = conexao.prepareStatement("select * from aluno").executeQuery();
			while (rs.next()) {

				alunos.add(new Aluno(rs.getInt("id"), rs.getString("nome"), rs.getString("email"),
						Collections.emptyList()));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return alunos;

	}

}
