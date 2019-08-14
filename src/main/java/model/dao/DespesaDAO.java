package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.vo.DespesaVO;
import model.vo.UsuarioVO;

public class DespesaDAO {
	
	static DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	public boolean verificarRegistroPorIdUsuario(int idUsuario) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
				
		String query =  "SELECT IDUSUARIO FROM USUARIO WHERE IDUSUARIO = " + idUsuario;	
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				return true;
				
			}
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query que verifica a existência de usuário por idUsuário");
			System.out.println("Erro: "+ e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int cadastrarDespesaDAO(DespesaVO despesaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
				
		String query = "INSERT INTO DESPESA (IDUSUARIO, DESCRICAO, VALOR, DATAVENCIMENTO, DATAPAGAMENTO, CATEGORIA)"
				+ "VALUES ('"+despesaVO.getIdUsuario()+"','"+despesaVO.getDescricao()+"','"+
				despesaVO.getValor()+"','"+despesaVO.getDataVencimento().format(formatador)+"','"+despesaVO.getDataPagamento().format(formatador)+"','"+despesaVO.getCategoria()+"')";	
		try {
			resultado = stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query  de cadastro de despesa");
			System.out.println("Erro: "+ e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public int atualizarDespesaDAO(DespesaVO despesaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
				
		String query = "UPDATE DESPESA SET "
				+ "IDUSUARIO = '"+ despesaVO.getIdUsuario() + "',"
				+ "DESCRICAO = '" + despesaVO.getDescricao() +"',"
				+ "VALOR = '" + despesaVO.getValor() +"', "
				+ "DATAVENCIMENTO = '" + despesaVO.getDataVencimento().format(formatador) +"',"
				+ "DATAPAGAMENTO = '" + despesaVO.getDataPagamento().format(formatador) +"', "				
				+ "CATEGORIA = '" + despesaVO.getCategoria()+"'"
				+ "WHERE IDDESPESA = " + despesaVO.getId();
		try {
			
			resultado = stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query  de atualização da despesa. ");
			System.out.println("Erro: "+ e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public boolean verificarRegistroPorIdDespesa(int id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
				
		String query =  "SELECT IDDESPESA FROM DESPESA WHERE IDDESPESA = " + id;	
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				return true;
				
			}
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query que verifica a existência de despesa por idDespesa");
			System.out.println("Erro: "+ e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int excluirDespesaDAO(DespesaVO despesaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
				
		String query = "DELETE FROM DESPESA WHERE IDDESPESA = " + despesaVO.getId();	
		try {
			resultado = stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query  de exclusão da despesa");
			System.out.println("Erro: "+ e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public ArrayList<DespesaVO> consultarTodasDespesasDAO(int idUsuario) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<DespesaVO> despesasVO = new ArrayList<DespesaVO>();
				
		String query =  "SELECT IDDESPESA, IDUSUARIO, DESCRICAO, VALOR, DATAVENCIMENTO, DATAPAGAMENTO, CATEGORIA"
				+ " FROM DESPESA WHERE IDUSUARIO = " + idUsuario;
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				DespesaVO despesaVO = new DespesaVO();
				despesaVO.setId(resultado.getInt(1));
				despesaVO.setIdUsuario(resultado.getInt(2));
				despesaVO.setDescricao(resultado.getString(3));
				despesaVO.setValor(resultado.getDouble(4));
				despesaVO.setDataVencimento(LocalDate.parse(resultado.getString(5), formatador));
				despesaVO.setDataPagamento(LocalDate.parse(resultado.getString(6), formatador));
				despesaVO.setCategoria(resultado.getString(7));
				despesasVO.add(despesaVO);
				
			}
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query que verifica a consulta de despesas por usuário");
			System.out.println("Erro: "+ e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return despesasVO;
	}

	public DespesaVO consultarDespesaDAO(DespesaVO despesaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		DespesaVO despesa = new DespesaVO();
				
		String query =  "SELECT IDDESPESA, IDUSUARIO, DESCRICAO, VALOR, DATAVENCIMENTO, DATAPAGAMENTO, CATEGORIA"
				+ " FROM DESPESA WHERE IDDESPESA = " + despesaVO.getId() ;
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				
				despesa.setId(resultado.getInt(1));
				despesa.setIdUsuario(resultado.getInt(2));
				despesa.setDescricao(resultado.getString(3));
				despesa.setValor(resultado.getDouble(4));
				despesa.setDataVencimento(LocalDate.parse(resultado.getString(5), formatador));
				despesa.setDataPagamento(LocalDate.parse(resultado.getString(6), formatador));
				despesa.setCategoria(resultado.getString(7));
				
				
			}
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query que verifica a consulta de despesa");
			System.out.println("Erro: "+ e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return despesa;
	}

}
