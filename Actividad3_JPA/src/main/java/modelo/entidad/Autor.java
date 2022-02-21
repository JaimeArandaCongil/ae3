package modelo.entidad;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Autor {
	
	// Asignamos al atributo id la cualidad de PrimaryKey o identificador único, y hacemos que se autogenere (autoincrementado)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String apellidos;
	private String fechaNacimiento;  
	
	@OneToMany(mappedBy="autor", cascade=CascadeType.PERSIST) // Le ponemos cascade persist para que dé de alta libros cuando demos de alta la editorial
	// Relación bidireccional con la entidad Libro
	private List<Libro> librosEscritos;
	
	
	public Autor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Autor(Integer id, String nombre, String apellidos, String fechaNacimiento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
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
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public List<Libro> getLibrosEscritos() {
		return librosEscritos;
	}

	public void setLibrosEscritos(List<Libro> librosEscritos) {
		this.librosEscritos = librosEscritos;
	}
	@Override
	public String toString() {
		return "Autor [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimiento="
				+ fechaNacimiento + "]";
	}
	
}
