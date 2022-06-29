import java.util.HashMap;

public class Grafo {
    private HashMap<String,HashMap<String,Integer>> vertGeneros;

    public Grafo() {
        this.vertGeneros = new HashMap<>();
    }

    public void addVertice(String nomGen) {
        if (!vertGeneros.containsKey(nomGen))
            vertGeneros.put(nomGen, new HashMap<>());

    }

    public void addArco(String vertGenOrigen, String vertGenDestino) {
        if (vertGeneros.containsKey(vertGenOrigen)){
          //  ArcoAfin arco=new ArcoAfin(vertGenDestino.g)
            vertGeneros.get(vertGenOrigen).put(vertGenDestino,1);
        }

    }

    @Override
    public String toString() {
        String cadena="";
        for (HashMap.Entry<String, HashMap<String, Integer>> entry : vertGeneros.entrySet()) {
            cadena+=("Clave: "+  entry.getKey() + "Valor: " +entry.getValue());
        }

    return cadena;
    }
}
