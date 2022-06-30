import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
     CSVReader reader = new CSVReader("Datasets2daEtapa/dataset1.csv");
     BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
     reader.leer();
     Indice index = new Indice("./Datasets2daEtapa/dataset1.csv");
     index.obtenerDatos();
     String genero = " ";
     int cantidad = 0;
     try{
      System.out.println("Ingrese el género del que desea obtener el listado de más buscados");
      genero = entrada.readLine();
      System.out.println("Ingrese la cantidad de géneros que desea hallar");
      cantidad = new Integer(entrada.readLine());
      if(index.obtenerMasBuscados(genero, cantidad).isEmpty()){
        System.out.println("La búsqueda no arrojó resultados");
      }else{
        System.out.println("El listado es el siguiente: " + index.obtenerMasBuscados(genero, cantidad).isEmpty());
      }
      System.out.println("Ingrese el género del cual desea obtener el camino mayor");
      genero = entrada.readLine();
      System.out.println("Ingrese el tiempo polinomial (expresado en números enteros)");
      cantidad = new Integer(entrada.readLine());
      if(index.obtenerCaminoMayorPeso(genero, cantidad).isEmpty()){
        System.out.println("La búsqueda no arrojó resultados");
      }else{
        System.out.println("El listado es el siguiente: " + index.obtenerCaminoMayorPeso(genero, cantidad));
      }
      System.out.println("Ingrese el género del cual desea verificar si hay una vinculación cerrada");
      genero = entrada.readLine();
      if(index.obtenerAfines(genero) != null){
        System.out.println("Ingrese el género del cual desea verificar si hay una vinculación cerrada");
        System.out.println(index.obtenerAfines(genero));
      }
     }catch(Exception err){
        System.out.println(err);
     }


    }


}
