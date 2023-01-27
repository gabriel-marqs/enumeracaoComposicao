package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Contrato;
import entities.Departamento;
import entities.Funcionario;
import entities.enums.NivelProfissional;

public class Program {

	public static void main(String[] args) throws ParseException  {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Informe o departamento: ");
		String nomeDepartamento = sc.nextLine();
		
		System.out.println("Informe os dados do funcionário:");
		
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Nível Profissional: ");
		String level = sc.nextLine().toUpperCase();
		System.out.print("Salário Base: R$ ");
		double salario = sc.nextDouble();
		
		Funcionario funcionario = new Funcionario(nome, NivelProfissional.valueOf(level), salario, new Departamento(nomeDepartamento));
		
		System.out.print("Quantos contratos para esse funcionário?" );
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.printf("Informe os dados do %dº contrato:\n", i+1);
			System.out.print("Data (DD/MM/YYYY): ");
			Date data = sdf.parse(sc.next());
			System.out.print("Valor por hora: R$ ");
			double valorHora = sc.nextDouble();
			System.out.print("Duração (horas): ");
			int duracao = sc.nextInt();
			
			Contrato contrato = new Contrato(data, valorHora, duracao);
			funcionario.addContrato(contrato);
			
			
			}
		
		System.out.print("Informe mês e ano paa calcular os valores recebidos (MM/YYYY): ");
		String mesAno = sc.next();
		int mes = Integer.parseInt(mesAno.substring(0, 2));
		int ano = Integer.parseInt(mesAno.substring(3));
		
		System.out.println("Nome: " + funcionario.getNome());
		System.out.println("Departamento: " + funcionario.getDepartamento().getNome());
		System.out.printf("Recebido em %s: %d\n", mesAno, String.format("%.2f", funcionario.recebido(ano, mes)));
		
		
		
		sc.close();

	}

}
