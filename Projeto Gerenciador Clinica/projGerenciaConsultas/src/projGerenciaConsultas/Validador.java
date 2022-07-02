package projGerenciaConsultas;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Classe com validações genéricas de dados
 * alfanuméricos e alguns tipos específicos. */
public class Validador {
	
	public static boolean temApenasDigitos(String s) {
		String regex = "[0-9]+";
		Pattern p = Pattern.compile(regex);
        
		if ((s == null) || (s.length() == 0)) {
            return false;
        }
        Matcher m = p.matcher(s);
        return m.matches();
	}
	
	public static boolean temApenasLetras(String s) {
		/* 
		 * Este método tem uma abordagem semelhante ao método
		 * temApenasDigitos, mas foi escrito de uma forma mais concisa
		 */
		String regex = "^[a-zA-Z]*$";
		
		return ((s != null) && (!s.equals(""))
                && (s.matches(regex)));
	}
	
	
	public static boolean temApenasLetrasENumeros(String s) {
		/* 
		 * Aqui, aceitamos caracteres númericos e alfabeticos,
		 * mas se encontrarmos algum caractere como acento ou 
		 * símbolos, não aceitamos o valor.
		 */
		String regex = "^[a-zA-Z0-9]+$";
		
		return ((s != null) && (!s.equals(""))
                && (s.matches(regex)));
	}
	
	public static boolean validaCEP(String s) {
		
		String regex = "[0-9]{5}-[0-9]{3}";
		
		return ((s != null) && (!s.equals(""))
                && (s.matches(regex)));
	}
	
	public static boolean ValidaEmail(String s)
    {
        String regex = "^(.+)@(\\S+)";
		
		return ((s != null) && (!s.equals(""))
                && (s.matches(regex)));
    }
}
