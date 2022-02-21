package modelo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Libreria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String nombreDueño;
	private String direccion;
	
	// Establecemos la relación ManyToMany con la entidad libro, creando una tabla intermedia (librerias_libros) en la que
	// se conectan las entidades Libro y Libreria por medio de foreign keys (que corresponden con la P.K. o id de cada una de las entidades)
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="librerias_libros",
				joinColumns= {@JoinColumn(name="fk_id_libreria", referencedColumnName="id")},
						inverseJoinColumns= {@JoinColumn(name="fk_id_libro", referencedColumnName="id")})
	private List<Libro> coleccionLibros;

	public Libreria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Libreria(Integer id, String nombre, String nombreDueño, String direccion, List<Libro> coleccionLibros) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.nombreDueño = nombreDueño;
		this.direccion = direccion;
		this.coleccionLibros = coleccionLibros;
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

	public String getNombreDueño() {
		return nombreDueño;
	}

	public void setNombreDueño(String nombreDueño) {
		this.nombreDueño = nombreDueño;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Libro> getColeccionLibros() {
		return coleccionLibros;
	}

	public void setColeccionLibros(List<Libro> coleccionLibros) {
		this.coleccionLibros = coleccionLibros;
	}
	
	
	
}
