package threeway.projeto.servico.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import threeway.projeto.servico.modelo.Livro;

public class LivroDAO {
	
	
	public void inserir (String titulo){
		
		ArrayList<Livro> lista = new ArrayList<Livro>();
		
		final String CONSULTAR_SQL = "INSERT INTO LIVROS (titulo,autor,preco,imagem,descricao) VALUES (?,?,?,?)";
		
		try (Connection conexao = FabricaConexao.getConexao();
				PreparedStatement inserir = conexao.prepareStatement(CONSULTAR_SQL);){
			inserir.setString(1, "%" + titulo.toUpperCase()+"%");
			
			ResultSet resultado = inserir.executeQuery();
			
			while(resultado.next()) {
				Livro livro = new Livro();
				livro.setAutor(resultado.getString("AUTOR"));
				livro.setCodigo(resultado.getInt("COD_LIVRO"));
				livro.setImagem(resultado.getString("IMAGEM"));
				livro.setPreco(resultado.getDouble("PRECO"));
				livro.setTitulo(resultado.getString("TITULO"));
				livro.setDescricao(resultado.getString("DESCRICAO"));

			}
			
			resultado.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	

	public List<Livro> consultar (String titulo){
		
		ArrayList<Livro> lista = new ArrayList<Livro>();
		
		final String CONSULTAR_SQL = "SELECT *FROM LIVRO WHERE TITULO LIKE ?";
		
		try (Connection conexao = FabricaConexao.getConexao();
				PreparedStatement consulta = conexao.prepareStatement(CONSULTAR_SQL);){
			consulta.setString(1, "%" + titulo.toUpperCase()+"%");
			
			ResultSet resultado = consulta.executeQuery();
			
			while(resultado.next()) {
				Livro livro = new Livro();
				livro.setAutor(resultado.getString("AUTOR"));
				livro.setCodigo(resultado.getInt("COD_LIVRO"));
				livro.setImagem(resultado.getString("IMAGEM"));
				livro.setPreco(resultado.getDouble("PRECO"));
				livro.setTitulo(resultado.getString("TITULO"));
				livro.setDescricao(resultado.getString("DESCRICAO"));
				lista.add(livro);
			}
			
			resultado.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	
public Livro consultarID (int codigo){
		
		Livro livro = null;
		
	
		final String CONSULTAR_SQL = "SELECT *FROM LIVRO WHERE COD_LIVRO = ?";
		
		try (Connection conexao = FabricaConexao.getConexao();
				PreparedStatement consultaid = conexao.prepareStatement(CONSULTAR_SQL);){
			consultaid.setInt(1, codigo);
			

			ResultSet resultado = consultaid.executeQuery();
			
			if(resultado.next()) {
				livro = new Livro();
				livro.setAutor(resultado.getString("AUTOR"));
				livro.setCodigo(resultado.getInt("COD_LIVRO"));
				livro.setImagem(resultado.getString("IMAGEM"));
				livro.setPreco(resultado.getDouble("PRECO"));
				livro.setTitulo(resultado.getString("TITULO"));
				livro.setDescricao(resultado.getString("DESCRICAO"));
			}
			
			resultado.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return livro;
		
	}
	
public void deletar (int codigo){
	

	final String CONSULTAR_SQL = "DELETE FROM LIVRO WHERE COD_LIVRO = ?";
	
	try (Connection conexao = FabricaConexao.getConexao();
			PreparedStatement consultaid = conexao.prepareStatement(CONSULTAR_SQL);){
		consultaid.setInt(1, codigo);
				
		consultaid.execute();

	} catch (SQLException e) {
		e.printStackTrace();
	}

	
}

public void updateTitulo (Livro livro){
	

	String UPDATE_SQL = "UPDATE LIVRO SET TITULO = WHERE COD_LIVRO = ?";
	
	//Cria uma conexao com o banco
	//Cria um preparedStatment, classe usada para executar a query
	try (Connection conexao = FabricaConexao.getConexao();
			PreparedStatement consultaid = conexao.prepareStatement(UPDATE_SQL);){

		//adicionar o valor do primeiro parametro da sql
		consultaid.setString(1, livro.getTitulo());
		consultaid.setInt(2, livro.getCodigo());
		
		//Executa o sql para inserção dos dados
		consultaid.execute();

	} catch (SQLException e) {
		e.printStackTrace();
	}

	
}
	

	
	public static void main(String[] args) {
		String titulo = "filosofia";
		
		LivroDAO dao = new LivroDAO();
		dao.consultar(titulo).forEach(
				p -> System.out.println("Desc: " + p.getTitulo() + " Preço: " + p.getPreco()));
	}
}
