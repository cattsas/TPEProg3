import java.util.ArrayList;

public class Solucion {
    private ArrayList<String> solucion ;  
    private Integer sumatoria; 
    private Integer tiempo;
    private Integer tiempoACompletar;

    public Solucion(Integer tiempo){
        this.solucion =  new ArrayList();
        this.sumatoria = 0;
        this.tiempo = 0;
        this.tiempoACompletar = tiempo;
    }

    public boolean esSolucion(){
        return tiempo.equals(tiempoACompletar);
    }

    public void add(ArcoAfin arco){
        this.solucion.add(arco.getGenDestino());
        this.sumatoria+= arco.getOcurrencias();
        this.tiempo++;
    }

    public Integer getSumatoria() {
        return sumatoria;
    }

    public ArrayList<String> getSolucion(){
        return this.solucion;
    }

 
    
}
