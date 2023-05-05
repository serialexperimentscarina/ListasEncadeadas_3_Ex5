package model;

public class Cliente {
	
	public String cpf;
	public String nome;
	public int idade;
	public double limiteCredito;
	
	public Cliente() {
		super();
	}
	
	@Override
	public String toString() {
		return ("[Cliente " + nome + ", " + idade + " anos, CPF: " + cpf + ", limite de cr�dito: R$ " + String.format("%,.2f", limiteCredito) + "]");
	}

}
