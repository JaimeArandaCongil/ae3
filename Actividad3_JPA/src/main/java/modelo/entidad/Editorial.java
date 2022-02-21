package modelo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Editorial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String direccion;
	
	// Referenciamos en los dos lados para que sea bidireccional
	@OneToMany(mappedBy="editorial", cascade=CascadeType.PERSIST) // Le ponemos cascade persist para que dé de alta libros cuando demos de alta la editorial
	private List<Libro> librosPublicados;

	
	public Editorial() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Editorial(Integer id, String nombre, String direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
	}

	public int getId() {
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Libro> getLibrosPublicados() {
		return librosPublicados;
	}

	public void setLibrosPublicados(List<Libro> librosPublicados) {
		this.librosPublicados = librosPublicados;
	}
	
	
	
}
