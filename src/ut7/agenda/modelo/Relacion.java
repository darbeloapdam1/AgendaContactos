package ut7.agenda.modelo;

public enum Relacion {
	PADRE("padre"), MADRE("madre"), AMIGOS("amigos"), PAREJA("pareja"), HIJO("hijo"), HIJA("hija");
	
	private String relacion;

	Relacion(String string) {
		this.relacion = string;
	}
	
	public String getRelacion() {
		return relacion;
	}
	
}
