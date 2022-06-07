package ProjEstruturas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer>	idades = new ArrayList<Integer>();
		ArrayList<String>	nomes = new ArrayList<String>();
		
		//List listaGenerica;
		
		idades.add(9);
		nomes.add("Chaves");
		
		idades.add(8);
		nomes.add("Kiko");
		
		idades.add(18);
		nomes.add("Chiquinha");
		
		idades.add(66);
		nomes.add("Vladmir");
		
		idades.add(85);
		nomes.add("Ferdinando");
		
		idades.add(44);
		nomes.add("Brooo");
		
		idades.add(87);
		nomes.add("ThenBoy");
		
		System.out.println("Tem alguém com idade 10?");
		System.out.println(idades.contains(10));
		
		System.out.println("Tem alguém com o nome Brooo");
		System.out.println(nomes.contains("Brooo"));
			
		
		System.out.println("Qual a posição do nome Kiko");
		System.out.println(nomes.lastIndexOf("Kiko"));
		
		System.out.println("Qual a posição do nome Plinio");
		System.out.println(nomes.lastIndexOf("Plinio"));
		
		System.out.println(nomes.containsAll(nomes));
		
		//listaGenerica = nomes;
		//listaGenerica = idades;
		
		ArrayList<Integer> idadesBusca = new ArrayList<Integer>();
		
		idadesBusca.add(10);
		idadesBusca.add(25);
		
		System.out.println("A lista de idade tem 10 e 25?");
		System.out.println(idades.containsAll(idadesBusca));
		System.out.println("");
		
		// Filtrar todos com idade maior ou igual a 20
		
		
		System.out.println("Pessoas com idade maior ou igual a 20.\n");
		List<Integer> posicoesMaiorOuIgual20 = new ArrayList <Integer>();
		
		for (Integer i : idades) {
			if (i>= 20) {
				posicoesMaiorOuIgual20.add(idades.indexOf(i));
			}
			
		}
		
		for (Integer pos: posicoesMaiorOuIgual20) {
			System.out.println(String.format("Nome: %s \nIdade: %d", nomes.get(pos), idades.get(pos)));
		}
		
		
		System.out.println("\nPessoas com idade maior ou igual a 20.\n");
		List<Integer> posicoesMenor10 = new ArrayList <Integer>();
		
		for (Integer i : idades) {
			if (i < 10) {
				posicoesMenor10.add(idades.indexOf(i));
			}
			
		}
		
		for (Integer pos: posicoesMenor10) {
			System.out.println(String.format("Nome: %s \nIdade: %d", nomes.get(pos), idades.get(pos)));
		}
		
		List<Integer> filtrados;
		
		filtrados = posicoesMaiorOuIgual20;
		
		filtrados.addAll(posicoesMenor10);
		
		System.out.println("\nPessoas filtradas pela busca\n");
		for (Integer pos : filtrados) {
			System.out.println(String.format("Nome: %s\nIdade: %d", nomes.get(pos), idades.get(pos)));
		}
	
		filtrados.removeAll(posicoesMenor10);
		
		System.out.println("\nDepois de remover todos menores que 10\n");
		for (Integer pos : filtrados) {
			System.out.println(String.format("Nome: %s\nIdade: %d", nomes.get(pos), idades.get(pos)));
		}
		
		List<String> nomesFiltrados = new ArrayList<String>();
		for (Integer pos: filtrados) {
			nomesFiltrados.add(nomes.get(pos));
		}
		
		
		System.out.println("\nNomes ANTES de ordernar\n");
		for (String nome : nomesFiltrados) {
			System.out.println(String.format("Nome %s", nome));
		}
		
		Collections.sort(nomesFiltrados);
		
		System.out.println("\nNomes DEPOIS de ordernar\n");
		for (String nome : nomesFiltrados) {
			System.out.println(String.format("Nome %s", nome));
		}
	}

}
