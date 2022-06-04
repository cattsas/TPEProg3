import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {

    public static void main(String[] args) {
        ArrayList<Libro> libros = new ArrayList<>();
        GenIndex elementos = new GenIndex();

        String csvFile = "./dataset1.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] items = line.split(cvsSplitBy);
                if (!items[2].equals("Paginas")) {//Por què este control?
                    String[] listaGeneros = items[3].split(" ");
                    Libro libro = new Libro(items[0], items[1], Integer.parseInt(items[2]));
                    for (String genero : listaGeneros) {
                        elementos.add(genero, libro);
                        libro.addGeneros(genero);

                    }
                }

            }
                System.out.println(elementos);
            } catch(IOException e){
                e.printStackTrace();
            }
        }


    }
