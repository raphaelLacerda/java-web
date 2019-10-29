package modelo;

import java.util.ArrayList;
import java.util.List;

public class Aluno {

	private Integer id;
	
	private String nome;
	
	private String email;
	
	private List<Curso> cursos = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", email=" + email + ", cursos=" + cursos + "]";
	}
	

	
	
	
}
