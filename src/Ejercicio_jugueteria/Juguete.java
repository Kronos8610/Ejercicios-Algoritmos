public class Juguete {
	private int id;
	private String tipo;
	
	public Juguete(int id, String tipo) {
		this.id = id;
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String toString() {
		return "Juguete [id=" + id + ", tipo=" + tipo + "]";
	}
	
	
}
