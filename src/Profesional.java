
public class Profesional extends Contacto {
	
	public String empresa;
	
	public Profesional(String nombre, String apellidos, String telefono, String email, String empresa) {
		super(nombre, apellidos, telefono, email);
		this.empresa = empresa;
	}
	


	@Override
	public String mensaje() {
		// TODO Auto-generated method stub
		return null;
	}

}
