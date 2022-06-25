

import java.io.*;
import java.net.StandardSocketOptions;
import java.util.ArrayList;

public class CSVWritter {

    public  void escribir(GenIndex indice, String genero) {

        BufferedReader entrada=new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bw = null;
        try {
            File file = new File("./salida.csv");
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);




         /*
            try {
                System.out.println("Ingrese gènero que desea buscar: ");
                genero=entrada.readLine();
            }
            catch(Exception error){
                System.out.println(error);
            }*/

            ArrayList<Libro> libros=indice.hasElement(genero);

            for (Libro libro: libros){
                String titulo=libro.getTitulo();
                bw.write(titulo);
                bw.newLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

}