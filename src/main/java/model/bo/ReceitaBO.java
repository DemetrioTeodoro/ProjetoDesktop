package model.bo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.dao.ReceitaDAO;
import model.vo.ReceitaVO;




public class ReceitaBO {

	
	public void cadastrarReceitaBO(ReceitaVO receitaVO) {
		ReceitaDAO receitaDAO = new ReceitaDAO();
		//Verfica se o usuário existe no banco, antes de incluir uma receita.
		
		if (receitaDAO.verificarRegistroPorIdUsuario(receitaVO.getIdUsuario())) {
			int resultado = receitaDAO.cadastrarReceitaDAO(receitaVO);
			if (resultado == 1) {		
				JOptionPane.showMessageDialog(null, "Receita cadastrada com sucesso!!");
			}else {
				JOptionPane.showMessageDialog(null, "Receita não cadastrada!!");
				}			
		} else {
			JOptionPane.showMessageDialog(null, "IdUsuário inválido!!");
		}
		
	}

	public void atualizarReceitaBO(ReceitaVO receitaVO) {
		ReceitaDAO receitaDAO = new ReceitaDAO();
		//Verfica se a receita existe no banco, antes de alterar uma despesa.
		
		if (receitaDAO.verificarRegistroPorIdReceita(receitaVO.getId())) {
			if (receitaDAO.verificarRegistroPorIdUsuario(receitaVO.getIdUsuario())) {
				int resultado = receitaDAO.atualizarReceitaDAO(receitaVO);
				if (resultado == 1) {
					JOptionPane.showMessageDialog(null, "Receita atualizada com sucesso!!");
				}else {
					JOptionPane.showMessageDialog(null, "Não foi possível atualizar a receita!!");
				}
			}else {
				JOptionPane.showMessageDialog(null, "IdUsuário inválido!!");
			}			
		}else {
			JOptionPane.showMessageDialog(null, "Receita ainda não foi cadastrado!!");
		}

}

	public void excluirReceitaBO(ReceitaVO receitaVO) {
		ReceitaDAO receitaDAO = new ReceitaDAO();
		//Verfica se a receita existe no banco, antes de excluir uma despesa.
		
		if (receitaDAO.verificarRegistroPorIdReceita(receitaVO.getId())) {			
			int resultado = receitaDAO.excluirReceitaDAO(receitaVO);
			if (resultado == 1) {
				JOptionPane.showMessageDialog(null, "Receita excluida com sucesso!!");
			}else {
				JOptionPane.showMessageDialog(null, "Não foi possível excluir a receita!!");
				}
		}else {
			JOptionPane.showMessageDialog(null, "IdReceita inválido!!");
			}			
			
		}

	public ArrayList<ReceitaVO> consultarTodasReceitasBO(int idUsuario) {
		ReceitaDAO receitaDAO = new ReceitaDAO();
		ArrayList<ReceitaVO> receitasVO = receitaDAO.consultarTodasReceitasDAO(idUsuario);
		if (receitasVO.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Lista de receitas está vazia!!");
			
		}
			return receitasVO;
	}

	public ReceitaVO consultarReceitaBO(ReceitaVO receitaVO) {
		ReceitaDAO receitaDAO = new ReceitaDAO();
		ReceitaVO receita = receitaDAO.consultarReceitaDAO(receitaVO);
		if (receita == null) {
			JOptionPane.showMessageDialog(null, "Receita não localizada!!");
			
		}
			return receita;
	}
	
}
