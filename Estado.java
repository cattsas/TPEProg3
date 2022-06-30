import java.util.ArrayList;

public class Estado {
    private ArrayList<String> caminoParcial;
    private int suma;

    public Estado(){
        this.caminoParcial = new ArrayList<String>();
        this.suma = 0;
    }

    public void add(String gen){
        caminoParcial.add(gen);
    }

    public void sumar(int total){
        this.suma += total;
    }
}
