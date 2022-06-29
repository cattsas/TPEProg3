public class ArcoAfin {
   private Integer ocurrencias;
    private Genero genDestino;

    public ArcoAfin(Genero genDestino,Integer ocurrencias ) {
        this.ocurrencias = ocurrencias;
        this.genDestino = genDestino;
    }

    public Integer getOcurrencias() {
        return ocurrencias;
    }

    public void aumentarOcurrencias() {
        this.ocurrencias++;
    }

    public Genero getGenDestino() {
        return genDestino;
    }

    public void setGenDestino(Genero genDestino) {
        this.genDestino = genDestino;
    }
}
