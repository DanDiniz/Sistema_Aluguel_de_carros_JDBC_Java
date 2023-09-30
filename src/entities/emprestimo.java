package entities;

import java.util.Date;

public class emprestimo {
	
	private Integer id;
	private cliente cliente;
	private veiculo veiculo;
	private Double multa;
	private Date data_emprestimo;
	private Date previsao_entrega;
	private Date data_devolucao;
	private Double total_emprestimo;
	
	public emprestimo(Integer id, cliente cliente,veiculo veiculo, Double multa,
			Date data_emprestimo, Date previsao_entrega, Date data_devolucao, Double total_emprestimo) {
		this.id = id;
		this.cliente = cliente;
		this.veiculo = veiculo;
		this.multa = multa;
		this.data_emprestimo = data_emprestimo;
		this.previsao_entrega = previsao_entrega;
		this.data_devolucao = data_devolucao;
		this.total_emprestimo = total_emprestimo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public cliente getCliente() {
		return cliente;
	}

	public void setCliente(cliente cliente) {
		this.cliente = cliente;
	}

	public veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Double getMulta() {
		return multa;
	}

	public void setMulta(Double multa) {
		this.multa = multa;
	}

	public Date getData_emprestimo() {
		return data_emprestimo;
	}

	public void setData_emprestimo(Date data_emprestimo) {
		this.data_emprestimo = data_emprestimo;
	}

	public Date getPrevisao_entrega() {
		return previsao_entrega;
	}

	public void setPrevisao_entrega(Date previsao_entrega) {
		this.previsao_entrega = previsao_entrega;
	}

	public Date getData_devolucao() {
		return data_devolucao;
	}

	public void setData_devolucao(Date data_devolucao) {
		this.data_devolucao = data_devolucao;
	}

	public Double getTotal_emprestimo() {
		return total_emprestimo;
	}

	public void setTotal_emprestimo(Double total_emprestimo) {
		this.total_emprestimo = total_emprestimo;
	}
	
	
	
	
}
