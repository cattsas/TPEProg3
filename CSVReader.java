import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader  {

    private String originPath;

    private Grafo generos;
    public CSVReader(String originPath){
        this.originPath=originPath;

        this.generos=new Grafo();
    }

  public Grafo getElementos(){
        return this.generos;
  }

  public  void leer() {

        String csvFile = this.originPath;
        String line = "";
        String cvsSplitBy = ",";



        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {

                    String[] listaGeneros = line.split(",");

                    for (int i=0;i< listaGeneros.length;i++) {
                        this.generos.addVertice(listaGeneros[i]);
                        if (i< listaGeneros.length-1){
                        this.generos.addArco(listaGeneros[i],listaGeneros[i+1]);

                    }
                        System.out.println(listaGeneros.length);}
              

            }
                System.out.println(generos);
            } catch(IOException e){
                e.printStackTrace();
            }
        }


    }
