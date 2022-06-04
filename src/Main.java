public class Main {
    public static void main(String[] args) {
    CSVReader reader=new CSVReader();
    reader.leer();
    GenIndex indice=reader.getElementos();
    CSVWritter escribir=new CSVWritter();
    escribir.escribir(indice);
    }
}
