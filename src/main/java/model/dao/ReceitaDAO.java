package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.vo.ReceitaVO;



public class ReceitaDAO {

	
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

	public int cadastrarReceitaDAO(ReceitaVO receitaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
				
		String query = "INSERT INTO RECEITA (IDUSUARIO, DESCRICAO, VALOR, DATARECEITA)"
				+ "VALUES ('"+receitaVO.getIdUsuario()+"','"+receitaVO.getDescricao()+"','"+
				receitaVO.getValor()+"','"+receitaVO.getDataReceita().format(formatador)+"')";	
		try {
			resultado = stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query  de cadastro de receita");
			System.out.println("Erro: "+ e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public int atualizarReceitaDAO(ReceitaVO receitaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
				
		String query = "UPDATE RECEITA SET "
				+ "IDUSUARIO = '"+ receitaVO.getIdUsuario() + "',"
				+ "DESCRICAO = '" + receitaVO.getDescricao() +"',"
				+ "VALOR = '" + receitaVO.getValor() +"', "
				+ "DATARECEITA = '" + receitaVO.getDataReceita().format(formatador)+"'"
				+ "WHERE IDRECEITA = " + receitaVO.getId();
		try {
			
			resultado = stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query  de atualização da receita. ");
			System.out.println("Erro: "+ e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public boolean verificarRegistroPorIdReceita(int id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
				
		String query =  "SELECT IDRECEITA FROM RECEITA WHERE IDRECEITA = " + id;	
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				return true;
				
			}
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query que verifica a existência de receita por idReceita");
			System.out.println("Erro: "+ e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int excluirReceitaDAO(ReceitaVO receitaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
				
		String query = "DELETE FROM RECEITA WHERE IDRECEITA = " + receitaVO.getId();	
		try {
			resultado = stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query  de exclusão da receita");
			System.out.println("Erro: "+ e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public ArrayList<ReceitaVO> consultarTodasReceitasDAO(int idUsuario) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<ReceitaVO> receitasVO = new ArrayList<ReceitaVO>();
				
		String query =  "SELECT IDRECEITA, IDUSUARIO, DESCRICAO, VALOR, DATARECEITA"
				+ " FROM RECEITA WHERE IDUSUARIO = " + idUsuario;
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				ReceitaVO receitaVO = new ReceitaVO();
				receitaVO.setId(resultado.getInt(1));
				receitaVO.setIdUsuario(resultado.getInt(2));
				receitaVO.setDescricao(resultado.getString(3));
				receitaVO.setValor(resultado.getDouble(4));
				receitaVO.setDataReceita(LocalDate.parse(resultado.getString(5), formatador));
				receitasVO.add(receitaVO);
				
			}
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query que verifica a consulta de receitas por usuário");
			System.out.println("Erro: "+ e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return receitasVO;
	}

	public ReceitaVO consultarReceitaDAO(ReceitaVO receitaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ReceitaVO receita = new ReceitaVO();
				
		String query =  "SELECT IDRECEITA, IDUSUARIO, DESCRICAO, VALOR, DATARECEITA"
				+ " FROM RECEITA WHERE IDRECEITA = " + receitaVO.getId() ;
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				
				receita.setId(resultado.getInt(1));
				receita.setIdUsuario(resultado.getInt(2));
				receita.setDescricao(resultado.getString(3));
				receita.setValor(resultado.getDouble(4));
				receita.setDataReceita(LocalDate.parse(resultado.getString(5), formatador));
				
				
			}
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query que verifica a consulta de receita");
			System.out.println("Erro: "+ e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return receita;
	}

}

