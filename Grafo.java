import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Iterator;

public class Grafo {
    private HashMap<String,HashMap<String,Integer>> vertGeneros;

    private HashMap<String, String> pintados;
    private ArrayList<String> caminoRecorrido;
    private String origen;
    private Grafo aux;

    public Grafo() {
        this.vertGeneros = new HashMap<>();
        this.pintados = new HashMap<>();
        this.caminoRecorrido = new ArrayList<>();

    }

    public void setOrigen(String origen){
        this.origen = origen;
    }
    public String getOrigen(){
        return this.origen;
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
          }
          else{
            vertGeneros.get(vertGenOrigen).put(vertGenDestino,1);
            }
        }


    }

    public void addArco(String vertGenOrigen, String vertGenDestino, Integer ocurrencias) {

        if (this.vertGeneros.containsKey(vertGenOrigen)){

            this.vertGeneros.get(vertGenOrigen).put(vertGenDestino,ocurrencias);
        }


    }

    public HashMap<String,Integer> obtenerAdyacentes(String genero){
        return new HashMap<String,Integer>(this.vertGeneros.get(genero));
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
            
        return lista;
    }

    
    public ArrayList<String> candidatos(ArrayList<String> candidatos, String genero, int tiempo){
        
        Solucion solucion = new Solucion(tiempo);
        ArcoAfin arco = new ArcoAfin(null, genero, 0);

        solucion.add(arco);

        //tiene que estar ordenado el de candidatos
        while(!candidatos.isEmpty() && !solucion.esSolucion()){
            ArcoAfin tmp = seleccionar(candidatos, solucion.getSolucion(), genero, tiempo);
            candidatos.remove(tmp.getGenDestino());
            solucion.add(tmp);
            genero = tmp.getGenDestino();
        }
        if(solucion.esSolucion()){
           return solucion.getSolucion();
        }
        return null;
    }

    public ArcoAfin seleccionar(ArrayList<String> candidatos, ArrayList<String> solucion, String genero, int tiempo){
        ArrayList<String> adyacentes = new ArrayList<>();
        String valorText = " ";
        Integer valorInt = 0;
        int i = 0;
        ArrayList<String> adyOrder = this.obtenerAdyacentesOrdenados(genero, tiempo);
        while(i<candidatos.size()){
            if(!solucion.contains(adyOrder.get(i))){
                adyacentes.add(adyOrder.get(i));
                i=candidatos.size();
            }else{
                i++;
            }
        }
        valorText = adyacentes.get(0);
        valorInt = this.vertGeneros.get(genero).get(adyacentes.get(0));

        ArcoAfin arco = new ArcoAfin(genero, valorText, valorInt);
        return arco;
    }

    public boolean contieneVertice(String genero){
        return this.vertGeneros.containsKey(genero);
    }

    public Grafo buscarCiclos(String genero){
        if (!this.vertGeneros.containsKey(genero)) {
            return null;}
        //guardamos el origen en una variable de clase para acceder a ella en caso de que haya un ciclo al origen
        this.aux = new Grafo();
        this.aux.setOrigen(genero);
        //se pinta cada vertice del grafo de blanco
        for (String gen: this.vertGeneros.keySet()) {
            pintados.put(gen, "blanco");
        }
        this.buscarCiclos_visit(genero);   
     
        for(String gen: this.vertGeneros.keySet()){
            if(pintados.get(gen).equals("blanco")){
                this.buscarCiclos_visit(gen);
            }

        }
            return this.aux;
        }
    
        private void buscarCiclos_visit(String genero){
            pintados.replace(genero,"blanco", "amarillo");
            caminoRecorrido.add(genero);

            for(String gen: this.vertGeneros.get(genero).keySet()){
                if(pintados.get(gen).equals("blanco")){
                    buscarCiclos_visit(gen);
                }
                else if((pintados.get(gen)).equals("amarillo") && gen.equals(this.aux.getOrigen())){
                    caminoRecorrido.add(gen);
                    for(int i = 0; i<caminoRecorrido.size()-1; i++){
                        this.aux.addVertice(caminoRecorrido.get(i));
                        this.aux.addArco(caminoRecorrido.get(i), caminoRecorrido.get(i+1), 1);
                        
                    }
                    
                }
            }
            pintados.replace(genero, "amarillo", "negro");
            caminoRecorrido.remove(genero);

            }

    /* 
    public ArrayList<String> caminoMayorPeso(String origen){
        this.estado.clearMayor();;
        this.estado.clearCamino();;

        this.visitados.clear();
        this.estado.add(origen);
        this.visitados.add(origen);
        otrocaminoMayorPeso(origen,  this.estado);
        System.out.println(this.estado.getCaminoMayorPeso());
        return  this.estado.getCaminoMayorPeso();

    }

    private void  otrocaminoMayorPeso(String origen, Estado estado){
        if(!this.adyacentesEnCamino(origen,estado)){
            if(estado.getSuma()>=this.estado.getSuma()){
                this.estado.clearMayor();
                this.estado.addAllCaminoMayor(this.estado.getCamino());
                this.estado.cambiarSuma(estado.getSuma());
            }
        }else{
            Iterator<Map.Entry<String,Integer>> it_ady = this.vertGeneros.get(origen).entrySet().iterator();
            while(it_ady.hasNext()){
                Map.Entry<String, Integer> new_Map = (Map.Entry<String, Integer>)it_ady.next();
                if(!this.visitados.contains(new_Map.getKey())){
                    this.estado.addcaminoRecorrido(new_Map.getKey());
                    this.estado.sumar(new_Map.getValue());
                    this.visitados.add(new_Map.getKey());
                    otrocaminoMayorPeso(new_Map.getKey(), estado);
                    this.estado.removecaminoRecorrido(new_Map.getKey());
                    this.estado.restar(new_Map.getValue());
                    this.visitados.remove(new_Map.getKey());
                 
                }
            }
        }
    }

    public boolean adyacentesEnCamino(String genero, Estado estado){

        for (Map.Entry<String, Integer> ady : this.vertGeneros.get(genero).entrySet()) {
            if(!estado.estaEnCamino((String)ady.getKey())){
                return true;
            }
        }       
        return false;
    }*/


    /*
    public ArrayList<String> caminoMayorPeso(String genero, String inicial){
        ArrayList<String> solucion = new ArrayList<>();
        this.visitados.add(genero);
        //que todos los adyacentes del genero esten en los visitados
        ArrayList<String> adyacentes = new ArrayList<>();
        for (Map.Entry<String, Integer> ady : this.vertGeneros.get(genero).entrySet()) {
            adyacentes.add((String)ady.getKey());
        }       
        System.out.println("holaaa");


        if(this.visitados.containsAll(adyacentes)){
        }else{
            Iterator<Map.Entry<String,Integer>> it_ady = this.vertGeneros.get(genero).entrySet().iterator();
            while(it_ady.hasNext()){
                Map.Entry<String, Integer> new_Map = (Map.Entry<String, Integer>)it_ady.next();
                if(!this.visitados.contains(new_Map.getKey())){
                    ArrayList<String> camino = new ArrayList<>();
                    camino.addAll(caminoMayorPeso(genero, null));
                    if(this.getTamanio(camino)>= this.getTamanio(solucion)){
                        solucion.clear();
                        System.out.println(this.getTamanio(camino));

                        System.out.println(camino);
                        System.out.println(genero);

                        solucion.add(genero);
                        solucion.addAll(camino);
                    }
                }
            }

        }
        this.visitados.remove(genero);

        System.out.println(solucion);
        return solucion;
    }



    public int getTamanio(ArrayList<String> camino){
        int tamanio = 0;
        for(int i = 0; i<camino.size()-1; i++){
            System.out.println(".as.a.sd" + this.vertGeneros.get(camino.get(i)).get(camino.get(i+1)));
            tamanio += this.vertGeneros.get(camino.get(i)).get(camino.get(i+1));

        }
        return tamanio;
    }
     */

    @Override
    public String toString() {
        String cadena="";
        for (HashMap.Entry<String, HashMap<String, Integer>> entry : vertGeneros.entrySet()) {
            cadena+=("- Clave: "+  entry.getKey() + " - Valor: " +entry.getValue());
        }

    return cadena;
    }
}
