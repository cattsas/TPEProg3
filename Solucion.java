import java.util.ArrayList;

public class Solucion {
    private ArrayList<String> camino;
    private Integer tiempo;
    private Integer tiempoACompletar;

    public Solucion(int tiempo){
        this.camino = new ArrayList<>();
        this.tiempo = 0;
        this.tiempo = tiempoACompletar;
    }

    public boolean esSolucion(){
        return tiempo == tiempoACompletar;
    }

    public void add(String genero){
        camino.add(genero);
    }

    public ArrayList<String> getSolucion(){
        return new ArrayList<String>(this.camino);
    }

    public void setSuma(Integer suma){
        this.tiempo += suma;
    }
    
}
