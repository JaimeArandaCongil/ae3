package modelo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private double precio;
	
	@ManyToOne // No le pondremos un (cascade=CascadeType.ALL) para que borrar un libr no nos borre la editorial
	// Creamos la foreign key que unirá las dos tablas o entidades, que será el id del autor 
	// Dado que estamos en el lado de "many" de la relación, la @JoinColumn siempre estará en este lado en este tipo de relaciones
	@JoinColumn(name="fk_id_autor", referencedColumnName="id")
	private Autor autor;
	
	@ManyToOne // No le pondremos un (cascade=CascadeType.ALL) para que borrar un libr no nos borre la editorial
	// Creamos la foreign key que unirá las dos tablas o entidades, que será el id de la editorial 
	// Dado que estamos en el lado de "many" de la relación, la @JoinColumn siempre estará en este lado en este tipo de relaciones
	@JoinColumn(name="fk_id_editorial", referencedColumnName="id")
	private Editorial editorial;
	
	@ManyToMany(mappedBy="coleccionLibros", cascade=CascadeType.PERSIST)
	private List<Libreria> librerias;

	
	public Libro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Libro(Integer id, String titulo, double precio, Autor autor, Editorial editorial, List<Libreria> librerias) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.precio = precio;
		this.autor = autor;
		this.editorial = editorial;
		this.librerias = librerias;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	public List<Libreria> getLibrerias() {
		return librerias;
	}

	public void setLibrerias(List<Libreria> librerias) {
		this.librerias = librerias;
	}
	
	
}
