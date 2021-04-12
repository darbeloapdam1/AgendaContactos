package ut7.agenda.modelo;
import java.time.LocalDate;

public class Personal extends Contacto {

	private LocalDate fecha_nacimiento;
	private Relacion relacion;
	public Personal(String nombre, String apellidos, String telefono, String email, String fecha, Relacion relacion) {
		super(nombre, apellidos, telefono, email);
		String[] fechaNa = fecha.split("/");
		String nuevaFecha = fechaNa[2] + "-" + fechaNa[1] + "-" + fechaNa[0];
		fecha_nacimiento = LocalDate.parse(nuevaFecha);	
		this.setRelacion(relacion);
	}

	// accesores y mutadores

	public LocalDate getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public Relacion getRelacion() {
		return relacion;
	}

	public void setRelacion(Relacion relacion) {
		this.relacion = relacion;
	}

	@Override
	public String getFirmaEmail() {
		return "Un abrazo!!";
	}
	/*
	 * Metod privado para ver la abreviacion del mes
	 */
	private String queMes(int mes) {
		switch(mes) {
		case 1: 
			return "ene.";
		case 2: 
			return "feb.";
		case 3: 
			return "mar.";
		case 4: 
			return "abr.";
		case 5: 
			return "may.";
		case 6: 
			return "jun.";
		case 7: 
			return "jul.";
		case 8: 
			return "ago.";
		case 9: 
			return "sep.";
		case 10: 
			return "oct.";
		case 11: 
			return "nov.";
		case 12: 
			return "dic.";
		}
		return "";
	}
	
	@Override
	public String toString() {
		String str = super.toString();
		str += "\nFecha nacimiento: " + fecha_nacimiento.getDayOfMonth() + " " + queMes(fecha_nacimiento.getMonthValue()) + " " + fecha_nacimiento.getYear()
		+ "\nRelacion: " + relacion.toString() + "\n";
		return str;
	}
	
	/*
	 * metodo para ver si es su cumpleaños
	 * @return true o false si es su cumpleaños
	 */
	
	public boolean esCumpleanos() {
		LocalDate fecha = LocalDate.now();
		if(fecha_nacimiento.getDayOfMonth() == fecha.getDayOfMonth()) {
			if(fecha_nacimiento.getMonthValue() == fecha.getMonthValue()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(super.equals(obj)) {
			Personal p = (Personal) obj;
			return this.getFecha_nacimiento().equals(p.getFecha_nacimiento()) && this.getRelacion().equals(p.getRelacion());
		}
		return false;
	}
	
	
}
