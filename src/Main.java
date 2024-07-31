import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Date;

class Libro {
    private String titulo;
    private String autor;
    private String editorial;
    private int anioPublicacion;
    private int numeroPaginas;

    public Libro(String titulo, String autor, String editorial, int anioPublicacion, int numeroPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.anioPublicacion = anioPublicacion;
        this.numeroPaginas = numeroPaginas;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", editorial='" + editorial + '\'' +
                ", anioPublicacion=" + anioPublicacion +
                ", numeroPaginas=" + numeroPaginas +
                '}';
    }
}

class Usuario {
    private String nombre;
    private String apellido;
    private String correoElectronico;
    private String numeroIdentificacion;

    public Usuario(String nombre, String apellido, String correoElectronico, String numeroIdentificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", numeroIdentificacion='" + numeroIdentificacion + '\'' +
                '}';
    }

    public String getNombre() {
        return "";
    }
}

class Prestamo {
    private Libro libro;
    private Usuario usuario;
    private Date fechaPrestamo;
    private Date fechaDevolucion;

    public Prestamo(Libro libro, Usuario usuario, Date fechaPrestamo, Date fechaDevolucion) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public String toString() {
        return "Prestamo{" +
                "libro=" + libro +
                ", usuario=" + usuario +
                ", fechaPrestamo=" + fechaPrestamo +
                ", fechaDevolucion=" + fechaDevolucion +
                '}';
    }
}

class Biblioteca {
    private ArrayList<Libro> libros;
    private HashMap<String, Usuario> usuarios;
    private Queue<Prestamo> prestamos;

    public Biblioteca() {
        libros = new ArrayList<>();
        usuarios = new HashMap<>();
        prestamos = new LinkedList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void eliminarLibro(Libro libro) {
        libros.remove(libro);
    }

    public Libro buscarLibro(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equals(titulo)) {
                return libro;
            }
        }
        return null;
    }

    public ArrayList<Libro> listarLibros() {
        return libros;
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.put(usuario.getNumeroIdentificacion(), usuario);
    }

    public Usuario consultarUsuario(String numeroIdentificacion) {
        return usuarios.get(numeroIdentificacion);
    }

    public void realizarPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }

    public void devolverLibro(Prestamo prestamo) {
        prestamos.remove(prestamo);
    }

    public Queue<Prestamo> consultarPrestamosActivos() {
        return prestamos;
    }
}

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        Libro libro1 = new Libro("El Quijote", "Miguel de Cervantes", "Editorial A", 1605, 500);
        Libro libro2 = new Libro("Cien Años de Soledad", "Gabriel García Márquez", "Editorial B", 1967, 400);

        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);

        Usuario usuario1 = new Usuario("Juan", "Pérez", "juan.perez@example.com", "12345");
        Usuario usuario2 = new Usuario("Ana", "García", "ana.garcia@example.com", "67890");

        biblioteca.registrarUsuario(usuario1);
        biblioteca.registrarUsuario(usuario2);

        Prestamo prestamo1 = new Prestamo(libro1, usuario1, new Date(), null);
        Prestamo prestamo2 = new Prestamo(libro2, usuario2, new Date(), null);

        biblioteca.realizarPrestamo(prestamo1);
        biblioteca.realizarPrestamo(prestamo2);

        biblioteca.devolverLibro(prestamo1);
        biblioteca.devolverLibro(prestamo2);
        
        System.out.println("Libros en la biblioteca: " + biblioteca.listarLibros().size());
        System.out.println("Usuarios registrados: " + biblioteca.consultarUsuario("12345").getNombre());
    }
}