public class ArcoAfin {
   private Integer ocurrencias;
   private String genOrigen;
    private String genDestino;

    public ArcoAfin(String genOrigen, String genDestino,Integer ocurrencias ) {
        this.ocurrencias = ocurrencias;
        this.genOrigen = genOrigen;
        this.genDestino = genDestino;

    }

    public Integer getOcurrencias() {
        return ocurrencias;
    }

    public void aumentarOcurrencias() {
        this.ocurrencias++;
    }

    public String getGenDestino() {
        return this.genDestino;
    }

    public void setGenDestino(String genDestino) {
        this.genDestino = genDestino;
    }
}
