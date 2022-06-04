import java.util.ArrayList;
public class SameGenNode {
    private String genero;
    private ArrayList<Libro> libros;
    private SameGenNode left;
    private SameGenNode right;

    public SameGenNode(String genero) {
        this.genero = genero;
        this.left = null;
        this.right = null;
        this.libros=new ArrayList<>();
    }

    public SameGenNode getLeft() {
        return left;
    }

    public void setLeft(SameGenNode left) {
        this.left = left;
    }

    public SameGenNode getRight() {
        return right;
    }

    public void setRight(SameGenNode right) {
        this.right = right;
    }


    public void addLibro(Libro l) {
        libros.add(l);
    }

    public String getGenero() {
        return this.genero;
    }

    public String toString() {
        return genero + " libros: " + libros.size() + "izquierda: "+this.getLeft()+"derecha: "+ this.getRight();
    }

    /*Equals*/
    @Override
    public boolean equals(Object otro) {
        try {
            SameGenNode gen= (SameGenNode) otro;
            return this.getGenero().equals(gen.getGenero());
        }catch(Exception e){
            return false;
        }

    }
}
