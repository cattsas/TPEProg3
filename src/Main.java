import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        CSVReader reader = new CSVReader("./dataset1.csv");
        reader.leer();
        Timer ti = new Timer();
        ti.start();
        System.out.println("Se demoro "+ti.stop()+" segundos en generar el arbol");

        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        String genero = "";
        try {
            System.out.println("Ingrese género que desea buscar: ");
            genero = entrada.readLine();
        } catch (Exception error) {
            System.out.println(error);
        }

        GenIndex indice = reader.getElementos();
        CSVWritter escribir = new CSVWritter("./salida.csv");
        escribir.escribir(indice, genero);
        Timer t = new Timer();
        t.start();

        System.out.println("Se demoro "+t.stop()+" segundos en resolver la búsqueda y se realizaron "+indice.getCantIteracciones()+ " iteraciones");

    }
}
