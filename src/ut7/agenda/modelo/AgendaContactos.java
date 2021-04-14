package ut7.agenda.modelo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AgendaContactos {
	private Map<Character, Set<Contacto>> agenda;

	public AgendaContactos() {

	}

	public void añadirContacto(Contacto con) {

	}

	public void contactosEnLetra() {

	}
	
	public void totalContactos() {

	}

	@Override
	public String toString() {

		return null;
	}

	/**
	 *  @return ArrayList<Contacto> lista de contactos que contienen en su nombre o apellido el texto
	 */
	
	public List<Contacto> buscarContactos(String texto) {
		ArrayList<Contacto> lista = new ArrayList<>();
		Set<Map.Entry<Character,Set<Contacto>>> entradas = agenda.entrySet();
		Iterator<Map.Entry<Character,Set<Contacto>>> it = entradas.iterator();
		while(it.hasNext()) {
			Map.Entry<Character,Set<Contacto>> entrada = it.next();
			Set<Contacto> contactos = entrada.getValue();
			Iterator<Contacto> it2 = contactos.iterator();
			while(it2.hasNext()) {
				Contacto contacto = it2.next();
				if(contacto.getApellidos().contains(texto)) {
					lista.add(contacto);
				}else if(contacto.getNombre().contains(texto)) {
					lista.add(contacto);
				}
			}
		}
		return lista;
	}

	public List<Personal> personalesEnLetra(char letra) {

		return null;
	}

	/**
	 * 
	 * @return ArrayList<Contacto> una lista con los contactos que hay que felicitar
	 */
	public List<Personal> felicitar() {
		ArrayList<Personal> lista = new ArrayList<>();
		Set<Map.Entry<Character,Set<Contacto>>> entradas = agenda.entrySet();
		Iterator<Map.Entry<Character,Set<Contacto>>> it = entradas.iterator();
		while(it.hasNext()) {
			Map.Entry<Character,Set<Contacto>> entrada = it.next();
			Set<Contacto> contactos = entrada.getValue();
			Iterator<Contacto> it2 = contactos.iterator();
			while(it2.hasNext()) {
				Contacto contacto = it2.next();
				if(contacto instanceof Personal){
					Personal personal = (Personal) contacto;
					if(personal.esCumpleanos()) {
						lista.add(personal);
					}
				}
			}
		}
		return lista;
	}

	public void personalesPorRelacion() {

	}

	/**
	 * 
	 * @param letra la clave del Map 
	 * @return ArrayList<Personal> lista de contactos personales ordenador por fecha de nacimiento
	 */
	
	public List<Personal> personalesOrdenadosPorFechaNacimiento(char letra) {
		ArrayList<Personal> lista = new ArrayList<>();
		Set<Contacto> contactos = agenda.get(letra);
		Iterator<Contacto> it = contactos.iterator();
		while(it.hasNext()) {
			Contacto contacto = it.next();
			if(contacto instanceof Personal) {
				Personal personal = (Personal) contacto;
				lista.add(personal);
			}
		}
		
		Collections.sort(lista, new Comparator<Personal>() {

			@Override
			public int compare(Personal o1, Personal o2) {
				return o1.getFecha_nacimiento().compareTo(o2.getFecha_nacimiento());
			}
			
		});		
		return lista;
	}

}
