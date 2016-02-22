package bancodados.cadastro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrdemDeServico {
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private String data;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	private String solicitante;

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	private String executante;

	public String getExecutante() {
		return executante;
	}

	public void setExecutante(String executante) {
		this.executante = executante;
	}

	public void incluir() {
		try {
			// Obtém a conexão.
			String url = "jdbc:derby:C:\\banco-de-teste;create=true";
			Connection conn = DriverManager.getConnection(url);
			// Cria a sentença SQL.
			String sql = "insert into ordemDeServico (id, data, solicitante, executante) values (?, ?, ?, ?)";
			// Obtém referência para uma sentença SQL.
			PreparedStatement prepareStatement = conn.prepareStatement(sql);
			prepareStatement.setString(1, id);
			prepareStatement.setString(2, data);
			prepareStatement.setString(3, solicitante);
			prepareStatement.setString(4, executante);
			// Executa a instrução SQL.
			prepareStatement.executeUpdate();
			// Fecha a sentença.
			prepareStatement.close();
			// Fecha a conexão.
			conn.close();
		} catch (Throwable e) {
			// Para repassar a exceção para o container tratar.
			throw new RuntimeException(e);
		}
	}

	public void alterar(String id1, String data1, String solicitante1, String executante1) {
		try {
			// Obtém a conexão.
			String url = "jdbc:derby:C:\\banco-de-teste";
			Connection conn = DriverManager.getConnection(url);
			// Cria a sentença SQL.
			String sql = "update ordemDeServico set data=?, solicitante=?, executante=? where id=?";
			// Obtém referência para uma sentença SQL.
			PreparedStatement prepareStatement = conn.prepareStatement(sql);
			prepareStatement.setString(4, id);
			prepareStatement.setString(1, data);
			prepareStatement.setString(2, solicitante);
			prepareStatement.setString(3, executante);
			// Executa a instrução SQL.
			prepareStatement.executeUpdate();
			// Fecha a sentença.
			prepareStatement.close();
			// Fecha a conexão.
			conn.close();
		} catch (Throwable e) {
			// Para repassar a exceção para o container tratar.
			throw new RuntimeException(e);
		}
	}

	public void excluir(String id1) {
		try {
			// Obtém a conexão.
			String url = "jdbc:derby:C:\\banco-de-teste";
			Connection conn = DriverManager.getConnection(url);
			// Cria a sentença SQL.
			String sql = "delete from ordemDeServico where id=?";
			// Obtém referência para uma sentença SQL.
			PreparedStatement prepareStatement = conn.prepareStatement(sql);
			prepareStatement.setString(1, id1);
			// Executa a instrução SQL.
			prepareStatement.executeUpdate();
			prepareStatement.close();
			conn.close();
		} catch (Throwable e) {
			// Para repassar a exceção para o container tratar.
			throw new RuntimeException(e);
		}
	}
	
	public static List<OrdemDeServico> listar() {
	    List<OrdemDeServico> ordemDeServicos = new ArrayList<OrdemDeServico>();
	    try {
	      
	      //Obtém a conexão.
	      String url = "jdbc:derby:C:\\banco-de-teste;create=true";
	      Connection conn = DriverManager.getConnection(url);
	      //Cria a sentença SQL.
	      String sql = "select * from ordemDeServico order by id";
	      //Obtém referência para uma sentença SQL.
	      PreparedStatement prepareStatement = conn.prepareStatement(sql);
	      //Executa a instrução SQL.
	      ResultSet rs = prepareStatement.executeQuery();
	      while (rs.next()) {

	        OrdemDeServico a = new OrdemDeServico();
	        a.setId(rs.getString("id"));
	        a.setData(rs.getString("data"));
	        a.setSolicitante(rs.getString("solicitante"));
	        a.setExecutante(rs.getString("executante"));

	        ordemDeServicos.add(a);
	      }
	      //Fecha o ResultSet.
	      rs.close();
	      //Fecha a sentença.
	      prepareStatement.close();
	      //Fecha a conexão.
	      conn.close();
	    } catch (Throwable e) {
	      //Para repassar a exceção para o container tratar.
	      throw new RuntimeException(e);
	    }

	    return ordemDeServicos;
	}

}

