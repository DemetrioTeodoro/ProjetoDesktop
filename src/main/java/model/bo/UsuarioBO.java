package model.bo;


import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.dao.UsuarioDAO;
import model.vo.UsuarioVO;

public class UsuarioBO {

	public void cadastrarUsuarioBO(UsuarioVO usuarioVO) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		if (usuarioDAO.verificarRegistroPorcpf(usuarioVO.getCpf())) {
			JOptionPane.showMessageDialog(null, "Usuário ja cadastrado!!");			
		} else {
			int resultado = usuarioDAO.cadastrarUsuarioDAO(usuarioVO);
			if(resultado == 1) {
				JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!!");
			} else {
				JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o Usuário!!");
			}
		}
		
	}

	public void excluirUsuarioBO(UsuarioVO usuarioVO) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		if (usuarioDAO.verificarRegistroPorIdUsuario(usuarioVO.getIdUsuario())) {
			int resultado = usuarioDAO.excluirUsuarioDAO(usuarioVO);
			if (resultado == 1) {
				JOptionPane.showMessageDialog(null, "Usuário excluido com sucesso!!");
			}else {
				JOptionPane.showMessageDialog(null, "Não foi possível excluir o usuário!!");
			}
		}else {
			JOptionPane.showMessageDialog(null, "Usuário não existe na base de dados!!");
		}
		
	}

	public void atualizarUsuarioBO(UsuarioVO usuarioVO) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		if (usuarioDAO.verificarRegistroPorIdUsuario(usuarioVO.getIdUsuario())) {
			int resultado = usuarioDAO.atualizarUsuarioDAO(usuarioVO);
			if (resultado == 1) {
				JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso!!");
			}else {
				JOptionPane.showMessageDialog(null, "Não foi possível atualizar o usuário!!");
			}
		}else {
			JOptionPane.showMessageDialog(null, "Usuário ainda não foi cadastrado!!");
		}
		
	}

	public ArrayList<UsuarioVO> consultarTodosUsuariosBO() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		ArrayList<UsuarioVO> usuariosVO = usuarioDAO.consultarTodosUsuariosDAO();
		if (usuariosVO.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Lista de usuários está vazia!!");
			
		}
			return usuariosVO;
		}
		
	

	public UsuarioVO consultarUsuarioBO(UsuarioVO usuarioVO) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		UsuarioVO usuario = usuarioDAO.consultarUsuarioDAO(usuarioVO);
		if (usuario == null) {
			JOptionPane.showMessageDialog(null, "Usuário não localizado!!");
			
		}
			return usuario;
		}
	}
	
	


