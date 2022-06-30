import java.util.ArrayList;

public class Estado {
    private ArrayList<String> caminoParcial;
    private ArrayList<String> caminoMayor;

    private int suma;
    private int sumaMayor;

    public Estado(){
        this.caminoParcial = new ArrayList<String>();
        this.caminoMayor = new ArrayList<String>();
        this.suma = 0;
    }

    public boolean estaEnCamino(String genero){
        return this.caminoParcial.contains(genero);
    }

    public void add(String gen){
        caminoParcial.add(gen);
    }
    public void addCaminoParcial(String genero){
        caminoParcial.add(genero);
    }

    public void removeCaminoParcial(String genero){
        caminoParcial.remove(genero);
    }
    public void addAllCaminoMayor(ArrayList<String> camino){
        caminoMayor.addAll(camino);
    }

    public void addAllACaminoParcial(ArrayList<String> camino){
        caminoParcial.addAll(camino);
    }
    public ArrayList<String> getCamino(){
        return new ArrayList<>(this.caminoParcial);
    }

    public ArrayList<String> getCaminoMayor(){
        return new ArrayList<>(this.caminoMayor);
    }
    public void clearMayor(){
        this.caminoMayor.clear();
    }

    public void sumar(int total){
        this.suma += total;
    }

    public void restar(int total){
        this.suma -= total;
    }

    public void cambiarSuma(int total){
        this.suma = total;
    }

    public int getSuma(){
        return this.suma;
    }


}
