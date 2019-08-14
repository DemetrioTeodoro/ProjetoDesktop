package model.vo;

abstract class LancamentoVO {
	
	int id;
	int idUsuario;
	String descricao;
	double valor;
	
	public LancamentoVO(int id, int idUsuario, String descricao, double valor) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
		this.descricao = descricao;
		this.valor = valor;
	}

	public LancamentoVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	

}
