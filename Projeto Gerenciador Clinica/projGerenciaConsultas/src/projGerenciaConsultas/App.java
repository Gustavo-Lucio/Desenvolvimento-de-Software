package projGerenciaConsultas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // Scanner para fazer a leitura do metodo escolhido

		// Criação dos Arraylist dos OBJETOS
		ArrayList<Medico> listaMedicos = new ArrayList<Medico>();
		ArrayList<Paciente> listaPacientes = new ArrayList<Paciente>();
		ArrayList<Consulta> listaConsultas = new ArrayList<Consulta>();

		boolean sair = false;
		int escolha;

		while (!sair) // loop para exibir o menu principal
		{
			menu();
			escolha = sc.nextInt();

			switch (escolha) {
			case 1:
				cadastrarMedico(listaMedicos);
				break;
			case 2:
				cadastrarPaciente(listaPacientes);
				break;
			case 3:
				agendarConsulta(listaMedicos, listaPacientes, listaConsultas);
				break;
			case 4:
				alterarConsulta(listaMedicos, listaPacientes, listaConsultas);
				break;
			case 5:
				buscaNomes(listaMedicos, listaPacientes);
				break;
			case 6:
				listarConsulta(listaConsultas);
				break;
			case 7:
				return;
			default:
				System.out.println("Opção invalida!");
				break;
			}
		}
	}

	/* Exibe o menu da aplicação */
	public static void menu() {

		String displayMenu = "\n 1 - Cadastrar Médico     " + "\n 2 - Cadastrar Paciente   "
				+ "\n 3 - Agendar Consulta     " + "\n 4 - Alterar Consulta     " + "\n 5 - Buscar Pessoa        "
				+ "\n 6 - Lista Consultas      " + "\n 7 - Sair";

		System.out.println(displayMenu);
	}

	public static void cadastrarMedico(ArrayList<Medico> listaMedicos) {
		/* CADASTRO DE MÉDICOS */
		System.out.println("\n<<< Cadastro de Médicos >>>\n");
		// Estas mensagens serão utilizadas apenas para exibir informações
		// para o usuário final.
		String msgEntradaMedico = "Digite o nome completo do médico (sem abreviações): ";
		String msgEntadaCPFMedico = "Digite o CPF do médico(somentes números): ";
		String msgEntradaIdadeMedico = "Digite a idade do médico: ";
		String msgEntradaCRM = "Digite o CRM do médico (somentes números): ";
		String msgEntradaEspec = "Digite a especialização do médico (sem abreviações): ";

		String insereNovoMedico = "Y"; 
		do {
			if (insereNovoMedico.equalsIgnoreCase("Y")) {

				String nomeMedico = Console.leString(msgEntradaMedico); //Variavel do tipo String para consumir oque foi digitado na entrada do console
				if (!Validador.temApenasLetras(nomeMedico)) { // Enquanto a validação for falsa continua no loop até que esteja nos padrão correto
					System.out.println("Nome inválido! \n Tente novamente!\n");
					break;
				}

				String cpfMedico = Console.leString(msgEntadaCPFMedico); //Variavel do tipo String para consumir oque foi digitado na entrada do console
				if (!Validador.temApenasDigitos(cpfMedico)) {			// Enquanto a validação for falsa continua no loop até que esteja nos padrão correto
					System.out.println("CPF inválido \n Tente novamente!");
					break;
				}

				String idadeMedico = Console.leString(msgEntradaIdadeMedico); //Variavel do tipo String para consumir oque foi digitado na entrada do console
				if (!Validador.temApenasDigitos(idadeMedico)) {				 // Enquanto a validação for falsa continua no loop até que esteja nos padrão correto
					System.out.println("Idade inválida!");
					break;
				}

				int idadeMedico2 = Integer.parseInt(idadeMedico); 		// Conversão da variável da validação em um tipo INT 

				String crmMedico = Console.leString(msgEntradaCRM);		//Variavel do tipo String para consumir oque foi digitado na entrada do console
				if (!Validador.temApenasDigitos(crmMedico)) {			// Enquanto a validação for falsa continua no loop até que esteja nos padrão correto
					System.out.println("CRM inválido");
					break;
				}

				String especMedico = Console.leString(msgEntradaEspec); //Variavel do tipo String para consumir oque foi digitado na entrada do console
				if (!Validador.temApenasLetras(especMedico)) {			// Enquanto a validação for falsa continua no loop até que esteja nos padrão correto
					System.out.println("Especialidade inválida! \n Tente novamente!\n");
					break;
				}
				
				//Exibe os dados do médico cadastrado				
				System.out.print("\nNome médico: " + nomeMedico +
								"\nCPF do médico: " + cpfMedico +
								"\nIdade do médico: " + idadeMedico2 +
								"\nCRM do médico:" + crmMedico +
								"\nEspecialidade do médico: " + especMedico + "\n");

				Medico m = new Medico(nomeMedico, cpfMedico, idadeMedico2, crmMedico, especMedico);

				// Adiciona o médico na lista de médicos
				listaMedicos.add(m);
				System.out.println("Médico incluído com sucesso!");
			}

			insereNovoMedico = Console.leString("\nDeseja inserir outro médico (Y/N)? ");

		} while (!insereNovoMedico.equalsIgnoreCase("N"));

		System.out.println("\nLista de Médicos:");
		for (Medico m : listaMedicos) {
			// Para recuperar o nome do medico, use o getNome()
			System.out.println("\t" + m.getNome());
		}

	}

	public static void cadastrarPaciente(ArrayList<Paciente> listaPacientes) {
		System.out.println("\n<<< Cadastro de Pacientes >>>\n");

		// Estas mensagens serão utilizadas apenas para exibir informações
		// para o usuário final
		String msgEntradaNome = "Digite o nome completo do paciente (sem abreviações): ";
		String msgEntadaCPF = "Digite o CPF do paciente(somentes números): ";
		String msgEntradaIdade = "Digite a idade do paciente: ";
		String msgEntradaCodigo = "Digite o código do paciente (somente números): ";
		String msgEntradaHistorico = "Digite os sintomas do paciente: ";
		String msgEntradaCEP = "Digite o CEP do paciente: ";
		String msgEntradaEmail = "Digite o e-mail do paciente: ";
		String msgEntradaTelefone = "Digite o número de contato do paciente: ";

		// Lista de objetos criados a partir da classe Paciente

		while (true) {

			String nomePaciente = Console.leString(msgEntradaNome); //Variavel do tipo String para consumir oque foi digitado na entrada do console
			if (!Validador.temApenasLetras(nomePaciente)) { 		// Enquanto a validação for falsa continua no loop até que esteja nos padrão correto
				System.out.println("Nome inválido! \n Tente novamente!\n");
				break;
			}

			String cpfPaciente = Console.leString(msgEntadaCPF); //Variavel do tipo String para consumir oque foi digitado na entrada do console
			if (!Validador.temApenasDigitos(cpfPaciente)) {		// Enquanto a validação for falsa continua no loop até que esteja nos padrão correto
				System.out.println("CPF inválido \n Tente novamente!");
				break;
			}

			String idadePaciente = Console.leString(msgEntradaIdade); //Variavel do tipo String para consumir oque foi digitado na entrada do console
			if (!Validador.temApenasDigitos(idadePaciente)) {		  // Enquanto a validação for falsa continua no loop até que esteja nos padrão correto
				System.out.println("Idade inválida!");
				break;
			}

			int idadePaciente2 = Integer.parseInt(idadePaciente);

			String codPaciente = Console.leString(msgEntradaCodigo); //Variavel do tipo String para consumir oque foi digitado na entrada do console
			if (!Validador.temApenasDigitos(codPaciente)) {		     // Enquanto a validação for falsa continua no loop até que esteja nos padrão correto
				System.out.println("Código Inválido \n Tente novamente!");
				break;
			}

			String hisPaciente = Console.leString(msgEntradaHistorico); //Variavel do tipo String para consumir oque foi digitado na entrada do console
			if (!Validador.temApenasLetras(hisPaciente)) {				// Enquanto a validação for falsa continua no loop até que esteja nos padrão correto
				System.out.println("Sintomas Inválidos! \n Tente novamente!\n");
				break;
			}

			String cepPaciente = Console.leString(msgEntradaCEP); //Variavel do tipo String para consumir oque foi digitado na entrada do console
			if (!Validador.validaCEP(cepPaciente)) {		   	  // Enquanto a validação for falsa continua no loop até que esteja nos padrão correto
				System.out.println("CEP Inválido! \n Tente novamente!\n");
				break;
			}

			String emailPaciente = Console.leString(msgEntradaEmail); //Variavel do tipo String para consumir oque foi digitado na entrada do console
			if (!Validador.ValidaEmail(emailPaciente)) {			  // Enquanto a validação for falsa continua no loop até que esteja nos padrão correto
				System.out.println("E-mail Inválido! \n Tente novamente!\n");
				break;
			}

			String telPaciente = Console.leString(msgEntradaTelefone); //Variavel do tipo String para consumir oque foi digitado na entrada do console
			if (!Validador.temApenasDigitos(telPaciente)) {				   // Enquanto a validação for falsa continua no loop até que esteja nos padrão correto
				System.out.println("Telefone Inválido! \n Tente novamente!\n");
				break;
			}
			//Exibição do paciente cadastrado
			System.out.print("\nDados do Paciente Cadastrado \nNome: " + nomePaciente +
					"\nCPF: " + cpfPaciente +
					"\nIdade: " + idadePaciente2 +
					"\nCódigo:" + codPaciente +
					"\nSintomas: " + hisPaciente + 
					"\nCEP:" + cepPaciente +
					"\nE-mail:" + emailPaciente +
					"\nTelefone:" + telPaciente +	"\n");
			
			
			//Adiconando paciente na lista
			Paciente p = new Paciente(nomePaciente, cpfPaciente, idadePaciente2, codPaciente, hisPaciente, cepPaciente,
					msgEntradaEmail, telPaciente);
			listaPacientes.add(p);

			System.out.println("Paciente incluído com sucesso!");

			String c = Console.leString("\nDeseja inserir outro médico (Y/N)? ");

			if (c.equalsIgnoreCase("N")) {
				break;
			}
		}

		System.out.println("\nLista de Pacientes:");
		for (Paciente p : listaPacientes) {
			// Para recuperar o nome do paciente, use o getNome()
			System.out.println("\t" + p.getNome());

		}

	}

	public static void agendarConsulta(ArrayList<Medico> listaMedicos, ArrayList<Paciente> listaPacientes,
			ArrayList<Consulta> listaConsultas) {

		/* CADASTRO DE CONSULTAS */

		// O objeto da classe Medico deve ser selecionado a partir da lista
		// de medicos (ArrayList<Medico> medicos)

		System.out.println("\n<<< Cadastro de Consultas >>>\n");
		// Lista de objetos criados a partir da classe Consulta

		// Uma outra forma de fazer o loop de cadastro. Note como a variavel
		// insereNovoMedico foi inicializada e como ela é manipulada dentro do while.

		boolean inserirNovaConsulta = true;

		do {
			if (inserirNovaConsulta) {

				// Seleciona o médico da consulta
				Medico medicoConsulta = null;

				int numMedico = 1;
				System.out.println("\nMedicos disponíveis: ");
				for (Medico m : listaMedicos) {
					System.out.println("\t" + numMedico + " - " + m.getNome());
					numMedico++;
				}

				int numMedSelecao = Console.leInteiro("\nDigite o número do médico: ");

				while (!(numMedSelecao > 0 && numMedSelecao <= listaMedicos.size())) {
					// Aqui estamos garantindo que o número digitado seja uma
					// posição válida do ArrayList
					System.out.println("Posição do médico inválida!");
					numMedSelecao = Console.leInteiro("Digite o número do médico: ");
				}

				// Agora, a partir do número digitado, vamos recuperar o objeto da lista
				// de medicos. Lembra que temos que subtrair 1, pois o ArrayList é indexado
				// a partir do 0 (zero)

				medicoConsulta = listaMedicos.get(numMedSelecao - 1);

				// Seleciona o paciente da consulta
				Paciente pacienteConsulta = null;

				int numPaciente = 1;
				System.out.println("\nPacientes cadastrados: ");
				for (Paciente p : listaPacientes) {
					System.out.println("\t" + numPaciente + " - " + p.getNome());
					numPaciente++;
				}

				int numPacSelecao = Console.leInteiro("Digite o número do paciente: ");

				// O número digitado deve estar entre 1 e pacientes.size()
				while (!(numPacSelecao > 0 && numPacSelecao <= listaPacientes.size())) {
					// Aqui estamos garantindo que o número digitado seja uma
					// posição válida do ArrayList
					System.out.println("Posição do paciente inválida!");
					numPacSelecao = Console.leInteiro("Digite o número do paciente: ");
				}

				// Agora, a partir do número digitado, vamos recuperar o objeto da lista
				// de medicos. Lembra que temos que subtrair 1, pois o ArrayList é indexado
				// a partir do 0 (zero)

				pacienteConsulta = listaPacientes.get(numPacSelecao - 1);

				// Recebe a data e hora da consulta

				// Estas mensagens serão utilizadas apenas para exibir informações
				// para o usuário final.

				boolean isValid = true; // variavel para validação da data/hora correta e se o médico já tem consulta marcada
				String dataConsulta = null;
				String horaConsulta = null;

				do {
					String msgEntradaData = "Digite a data da consulta (formato DD/MM/YYYY): ";
					String msgEntradaHora = "Digite a hora da consulta (formato hh:mm) : ";

					dataConsulta = Console.leString(msgEntradaData);
					horaConsulta = Console.leString(msgEntradaHora);
					
					//Chama o metodo de validação de data/hora e se o médico tem consulta na hora marcada
					isValid = validaMedicoConsulta(dataConsulta, horaConsulta, listaConsultas, medicoConsulta);

				} while (!isValid);
				
				//Exibição da consulta marcada
				System.out.print("\nDados da Consulta Cadastrada \nNome do Médico: " + medicoConsulta.getNome() +
						"\nNome do Paciente: " + pacienteConsulta.getNome() +
						"\nData da Consulta: " + dataConsulta +
						"\nHora da Consulta: " + horaConsulta);

				// Cria uma nova consulta
				Consulta c = new Consulta(pacienteConsulta, dataConsulta, horaConsulta, medicoConsulta);

				// Adiciona na lista de consultas
				listaConsultas.add(c);
				System.out.println("\nConsulta incluída com sucesso!");
			}

			String continuar = Console.leString("\nDeseja inserir outra consulta (Y/N)? ");

			if (continuar.equalsIgnoreCase("N"))
				inserirNovaConsulta = false;

		} while (inserirNovaConsulta == true);

		// Exibe todas as consultas
		System.out.println("\nLista de Consultas: ");
		for (Consulta c : listaConsultas) {
			System.out.println(c);
		}

	}

	public static void alterarConsulta(ArrayList<Medico> listaMedicos, ArrayList<Paciente> listaPacientes,
			ArrayList<Consulta> listaConsultas) {

		int numConsulta = 1;
		System.out.println("\nConsultas Marcadas: ");
		for (Consulta c : listaConsultas) {
			System.out.println("Código da consulta: " + numConsulta + " \n Nome do médico: " + c.getMedico().getNome()
					+ " \n Nome do Paciente: " + c.getPaciente().getNome() + " \n Data da consulta: " + c.getData()
					+ " " + c.getHora());
			numConsulta++;
		}

		int numConSelecao = Console.leInteiro("Digite o número da consulta: ");
		// Seleciona a posição da consulta que gostaria de alterar
		
		while (!(numConSelecao > 0 && numConSelecao <= listaConsultas.size())) {
			System.out.println("Posição da consulta inválida!");
			numConSelecao = Console.leInteiro("Digite o número da consulta: ");
		}

		Consulta consulta = listaConsultas.get(numConSelecao - 1);

		System.out.println("\nInforme o campo que você gostaria de alterar! \n" + "1 - Mudar nome do médico "
				+ "2 - Mudar o paciente" + "3 - Mudar a data da consulta" + "4 - Mudar a hora da consulta"
				+ "5 - Sair");

		Scanner sc = new Scanner(System.in);
		int escolha = sc.nextInt();
		boolean isValid = true;
		switch (escolha) {
		case 1:

			boolean isMedicoValid = true;
			Medico medicoConsulta = null;
			
			//Laço para alterar o médico
			do {

				int numMedico = 1;
				System.out.println("\nMedicos disponíveis: ");
				for (Medico m : listaMedicos) {
					System.out.println("\t" + numMedico + " - " + m.getNome());
					numMedico++;
				}

				int numMedSelecao = Console.leInteiro("\nDigite o número do médico: ");

				while (!(numMedSelecao > 0 && numMedSelecao <= listaMedicos.size())) {

					System.out.println("Posição do médico inválida!");
					numMedSelecao = Console.leInteiro("Digite o número do médico: ");
				}

				medicoConsulta = listaMedicos.get(numMedSelecao - 1);
				//Válida se o médico já não tem consulta marcada no caso da alteração
				isMedicoValid = validaMedicoConsulta(consulta.getData(), consulta.getHora(), listaConsultas,
						medicoConsulta);

			} while (!isMedicoValid);

			consulta.setMedico(medicoConsulta); // Altera o médico dentro do objeto
			System.out.println("Medico alterado com sucesso!");

			break;
		case 2:

			Paciente pacienteConsulta = null;
			int numPaciente = 1;
			System.out.println("\nPaciente disponíveis: ");
			for (Paciente p : listaPacientes) {
				System.out.println("\t" + numPaciente + " - " + p.getNome());
				numPaciente++;
			}

			int numPacSelecao = Console.leInteiro("\nDigite o número do paciente: ");
			
			//Laço para alterar o paciente
			while (!(numPacSelecao > 0 && numPacSelecao <= listaMedicos.size())) {

				System.out.println("Posição do paciente inválida!");
				numPacSelecao = Console.leInteiro("Digite o número do paciente: ");
			}

			pacienteConsulta = listaPacientes.get(numPacSelecao - 1);

			consulta.setPaciente(pacienteConsulta); // Altera o paciente dentro do objeto
			System.out.println("Paciente alterado com sucesso!");
			break;
		case 3:

			String dataConsulta = null;
			isValid = true;
			//Laço para alterar a data
			do {
				String msgEntradaData = "Digite a data da consulta (formato DD/MM/YYYY): ";

				dataConsulta = Console.leString(msgEntradaData);
				//Valida se a data é válida 
				isValid = validaMedicoConsulta(dataConsulta, consulta.getHora(), listaConsultas, consulta.getMedico());

			} while (!isValid);
			consulta.setData(dataConsulta); // Aponta a data para o objeto
			System.out.println("Data alterada com sucesso!");
			break;
		case 4:

			String horaConsulta = null;
			isValid = true;
			
			//Laço para alterar a hora
			do {
			
				String msgEntradaData = "Digite a hora da consulta (formato HH:mm): ";

				horaConsulta = Console.leString(msgEntradaData);
				//Valida se a hora é válida 
				isValid = validaMedicoConsulta(consulta.getData(), horaConsulta, listaConsultas, consulta.getMedico());

			} while (!isValid);
			consulta.setHora(horaConsulta); // Aponta a hora para o objeto
			System.out.println("Hora alterada com sucesso!");
			break;
		case 5:
			return;
		}
	}

	public static void buscaNomes(ArrayList<Medico> listaMedicos, ArrayList<Paciente> listaPacientes) {
		String novaBusca = "Y";

		//Utilizando um laço para fazer a busca do paciente e do médico
		//Exibindo em duas listas separadas
		do {
			if (novaBusca.equalsIgnoreCase("Y")) {

				String nomeBusca = "Digite o nome que deseja conferir";
				String pesquisa = Console.leString(nomeBusca);
				boolean nomeEncontrado = false;

				for (Medico medico : listaMedicos) { //Iterando a lista de médicos
					System.out.println("\n Contém na lista de médicos: ");
					if (medico.getNome().contains(pesquisa)) { // verificando se na lista de médicos contém a palavra inserida no console
						System.out.println(medico.getNome()); //Exibe o nome do médico 
						nomeEncontrado = true;
					}
				}

				for (Paciente paciente : listaPacientes) { //Iterando a lista de pacientes
					System.out.println("\n Contém na lista de paciente: ");
					if (paciente.getNome().contains(pesquisa)) { //verificando se na lista de paciente contém a palavra inserida no console
						System.out.println(paciente.getNome()); //Exibe o nome do paciente 
						nomeEncontrado = true;
					}
				}
				// Caso não encontrado exibe a seguinte mensagem
				if (nomeEncontrado == false) {
					System.out.println("Nome não encontrado"); 
				}

				novaBusca = Console.leString("Deseja fazer uma nova busca (Y/N)? ");
			}

		} while (!novaBusca.equalsIgnoreCase("N"));
	}

	public static void listarConsulta(ArrayList<Consulta> listaConsultas) {

		int numConsulta = 1;
		String novaBusca = "Y";
		// Metodo de listagem de consultas
		//-----------------------------------------------------------------------------------------------------------------------------------------------
		// Observação não consegui de maneira nenhuma utilizar Collections para ordernar por hora, professor se tiver como você me mandar um exemplo
		// ou fazer neste código. 
		// Se possível me passe por e-mail gustavo_lucio99@hotmail.com
		//-----------------------------------------------------------------------------------------------------------------------------------------------
		do {
			if (novaBusca.equalsIgnoreCase("Y")) {
		
				System.out.println("\nConsultas Marcadas: ");
				for (Consulta c : listaConsultas) { // Iterando a lista de consulta
					//Exibindo os dados das consultas marcadas
					System.out.println("Código da consulta: " + numConsulta + " \n Nome do médico: " + c.getMedico().getNome() 
					+ " \n Nome do Paciente: " + c.getPaciente().getNome() + " \n Data da consulta: " + c.getData()
					+ " " + c.getHora());
					numConsulta++;
				} 
			}
			novaBusca = Console.leString("Aperte N para sair da lista. ");
		}while (!novaBusca.equalsIgnoreCase("N"));

	} 

	public static boolean validaMedicoConsulta(String data, String hora, ArrayList<Consulta> listaConsultas, // Metodo retorna um tipo bool
			Medico medicoConsulta) {
		//Metodo criado para validar se o formato da data e hora estão corretos
		//Se as consultas estão marcadas para um ponto no futuro e não no presente e/ou passado
		//E se o médico já tem consulta marcada para o momento
		boolean dataVal = false;
		boolean horaVal = false;

		boolean isValid = true;

		try { 

			dataVal = ValidadorData.dataValida(data);
			horaVal = ValidadorData.horaValida(hora);

			if (dataVal && horaVal) { // Validação do formato da data e hora

				Date dataHoraConsulta = null;
				dataHoraConsulta = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(data + " " + hora); // Concatenando as variaveis do tipo data e hora

				if (new Date().compareTo(dataHoraConsulta) == 1) { // Validação se a hora é em um ponto futuro com base na hora atual do computador
					isValid = false;
					System.out.println("Data e/ou Hora inválida \n Tente novamente! \n");
				}

			} else {
				System.out.println("Data e/ou Hora inválida \n Tente novamente!\n");
				isValid = false;
			}

		} catch (Exception e) {
			isValid = false;
			System.out.println("Data e/ou Hora inválida \n Tente novamente! \n");
		}

		for (Consulta consulta : listaConsultas) { //Iterando a lista de consultas para veriicar se o médico já tem hora agendada
			if (consulta.getData().equals(data) && consulta.getHora().equals(hora)
					&& consulta.getMedico() == medicoConsulta) {
				System.out.println(" \n Já existe consulta agendada para este médico!");
			}
		}

		return isValid;
	}
}
