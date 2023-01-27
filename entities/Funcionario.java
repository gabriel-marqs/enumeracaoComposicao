package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.NivelProfissional;

public class Funcionario {
	private String nome;
	private NivelProfissional level;
	private Double salarioBase;

	private Departamento departamento;

	private List<Contrato> contratos = new ArrayList<>();

	public Funcionario() {
	}

	public Funcionario(String nome, NivelProfissional level, Double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.level = level;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelProfissional getLevel() {
		return level;
	}

	public void setLevel(NivelProfissional level) {
		this.level = level;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Contrato> getContratos() {
		return contratos;
	}

	public void addContrato(Contrato contrato) {
		contratos.add(contrato);
	}

	public void removeContrato(Contrato contrato) {
		contratos.remove(contrato);
	}

	public double recebido(int ano, int mes) {
		double soma = salarioBase;
		Calendar cal = Calendar.getInstance();

		for (Contrato c : contratos) {
			cal.setTime(c.getData());
			int cAno = cal.get(Calendar.YEAR);
			int cMes = 1 + cal.get(Calendar.MONTH);

			if (ano == cAno && mes == cMes) {
				soma += c.valorContrato();
			}

		}

		return soma;
	}

}
