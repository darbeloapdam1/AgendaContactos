package ut7.agenda.io;
import java.awt.Point;

import ut7.agenda.modelo.AgendaContactos;
import ut7.agenda.modelo.Contacto;
import ut7.agenda.modelo.Personal;
import ut7.agenda.modelo.Profesional;
import ut7.agenda.modelo.Relacion;

/**
 * Utilidades para cargar la agenda
 */
public class AgendaIO {

	public static void importar(AgendaContactos agenda) {
		String[] contactos = obtenerLineasDatos();
		for(String linea:contactos) {
			Contacto con = parsearLinea(linea); // crear el contacto 
			agenda.añadirContacto(con); // añadir el contacto a la agenda
		}
	}

	private static Contacto parsearLinea(String linea) {
		String[] tokens = linea.split(","); // guardar cada dato de la linea
		String nombre = tokens[1].trim();
		String apellidos = tokens[2].trim();
		String telefono = tokens[3].trim();
		String email = tokens[4].trim();
		

		int num = tokens[0].trim().charAt(0);
		if (num == '1') { // ver de que tipo es el contacto (1 = profesional, 2 = personal)
			String empresa = tokens[5].trim();
			return new Profesional(nombre, apellidos, telefono, email, empresa);
		} else {
			String fecha_nacimiento = tokens[5];
			String relacion = tokens[6];
			return new Personal(nombre, apellidos, telefono, email, fecha_nacimiento, queRelacion(relacion));
		}

	}
	
	/*
	 * @return rel la relacion del contacto
	 */
	
	private static Relacion queRelacion(String relacion2) {
		Relacion[] relaciones = Relacion.values();
		for(Relacion rel: relaciones) {
			if(rel.getRelacion().equalsIgnoreCase(relacion2.trim())) {
				return rel;
			}
		}
		return null;
	}

	/**
	 * 
	 * @return un array de String con todas las líneas de información de todos
	 *         los contactos. 1 significa contacto profesional, 2 significa
	 *         contacto personal
	 */
	private static String[] obtenerLineasDatos() {
		return new String[] {
				"1, Isabel, Acosta Mendioroz,  678895433 ,  iacostamen@gmail.com ,  walden estrella ",
				"2,  pedro , urruti tello , 616789654 ,  urrutitello@gmail.com , 09/03/2007, amigos",
				"1, Angel , Esteban Grande , 674544123 ,  aestebang@gmail.com ,  magma publicidad ",
				"2, elena , bueno ganuza , 678654/7699 ,  ebuenogan@gmail.com , 17/03/2000, amigos",
				"2, amaia , romero sein , 642222343 ,  aromerosein@gmail.com , 09/03/2012, pareja",
				"2, Ignacio ,  Anto roth ,  688912799 , iantoroth@gmail.com ,  11/11/1969 , padre",
				"1,  Isabel ,  Acosta Marin , 678895433 ,  iacostamar@gmail.com ,  publicidad holdings ",
				"1 ,    roberto , casas maura , 666777888 ,  rocasasma@gmail.com ,  strato banca ",
				"1,juan maria, garcía oliva, 699898111, jmgarcioliva@gmail.com, conway motor ",
				"2, pedro , urruti tello , 616789654 ,  urrutitello@gmail.com , 17/03/2000, amigos",
				"1,marta, sanz iris, 622999876, msanzi@gmail.com, jump literatura ",
				"1,javier, porto luque, 691256777 , japorlu@gmail.com, gas natural ",
				"1,pablo, ponce larraoz, 689123456, pabloponce@gmail.com, la caixa",
				"1, javier, marin lancho, 666666666, jruizlanchoe@gmail.com, bbva",
				"1,juan maria, garcía oliva, 699898111, jmgarcioliva@gmail.com, conway motor ",
				"2, Berta ,  andia solano ,  621123345 , bandiasol@gmail.com ,  12/12/1999 ,  HIJA",
				"2, Ignacio ,  Anto roth ,  688912799 , iantoroth@gmail.com ,  11/11/1969 , padre",
				"  1,  roberto , casas maura , 666777888 ,  rocasasma@gmail.com ,  strato banca ",
				" 2, daniel , martin martin , 678901234 ,  damrtinmartin@gmail.com , 15/07/1980, amigos",
				"  2, pablo , martin abradelo , 667788899 ,  martinabra@gmail.com , 31/01/2010, amigos",
				"  2, susana , santaolalla bilbao , 676767676 ,  ssantaolalla@gmail.com , 17/03/1998, amigos",
				"  2, adur ,  martin merino ,  611112113 , adurmartinme@gmail.com ,  14/02/2003 , amigos" };

	}

}
