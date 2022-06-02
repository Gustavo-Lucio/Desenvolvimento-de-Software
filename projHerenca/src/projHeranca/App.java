package projHeranca;

import java.util.ArrayList;

public class App {

	public static void main(String[] args) {
		
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		Paciente p1 = new Paciente ("Kacique Kaique", 45, "j3454");
		pessoas.add(p1);
		
		Paciente p2 = new Paciente ("Menino Nan", 23, "j344554");
		pessoas.add(p2);
		
		Medico m1 = new Medico ("Vladmir Potin", 48, "244122", "Leproso");
		pessoas.add(m1);

		Paciente p3 = new Paciente ("Igão do Java", 26, "115d45");
		pessoas.add(p3);
		
		Medico m2 = new Medico ("Sid Ney", 66, "15115523", "AIDS");
		pessoas.add(m2);
		
		/* Não é possível instanciar (Classe abstract)"
		  
		Pessoa pes1 = new Pessoa ("Matheuzin Feitas", 33);
		pessoas.add(pes1);
		
		 */

		
		ArrayList<Medico> medicos = new ArrayList<Medico>();
		ArrayList<Paciente> pacientes = new ArrayList<Paciente>();		
		for (Pessoa p : pessoas) {
			if (p instanceof Medico) {
				medicos.add((Medico)  p);
				System.out.println(p.info());
			}
			
			
			
			if (p instanceof Paciente) {
				Paciente x =(Paciente) p;
				pacientes.add(x);
				System.out.println(x.info());
			}
			
			
		}
		
		//Pessoa p = pessoas.get(0);
		//Paciente p = (Paciente) pessoas.get(0);
	}

}
