package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import br.com.serialexperimentscarina.listaobject.ListaObject;
import model.Cliente;

public class ModificacaoCadastroController {
	
	private void novoArquivo(ListaObject l, String nomeArquivo) throws Exception {
		// Inicializar um new File com o caminho “C:\\TEMP” e o nome do Arquivo passado como
		// parâmetro
		File arquivo = new File("C:\\TEMP", (nomeArquivo + ".csv"));
		
		// Inicializar um StringBuffer
		StringBuffer buffer = new StringBuffer();
		FileWriter fWriter = new FileWriter(arquivo);
		PrintWriter pWriter = new PrintWriter(fWriter);
		
		// Inicializar um contador
		int tamanho = l.size();
		for (int i = 0; i < tamanho; i++) {
			// Percorrer a lista de Objetos
			// Para cada elemento da lista, criar uma String no formato csv, igual ao arquivo cadastro.csv
			// (Não esquecendo a quebra de linha ao final da String)
			Cliente cliente = (Cliente) l.get(i);
			buffer.append(cliente.toString() + System.getProperty("line.separator"));
		}
		
		// Gravar o buffer no novo arquivo
		pWriter.write(buffer.toString());
		pWriter.flush();
		pWriter.close();
		fWriter.close();
	} 
		
	
	public void novoCadastro(int idadeMin, int idadeMax, double limiteCredito) throws Exception {
		File arquivo = new File("C:\\TEMP", "Cadastro.csv");
		
		// Inicializar uma lista de clientes
		ListaObject listaClientes = new ListaObject();
		
		if (arquivo.exists() && arquivo.isFile()) {
			FileInputStream fInStr = new FileInputStream(arquivo);
			InputStreamReader inStrReader = new InputStreamReader(fInStr);
			BufferedReader bufferReader = new BufferedReader(inStrReader);
			String linha = bufferReader.readLine();
			
			// Percorrer o arquivo cadastro.csv
			// Para cada linha do arquivo, fazer uma operação de split e armazenar em um novo objeto
			// cliente, os valores
			while (linha != null) {
				String[] vetLinha = linha.split(";");
				Cliente cliente = new Cliente();
				cliente.cpf = vetLinha[0];
				cliente.nome = vetLinha[1];
				cliente.idade = Integer.parseInt(vetLinha[2]);
				cliente.limiteCredito = Double.parseDouble(vetLinha[3].replace(',', '.'));
				
				// Verificar se a idade está entre os valores de idade passados como parâmetro(min e max) e o
				// limite de crédito seja maior que o limite de crédito passados como parâmetro. Em caso
				// posi�vo, adicionar à lista;
				if (cliente.idade >= idadeMin && cliente.idade <= idadeMax && cliente.limiteCredito > limiteCredito) {
					listaClientes.addLast(cliente);
				}
				linha = bufferReader.readLine();
			}
			bufferReader.close();
			inStrReader.close();
			fInStr.close();
			
			// Chamar o método de escrita de novo arquivo, passando a lista como parâmetro e o nome
			//do novo arquivo como parâmetros. O nome do novo arquivo deve ser: “Idade “+idade+”
			// limite”+limiteCredito
			novoArquivo(listaClientes, ("Idade" + idadeMin + "-" + idadeMax + "limite" + limiteCredito));
		} else {
			throw new Exception("Arquivo não encontrado");
		}
	}

}
