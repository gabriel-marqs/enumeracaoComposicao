package entities;

import java.util.Date;

public class Contrato {
	private Date data;
	private Double valorHora;
	private Integer duracao;
	
	public Contrato() {}

	public Contrato(Date data, Double valorHora, Integer duracao) {
		this.data = data;
		this.valorHora = valorHora;
		this.duracao = duracao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValorHora() {
		return valorHora;
	}

	public void setValorHora(Double valorHora) {
		this.valorHora = valorHora;
	}

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}
	
	public double valorContrato() {
		return valorHora * duracao;
	}
	
	
}
