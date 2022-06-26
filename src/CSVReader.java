import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader  {

    private String originPath;
   private ArrayList<Libro> libros ;
    private GenIndex elementos;
    public CSVReader(String originPath){
        this.originPath=originPath;
        this.libros=new ArrayList<>();
        this.elementos=new GenIndex();
    }

  public GenIndex getElementos(){
        return this.elementos;
  }
    public  void leer() {


        String csvFile = this.originPath;
        String line = "";
        String cvsSplitBy = ",";



        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] items = line.split(cvsSplitBy);
                if (!items[2].equals("Paginas")) {
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
