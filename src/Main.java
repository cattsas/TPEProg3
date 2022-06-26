import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
    CSVReader reader=new CSVReader();
    reader.leer("./dataset1.csv");
        reader.leer("./dataset2.csv");
        reader.leer("./dataset3.csv");
        reader.leer("./dataset4.csv");
    GenIndex indice=reader.getElementos();
    CSVWritter escribir=new CSVWritter("./salida.csv");

    BufferedReader entrada=new BufferedReader(new InputStreamReader(System.in));

    String genero="";
        try {
            System.out.println("Ingrese gènero que desea buscar: ");
            genero=entrada.readLine();
        }
        catch(Exception error){
            System.out.println(error);
        }
    escribir.escribir(indice,genero);
    }
}
