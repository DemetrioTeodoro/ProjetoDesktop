package model.vo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReceitaVO extends LancamentoVO {
	
	DateTimeFormatter formataDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	LocalDate dataReceita;

	public ReceitaVO(int id, int idUsuario, String descricao, double valor, LocalDate dataReceita) {
		super(id, idUsuario, descricao, valor);
		this.dataReceita = dataReceita;
	}

	public ReceitaVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LocalDate getDataReceita() {
		return dataReceita;
	}

	public void setDataReceita(LocalDate dataReceita) {
		this.dataReceita = dataReceita;
	}

	public void imprimir() {
		System.out.printf("%10d %-10d %-20s %-10s %-15s \n", 
				this.getId(),
				this.getIdUsuario(),
				this.getDescricao(),
				this.getValor(),
				this.getDataReceita().format(formataDate));
				
	}	
	
	

}
