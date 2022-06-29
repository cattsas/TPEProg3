import java.util.ArrayList;
import java.util.HashMap;

public class Genero {

    private String nomGenero;
    private HashMap afin;

    public Genero(String nomGenero, ArcoAfin afin) {
        this.nomGenero = nomGenero;
        this.afin = new HashMap<String,ArcoAfin>();
    }

    public String getNomGenero() {
        return nomGenero;
    }

    public void setNomGenero(String nomGenero) {
        this.nomGenero = nomGenero;
    }


}
