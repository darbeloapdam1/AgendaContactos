
public class Profesional extends Contacto {
	
	public String empresa;

	public Profesional(String nombre, String apellidos, String telefono, String email, String empresa) {
		super(nombre, apellidos, telefono, email);
		this.empresa = capitalizar(empresa);
	}
	
	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = capitalizar(empresa);
	}
	
	public String capitalizar(String str) {	
		boolean primera = true;
        String resul = "";
        for(int i = 0; i < str.length(); i++) {
            if(primera) {
            	resul += str.toUpperCase().substring(i,i + 1).charAt(0);
                primera = false;
            }
            else{
            	resul += str.substring(i,i + 1).charAt(0);
            }
            if (str.substring(i,i+1).equals(" "))
                primera = true;
        }
        return resul;
	}

	@Override
	public String getFirmaEmail() {
		String[] firma = {"Atentamente", "Saludos", "Saludos cordiales", "Mis mejores deseos"};
		return firma[(int) (Math.random() * 3)];
	}
	
	@Override
	public String toString() {
		String str = ("Contactos profesionales" + "\n" + super.toString() + "\nEmpresa: " + empresa);
		return str;
	}
	
	@Override 
	public boolean equals(Object obj) {
		if(super.equals(obj)) {
			Profesional pro = (Profesional) obj;
			if(this.getEmpresa().equals(pro.getEmpresa())) {
				return true;
			}
		}
		return false;
	}

}
