import java.util.ArrayList;

public class
Indice {
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

    public ArrayList<String> obtenerMasBuscados(String genero, int cantidad){
        return this.generos.obtenerAdyacentesOrdenados(genero, cantidad);
    }

    public ArrayList<String> obtenerCaminoMayorPeso(String genero, int tiempo){
        ArrayList <String> lista = new ArrayList<>();
        lista.addAll(this.generos.candidatos(this.generos.obtenerAdyacentesOrdenados(genero, tiempo), genero, tiempo));
        return lista;

    }

    public Grafo obtenerAfines(String genero){
       
        System.out.println(this.generos.buscarCiclos(genero));
        return null;
    }


    


}
