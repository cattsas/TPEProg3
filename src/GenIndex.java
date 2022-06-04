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

    public boolean hasElement(String value) {
        if (this.getRoot() == null) {
            return false;
        } else {
            return hasElement(this.root, value);
        }
    }

    private boolean hasElement(SameGenNode n, String value) {
        if (n.getGenero().equals(value)) {
            return true;
        } else {
            if (n.getLeft() != null) {
                return hasElement(n.getLeft(), value);
            }
            if (n.getRight() != null) {
                return hasElement(n.getRight(), value);
            }
            return false;
        }
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







