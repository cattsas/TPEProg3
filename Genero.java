import java.util.ArrayList;
import java.util.HashMap;

public class Genero {

    private String nomGenero;
    private boolean visitado;

    public Genero(String nomGenero) {
        this.nomGenero = nomGenero;
        this.visitado = false;
    }

    public String getNomGenero() {
        return this.nomGenero;
    }

    public void setNomGenero(String nomGenero) {
        this.nomGenero = nomGenero;
    }

    public boolean visitado(){
        return this.visitado;
    }
    public void seVisito(){
        this.visitado=true;
    }


}
