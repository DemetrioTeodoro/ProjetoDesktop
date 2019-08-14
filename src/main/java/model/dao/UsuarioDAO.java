package model.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.vo.UsuarioVO;

public class UsuarioDAO {

	public boolean verificarRegistroPorcpf(String cpf) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
				
		String query =  "SELECT CPF FROM USUARIO WHERE CPF = '" + cpf + "'"	;	
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				return true;
				
			}
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query que verifica a existência de usuário por cpf");
			System.out.println("Erro: "+ e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int cadastrarUsuarioDAO(UsuarioVO usuarioVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
				
		String query = "INSERT INTO USUARIO(NOME, CPF, TELEFONE, LOGIN,SENHA)"
				+ "VALUES ('"+usuarioVO.getNome()+"','"+usuarioVO.getCpf()+"','"+
				usuarioVO.getTelefone()+"','"+usuarioVO.getLogin()+"','"+usuarioVO.getSenha()+"')";	
		try {
			resultado = stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query  de cadastro do usuário");
			System.out.println("Erro: "+ e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
		
	}

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

	public int excluirUsuarioDAO(UsuarioVO usuarioVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
				
		String query = "DELETE FROM USUARIO WHERE IDUSUARIO = " + usuarioVO.getIdUsuario();	
		try {
			resultado = stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query  de exclusão do usuário");
			System.out.println("Erro: "+ e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public int atualizarUsuarioDAO(UsuarioVO usuarioVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
				
		String query = "UPDATE USUARIO SET "
				+ "NOME = '"+ usuarioVO.getNome() + "', "
				+ "CPF = '" + usuarioVO.getCpf() +"', "
				+ "TELEFONE = '" + usuarioVO.getTelefone() +"', "
				+ "LOGIN = '" + usuarioVO.getLogin() +"', "
				+ "SENHA = '" + usuarioVO.getSenha() +"'"
				+ "WHERE IDUSUARIO = " + usuarioVO.getIdUsuario();
		try {
			resultado = stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query  de atualização do usuário");
			System.out.println("Erro: "+ e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public ArrayList<UsuarioVO> consultarTodosUsuariosDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<UsuarioVO> usuariosVO = new ArrayList<UsuarioVO>();
				
		String query =  "SELECT IDUSUARIO, NOME, CPF, TELEFONE, LOGIN, SENHA FROM USUARIO" ;
		try {
			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				UsuarioVO usuarioVO = new UsuarioVO();
				usuarioVO.setIdUsuario(resultado.getInt(1));
				usuarioVO.setNome(resultado.getString(2));
				usuarioVO.setCpf(resultado.getString(3));
				usuarioVO.setTelefone(resultado.getString(4));
				usuarioVO.setLogin(resultado.getString(5));
				usuarioVO.setSenha(resultado.getString(6));
				usuariosVO.add(usuarioVO);
				
			}
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query que verifica de consulta de usuários");
			System.out.println("Erro: "+ e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return usuariosVO;
	}

	public UsuarioVO consultarUsuarioDAO(UsuarioVO usuarioVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		UsuarioVO usuario = new UsuarioVO();
				
		String query =  "SELECT IDUSUARIO, NOME, CPF, TELEFONE, LOGIN, SENHA FROM USUARIO WHERE IDUSUARIO = " + usuarioVO.getIdUsuario();
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				
				usuario.setIdUsuario(resultado.getInt(1));
				usuario.setNome(resultado.getString(2));
				usuario.setCpf(resultado.getString(3));
				usuario.setTelefone(resultado.getString(4));
				usuario.setLogin(resultado.getString(5));
				usuario.setSenha(resultado.getString(6));
				
				
			}
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query que verifica de consulta de usuário");
			System.out.println("Erro: "+ e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return usuario;
	}
	
}
	


