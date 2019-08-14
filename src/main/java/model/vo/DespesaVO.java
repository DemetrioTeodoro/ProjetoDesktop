package model.vo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DespesaVO extends LancamentoVO {
	
	DateTimeFormatter formataDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	LocalDate dataVencimento;
	LocalDate dataPagamento;
	String categoria;
	
	public DespesaVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DespesaVO(int id, int idUsuario, String descricao, double valor,
			LocalDate dataVencimento, LocalDate dataPagamento, String categoria) {
		super(id, idUsuario, descricao, valor);
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
		this.categoria = categoria;
	}

	
	public LocalDate getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public LocalDate getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public void imprimir() {
		System.out.printf("%10d %-10d %-20s %-10d %-15s %-15s %-15s\n", 
				this.getId(),
				this.getIdUsuario(),
				this.getDescricao(),
				this.getValor(),
				this.getDataPagamento().format(formataDate),
				this.getDataVencimento().format(formataDate),
				this.getCategoria());
	}

}
