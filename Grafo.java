import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.text.html.HTMLDocument.Iterator;

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
          if (vertGeneros.get(vertGenOrigen).containsKey(vertGenDestino)){
                Integer numero=(Integer)vertGeneros.get(vertGenOrigen).get(vertGenDestino);
              vertGeneros.get(vertGenOrigen).replace(vertGenDestino,numero,numero+1);
              System.out.println("numero: "+numero);
          }
          else{
            vertGeneros.get(vertGenOrigen).put(vertGenDestino,1);}
        }


    }

    public ArrayList<String> obtenerAdyacentesOrdenados(String genero, int cantidad){
        List<Map.Entry<String, Integer>> entryList = new ArrayList<Map.Entry<String, Integer>>(this.vertGeneros.get(genero).entrySet());
        
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> e1,
                    Map.Entry<String, Integer> e2) {
                return -e1.getValue().compareTo(e2.getValue());
            }
        });
        
        ArrayList lista = new ArrayList<>();
        int i = 0;
        while(i<entryList.size() && i<cantidad ){
            lista.add(entryList.get(i).getKey());
            i++;
        }
        System.out.println(lista);
        return lista;
    }

    public ArrayList<String> caminoMayorPeso(String genero){
        ArrayList<String> solucion = new ArrayList<>();
        String tmp = genero;
         solucion.clear();
        solucion.add(tmp);
        HashMap <String, Integer> adyacentes = this.vertGeneros.get(tmp);
        while(!adyacentes.isEmpty() && noIncluido(tmp, solucion)){
            tmp = obtenerMayorAdyacente(this.vertGeneros.get(tmp));
            solucion.add(tmp);

        }
        // while (!this.vertGeneros.get(tmp).isEmpty() && notNewAyacente(tmp, solucion)) {
        //     tmp = generoMayorPeso(this.generos.get(tmp)); // se queda con el genero de mayor peso
        //     solucion.add(tmp);
        // }
        System.out.println(solucion);
        return solucion;
    }
    private boolean noIncluido(String genero, ArrayList<String> solucion){
        for(HashMap.Entry<String, Integer> gen : this.vertGeneros.get(genero).entrySet()){
            String nombre =gen.getKey();
            if(!solucion.contains(nombre)){
                return true;
            }
            System.out.println(gen.getKey());
            System.out.println(solucion);

            System.out.println(solucion.contains((String)gen.getKey()));

        }
        return false;
    }


    
    private String obtenerMayorAdyacente(HashMap<String, Integer> adyacentes){
        String mayor = " ";
        int mayorNum = 0;
        for(HashMap.Entry<String, Integer> gen : adyacentes.entrySet()){
            if (gen.getValue() > mayorNum){
                mayor = gen.getKey();
                mayorNum = gen.getValue();
            }
        }
        return mayor;
    }

    @Override
    public String toString() {
        String cadena="";
        for (HashMap.Entry<String, HashMap<String, Integer>> entry : vertGeneros.entrySet()) {
            cadena+=("Clave: "+  entry.getKey() + " - Valor: " +entry.getValue());
        }

    return cadena;
    }
}
