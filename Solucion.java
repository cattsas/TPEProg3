import java.util.ArrayList;

public class Solucion {
    private Grafo grafo ;   
    private Integer tiempo;
    private Integer tiempoACompletar;

    public Solucion(Integer tiempo){
        this.grafo =  new Grafo();
        this.tiempo = 0;
        this.tiempoACompletar = tiempo;
    }

    public boolean esSolucion(){
        return tiempo.equals(tiempoACompletar);
    }

    public void add(ArcoAfin arco){
        this.grafo.addVertice(arco.getGenOrigen());
        this.grafo.addArco(arco.getGenOrigen(), arco.getGenDestino(), arco.getOcurrencias());
    }

    public Grafo getSolucion(){
        return this.grafo;
    }

    public void setSuma(Integer suma){
        this.tiempo += suma;
    }
    
}
