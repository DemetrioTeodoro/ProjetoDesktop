package model.bo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.dao.DespesaDAO;

import model.vo.DespesaVO;

public class DespesaBO {

	public void cadastrarDespesaBO(DespesaVO despesaVO) {
		DespesaDAO despesaDAO = new DespesaDAO();
		//Verfica se o usuário existe no banco, antes de incluir uma despesa.
		
		if (despesaDAO.verificarRegistroPorIdUsuario(despesaVO.getIdUsuario())) {
			int resultado = despesaDAO.cadastrarDespesaDAO(despesaVO);
			if (resultado == 1) {		
				JOptionPane.showMessageDialog(null, "Despesa Cadastrada com Sucesso!!");
			}else {
				JOptionPane.showMessageDialog(null, "Despesa não Cadastrada!!");
				}			
		} else {
			JOptionPane.showMessageDialog(null, "IdUsuário inválido!!");	
		}
		
	}

	public void atualizarDespesaBO(DespesaVO despesaVO) {
		DespesaDAO despesaDAO = new DespesaDAO();
		//Verfica se a despesa existe no banco, antes de alterar uma despesa.
		
		if (despesaDAO.verificarRegistroPorIdDespesa(despesaVO.getId())) {
			if (despesaDAO.verificarRegistroPorIdUsuario(despesaVO.getIdUsuario())) {
				int resultado = despesaDAO.atualizarDespesaDAO(despesaVO);
				if (resultado == 1) {
					JOptionPane.showMessageDialog(null, "Despesa Atualizada com Sucesso!!");
				}else {
					JOptionPane.showMessageDialog(null, "Não foi possível atualizar a despesa!!");
				}
			}else {
				JOptionPane.showMessageDialog(null, "IdUsuário inválido!!");
			}			
		}else {
			JOptionPane.showMessageDialog(null, "Despesa ainda não Cadastrada!!");
		}

}

	public void excluirDespesaBO(DespesaVO despesaVO) {
		DespesaDAO despesaDAO = new DespesaDAO();
		//Verfica se a despesa existe no banco, antes de excluir uma despesa.
		
		if (despesaDAO.verificarRegistroPorIdDespesa(despesaVO.getId())) {			
			int resultado = despesaDAO.excluirDespesaDAO(despesaVO);
			if (resultado == 1) {
				JOptionPane.showMessageDialog(null, "Despesa excluida com sucesso!!");
			}else {
				JOptionPane.showMessageDialog(null, "Não foi possível excluir a despesa!!");
				}
		}else {
			JOptionPane.showMessageDialog(null, "IdDesdpesa inválido!!");
			}			
			
		}

	public ArrayList<DespesaVO> consultarTodasDespesasBO(int idUsuario) {
		DespesaDAO despesaDAO = new DespesaDAO();
		ArrayList<DespesaVO> despesasVO = despesaDAO.consultarTodasDespesasDAO(idUsuario);
		if (despesasVO.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Lista de despesas está vazia!!");
			
		}
			return despesasVO;
	}

	public DespesaVO consultarDespesaBO(DespesaVO despesaVO) {
		DespesaDAO despesaDAO = new DespesaDAO();
		DespesaVO despesa = despesaDAO.consultarDespesaDAO(despesaVO);
		if (despesa == null) {
			JOptionPane.showMessageDialog(null, "Despesao não localizada!!");
			
		}
			return despesa;
	}
	
}