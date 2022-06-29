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



    @Override
    public String toString() {
        String cadena="";
        for (HashMap.Entry<String, HashMap<String, Integer>> entry : vertGeneros.entrySet()) {
            cadena+=("Clave: "+  entry.getKey() + " - Valor: " +entry.getValue());
        }

    return cadena;
    }
}
