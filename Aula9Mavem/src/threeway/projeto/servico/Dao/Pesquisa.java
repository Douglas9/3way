package threeway.projeto.servico.Dao;

import javax.swing.JOptionPane;

import threeway.projeto.servico.modelo.Livro;

public class Pesquisa {

	static LivroDAO dao = new LivroDAO();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//testarConsulta();
		//testarConsultaid();

		//deletar();
		atualizar(1);
		

	}

	public static void testarConsulta() {
		
		String titulo = "GRANDE SERTAO - VEREDAS";
		
		for(Livro livro : dao.consultar(titulo)) {
			System.out.println("Cod: " + livro.getCodigo() + " \tDesc: \t"+ livro.getTitulo());
		}
	}
	
	public static void testarConsultaid() {
		
		Livro livro = dao.consultarID(1);
		System.out.println(livro.getCodigo() +" "+livro.getTitulo() +" " + livro.getAutor());
		
	}
	
	public static void deletar() {
		
		int id= 0;
		
		id = Integer.parseInt(JOptionPane.showInputDialog("Informe qual o codigo a ser deletado"));
		
		dao.deletar(id);
		
	}
	
	public static void atualizar(int codigo) {
		
		Livro livro = new Livro();
		
		livro.setTitulo("Valores inseridos");
		
		dao.updateTitulo(livro);
		
	}
		
	
}
