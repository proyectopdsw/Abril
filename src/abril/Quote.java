package abril;

public class Quote {
	Integer id;
	String nombre;
	String message;
	
	public Quote() {
	}
 
	public Quote(Integer id) {
		super();
		this.id = id;
	}
 
	public Quote(Integer id, String nombre, String message) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.message = message;
	}
 
	public Integer getId() {
		return id;
	}
 
	public void setId(Integer id) {
		this.id = id;
	}
 
	public String getNombre() {
		return nombre;
	}
 
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
 
	public String getMessage() {
		return message;
	}
 
	public void setMessage(String message) {
		this.message = message;
	}
 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quote other = (Quote) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
 
	@Override
	public String toString() {
		return "Quote [id=" + id + ", Nombre=" + nombre + ", message="
				+ message + "]";
	}
 
}
