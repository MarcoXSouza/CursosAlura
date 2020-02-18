package br.com.alura.macetesdoeclipse;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Principal {

	public static void main(String[] args) {
		Calendar dataNascimento = new GregorianCalendar(1997, 8, 22);
		Funcionario funcionario = new Funcionario	("José", 25, dataNascimento);
		System.out.println(funcionario);
	}
}
