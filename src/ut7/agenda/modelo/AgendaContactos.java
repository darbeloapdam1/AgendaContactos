package ut7.agenda.modelo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class AgendaContactos {
	private Map<Character, Set<Contacto>> agenda;

	public AgendaContactos() {
		this.agenda = new TreeMap<>();
	}

	public void añadirContacto(Contacto con) {
		if(!agenda.containsKey(con.getPrimeraLetra())){
            TreeSet<Contacto> cont = new TreeSet<>();
            cont.add(con);
            agenda.put(con.getPrimeraLetra(), cont);
        }else{
        	agenda.get(con.getPrimeraLetra()).add(con);
             }
	}

	public Set<Contacto> contactosEnLetra(char letra) {
		return this.agenda.get(letra);
	}
	
	public int totalContactos() {
		int total = 0;
		Set<Character> claves = agenda.keySet();
		for(Character clave: claves) {
			total += agenda.get(clave).size();
		}
		return total;
		
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("AGENDA CONTACTOS\n");
		Set<Map.Entry<Character,Set<Contacto>>> entradas = agenda.entrySet();
		Iterator<Map.Entry<Character,Set<Contacto>>> it = entradas.iterator();
		while(it.hasNext()) {
			Map.Entry<Character,Set<Contacto>> entrada = it.next();
			sb.append(entrada.getKey() + " (" + contactosEnLetra(entrada.getKey()).size() + " contacto/s)\n");
			Set<Contacto> contacto = entrada.getValue();
			Iterator<Contacto> it2 = contacto.iterator();
			while(it2.hasNext()) {
				Contacto con = it2.next();
				sb.append(con.toString() + "\n");
			}
		}
		sb.append("(" + totalContactos() + " contacto/s)");
		return sb.toString();
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
		ArrayList<Personal> p = new ArrayList<>();
		if(agenda.containsKey(letra)) {
			for(Contacto con : agenda.get(letra)) {
				if(con instanceof Personal) {
					p.add((Personal) con);
				}
			}
		}
		return p;
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

	public Map<Relacion, List<String>> personalesPorRelacion() {
		return null;
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
