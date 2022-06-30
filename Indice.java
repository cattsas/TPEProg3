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
        this.generos.obtenerAdyacentesOrdenados(genero, cantidad);

    }

    public void obtenerCaminoMasLargo(String genero){
        this.generos.caminoMayorPeso(genero, " ");
    }

    


}
