package threeway.projeto.servico.modelo;

/*
 Código SQL para criar a tabela no postgres

CREATE TABLE livro (
COD_LIVRO SERIAL NOT NULL,
TITULO VARCHAR(30) NOT NULL,
AUTOR VARCHAR(20) NOT NULL,
PRECO NUMERIC NOT NULL,
IMAGEM VARCHAR(80) NOT NULL,
DESCRICAO VARCHAR(80),
PRIMARY KEY (COD_LIVRO)
);

 */

public class Livro {
	
	private int codigo;
	private String titulo;
	private String autor;
	private double preco;
	private String imagem;
	private String descricao;
	
	
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
