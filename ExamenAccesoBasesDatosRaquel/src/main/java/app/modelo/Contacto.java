package app.modelo;



public class Contacto {
	
	private int idContacto;
	private String nombre;
	private String email;
	private String telefono;
	
	public Contacto() {
		// TODO Auto-generated constructor stub
	}

	public Contacto(String nombre, String email, String telefono) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
	}

	public Contacto(int idContacto, String nombre, String email, String telefono) {
		super();
		this.idContacto = idContacto;
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
	}

	public int getIdContacto() {
		return idContacto;
	}

	public void setIdContacto(int idContacto) {
		this.idContacto = idContacto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Contacto [idContacto = " + idContacto + ", nombre = " + nombre + ", email = " + email + ", telefono = "
				+ telefono + "]";
	}
	
	
		
}
