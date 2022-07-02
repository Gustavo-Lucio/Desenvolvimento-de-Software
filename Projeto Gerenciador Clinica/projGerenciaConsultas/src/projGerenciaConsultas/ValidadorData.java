package projGerenciaConsultas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/* Classes com validações de data e hora */
public class ValidadorData {
	
	public static boolean dataValida(String s) {
		String regex = "^(0[1-9]|[12][0-9]|[3][01])/(0[1-9]|1[012])/\\d{4}$";
		
		boolean valida = false;
		
		Pattern p = Pattern.compile(regex);
        
		if ((s == null) || (s.length() == 0)) {
            return false;
        }
        
		Matcher m = p.matcher(s);
        
        if(m.matches()) {
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            // Rejeitar data inválidas
            sdf.setLenient(false);
 
            // Parse 
            try {
                
                // Tenta fazer o parse e lança exceção
            	// em caso de data inválida
                sdf.parse(s);
                
                // Se não lançou exceção, a data é válida
                valida = true;
                
            }catch(ParseException pe) {
                // Como o valor de valida já é false
            	// nem precisa fazer nada
            }            
        }        
        
        return valida;        
	}
	
	public static boolean horaValida(String s) {
		String regex = "^(0[0-9]|[1][0-9]|[2][01234]):(0[0-9]|[1-5][0-9])$";
		
		boolean valida = false;
		
		Pattern p = Pattern.compile(regex);
        
		if ((s == null) || (s.length() == 0)) {
            return false;
        }
        
		Matcher m = p.matcher(s);
        
        if(m.matches()) {            
            // Parse 
            try {                
                // Tenta fazer o parse e lança exceção
            	// em caso de hora inválida
            	LocalTime lt = LocalTime.parse(s);
                
                // Se não lançou exceção, a hora é válida
                valida = true;
                
            }catch(DateTimeException dte) {
                // Como o valor de valida já é false
            	// nem precisa fazer nada
            }            
        }        
        
        return valida;
        
	}
}
