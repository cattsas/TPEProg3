import java.util.ArrayList;

public class Libro {
    private String titulo;
    private String autor;
    private int cantidadPaginas;
    private ArrayList<String> generos;

    public Libro(String titulo, String autor, int cantidadPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.cantidadPaginas = cantidadPaginas;
        this.generos = new ArrayList<>();
    }

    public String getTitulo(){
        return this.titulo;
    }

    public String getAutor(){
        return this.autor;
    }

    public int cantPaginas(){
        return this.cantidadPaginas;
    }

    public void addGeneros(String genero){
        generos.add(genero);
    }

    public String toString(){
        String text = this.titulo + " " + this.autor + " " + this.cantidadPaginas;
        for (String genero : this.generos) {
            text += " " + genero;
        }
        return text;
    }
}
