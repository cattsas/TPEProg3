import java.util.ArrayList;

public class Indice {
    private CSVReader reader;
    private Grafo generos;

    public Indice(String path){
        this.reader = new CSVReader(path);
        this.generos = new Grafo();
    }
    public void obtenerDatos(){
        this.reader.leer();
        this.generos = reader.getElementos();
    }

    public void obtenerMasBuscados(String genero, int cantidad){
        System.out.println( this.generos.obtenerAdyacentesOrdenados(genero, cantidad));

        this.generos.obtenerAdyacentesOrdenados(genero, cantidad);

    }

    public void obtenerCaminoMayorPeso(String genero, int tiempo){
        ArrayList <String> lista = new ArrayList<>();
        lista.add(genero);
        lista.addAll(this.generos.candidatos(this.generos.obtenerAdyacentesOrdenados(genero, tiempo), genero, tiempo));
        System.out.println(lista);

    }

    


}
