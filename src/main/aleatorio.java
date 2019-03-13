package main;

public class aleatorio {

    private static double inicio = 0;
    private static double fin = 0;

    public aleatorio(double inicio, double fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    public static double getAleatorioGlobal(double inicio, double fin) {
        return Math.random() * (fin - inicio) + inicio;
    }

    public double getAleatorioLocal(double inicio, double fin) {
        this.setInicio(inicio);
        this.setFin(fin);
        return Math.random() * (this.getFin() - this.getInicio()) + this.getInicio();
    }

    /**
     * @return the inicio
     */
    public double getInicio() {
        return inicio;
    }

    /**
     * @param inicio the inicio to set
     */
    public void setInicio(double inicio) {
        this.inicio = inicio;
    }

    /**
     * @return the fin
     */
    public double getFin() {
        return fin;
    }

    /**
     * @param fin the fin to set
     */
    public void setFin(double fin) {
        this.fin = fin;
    }
}
