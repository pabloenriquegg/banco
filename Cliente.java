
public class Cliente {
	private int codigoCliente;
	private String dni;
	private String nombre;
	private String apellidos;
	private String direccion;
	private String telefono;
	
//Constructor
	public Cliente(int codigoCliente, String dni, String nombre, String apellidos, String direccion, String telefono) {
		this.codigoCliente = codigoCliente++;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	
	public Cliente() {
		//constructor vacio
	}

//Getters y setters
	public int getCodigoCliente() {
		return codigoCliente;
	}
	
	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
