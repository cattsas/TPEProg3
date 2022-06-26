import java.util.ArrayList;
public class GenIndex {
    private SameGenNode root;



    public GenIndex() {
        root = null;

    }



    public void add(String genero, Libro lb) {
        if (this.root == null) {
            this.root = new SameGenNode(genero);
            this.root.addLibro(lb);
        } else
            this.add(this.root, genero, lb);


    }

    public String getRoot() {

        return (root.getGenero());
    }

    public ArrayList<Libro> hasElement(String value) {

        if (this.getRoot() == null) {
            return (new ArrayList<>());
        } else {
            return hasElement(this.root, value);
        }
    }

    private ArrayList<Libro> hasElement(SameGenNode n, String value) {
        if (n.getGenero().equals(value)) {

            return n.getLibros();
        }

        else {
            if ((n.getGenero().compareTo(value)>0) && n.getLeft() != null) {

                return hasElement(n.getLeft(), value);
            }
            if ((n.getGenero().compareTo(value)<0)&& n.getRight() != null) {

                return hasElement(n.getRight(), value);
            }

        }

        return n.getLibros();
    }

    private void add(SameGenNode gen, String genero, Libro lb) {
        if (gen.getGenero().equals(genero)) {
            gen.addLibro(lb);
        }
        else if (gen.getGenero().compareTo(genero)>0){
            if (gen.getLeft() == null) {
                SameGenNode temp = new SameGenNode(genero);
                temp.addLibro(lb);
                gen.setLeft(temp);

            } else {
                add(gen.getLeft(), genero, lb);
            }
        }
        else {
            if (gen.getRight() == null) {
                SameGenNode temp = new SameGenNode(genero);
                temp.addLibro(lb);
                gen.setRight(temp);

            }
            else {
                add(gen.getRight(), genero, lb);
            }
        }



    }

    @Override
    public String toString() {
        return "GenIndex{" +
                "root=" + root +
                '}';
    }
}







