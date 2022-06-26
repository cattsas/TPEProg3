import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        CSVReader reader = new CSVReader("./dataset1.csv");
        reader.leer();
        GenIndex indice = reader.getElementos();
        CSVWritter escribir = new CSVWritter("./salida.csv");

        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        String genero = "";
        try {
            System.out.println("Ingrese gènero que desea buscar: ");
            genero = entrada.readLine();
        } catch (Exception error) {
            System.out.println(error);
        }
        escribir.escribir(indice, genero);
        Timer t = new Timer();
        t.start();

        System.out.println("Se demoro "+t.stop()+" segundos en resolver la búsqueda");
    }
}
