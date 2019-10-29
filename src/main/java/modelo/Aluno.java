package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	private String email;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Curso> cursos = new ArrayList<>();

	public Aluno(){
		
	}
	
	
	public Aluno(Integer id, String nome, String email, List<Curso> cursos) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cursos = cursos;
	}

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
