package modelo;

import java.math.BigDecimal;

public class Curso {

	
	private String nome;
	
	private BigDecimal preco;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Curso [nome=" + nome + ", preco=" + preco + "]";
	}
	
	

	
}
