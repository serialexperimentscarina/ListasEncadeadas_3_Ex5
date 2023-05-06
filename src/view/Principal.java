package view;

import controller.ModificacaoCadastroController;

public class Principal {

	public static void main(String[] args) {
		ModificacaoCadastroController modCadCont = new ModificacaoCadastroController();
		
		try {
			// Para idade entre 41 e 60 e limite de Crédito acima de 8000.00 
			modCadCont.novoCadastro(41, 60, 8000.00);
			// Para idade entre 31 e 40 e limite de Crédito acima de 5000.00 
			modCadCont.novoCadastro(31, 40, 5000.00);
			// Para idade entre 21 e 30 e limite de Crédito acima de 3000.00
			modCadCont.novoCadastro(21, 30, 3000.00);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
