package main;

public class simulador {

    private double media = 0, desviacionEstandar = 0, inicio = 0, fin = 0;

    /*
        La demanda almacena valores entre 45000 y 75000 y los suma, al finalizar la simulación
        divide la suma por el total de iteraciones
     */
    private double demanda = 0;
    private int ensayos = 0; // Dada por el usuario

    /**
     * Almacena el promedio de ventas que se lleven a cabo, este es dicho por el
     * valor generado por el aleatorio
     */
    private double ventasVacacionales = 0;
    private double ventasExedentes = 0;

    private double ingresoVacacional = 0;
    private double ingresoExcedente = 0;
    private double valorArticuloVacacional = 42; // $42
    private double valorArticuloExcendente = 10; // $10
    private double gastosFijos = 100000; // $100000
    private double costosVariables = 34; // $34
    private double unidadesAProducir = 0; // Definida por el usuario. Según el problema se inicia con 60000 unidades

    private double demandaCubierta = 0;
    private double demandaExcedida = 0;

    /**
     * La utilidad esperada se da como el promedio de la
     * (sumatoria(ingresosVacacionalPROMEDIO + ingresosExcendentePROMEDIO -
     * costosVariablesPROMEDIO) - gastosFijospROMEDIO)
     */
    private double utilidad = 0;

    public simulador(double media, double desviacionEstandar) {
        this.media = media;
        this.desviacionEstandar = desviacionEstandar;
    }

    public static double runSimulationGlobal(double media, double desviacionEstandar, double inicio, double fin) {
        return JPMath.redondearDecimales(normal.getPx(aleatorio.getAleatorioGlobal(inicio, fin), media, desviacionEstandar), 3);
    }

    public double runSimulationLocal(double media, double desviacionEstandar, double inicio, double fin) {
        this.setMedia(media);
        this.setDesviacionEstandar(desviacionEstandar);
        this.setInicio(inicio);
        this.setFin(fin);
        return JPMath.redondearDecimales(normal.getPx(aleatorio.getAleatorioGlobal(this.getInicio(), this.getFin()), this.getMedia(), this.getDesviacionEstandar()), 3);
    }

    public void sumarDemanda() { // Suma la demanda en cada iteración
        double demanda = aleatorio.getAleatorioGlobal(this.getInicio(), this.getFin());
        this.setDemanda(this.getDemanda() + demanda);
    }

    public void sumarVentasVacacionales(double demanda, double porcentajeCubierto) {
        this.setDemandaCubierta(this.getDemandaCubierta() + (porcentajeCubierto * demanda) / 100);
        this.setDemandaExcedida(this.getDemandaExcedida() + (demanda - (porcentajeCubierto * demanda) / 100));
        this.setIngresoVacacional(this.getIngresoVacacional() + ((porcentajeCubierto * demanda) / 100) * this.getValorArticuloVacacional());
        this.setIngresoExcedente(this.getIngresoExcedente() + ((demanda - (porcentajeCubierto * demanda) / 100) * this.getValorArticuloExcendente()));
    }

    /**
     * @return the media
     */
    public double getMedia() {
        return media;
    }

    /**
     * @param media the media to set
     */
    public void setMedia(double media) {
        this.media = media;
    }

    /**
     * @return the desviacionEstandar
     */
    public double getDesviacionEstandar() {
        return desviacionEstandar;
    }

    /**
     * @param desviacionEstandar the desviacionEstandar to set
     */
    public void setDesviacionEstandar(double desviacionEstandar) {
        this.desviacionEstandar = desviacionEstandar;
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

    /**
     * @return the demanda
     */
    public double getDemanda() {
        return demanda;
    }

    /**
     * @param demanda the demanda to set
     */
    public void setDemanda(double demanda) {
        this.demanda = demanda;
    }

    /**
     * @return the ensayos
     */
    public int getEnsayos() {
        return ensayos;
    }

    /**
     * @param ensayos the ensayos to set
     */
    public void setEnsayos(int ensayos) {
        this.ensayos = ensayos;
    }

    /**
     * @return the ventasVacacionales
     */
    public double getVentasVacacionales() {
        return ventasVacacionales;
    }

    /**
     * @param ventasVacacionales the ventasVacacionales to set
     */
    public void setVentasVacacionales(double ventasVacacionales) {
        this.ventasVacacionales = ventasVacacionales;
    }

    /**
     * @return the ventasExedentes
     */
    public double getVentasExedentes() {
        return ventasExedentes;
    }

    /**
     * @param ventasExedentes the ventasExedentes to set
     */
    public void setVentasExedentes(double ventasExedentes) {
        this.ventasExedentes = ventasExedentes;
    }

    /**
     * @return the ingresoVacacional
     */
    public double getIngresoVacacional() {
        return ingresoVacacional;
    }

    /**
     * @param ingresoVacacional the ingresoVacacional to set
     */
    public void setIngresoVacacional(double ingresoVacacional) {
        this.ingresoVacacional = ingresoVacacional;
    }

    /**
     * @return the ingresoExcedente
     */
    public double getIngresoExcedente() {
        return ingresoExcedente;
    }

    /**
     * @param ingresoExcedente the ingresoExcedente to set
     */
    public void setIngresoExcedente(double ingresoExcedente) {
        this.ingresoExcedente = ingresoExcedente;
    }

    /**
     * @return the valorArticuloVacacional
     */
    public double getValorArticuloVacacional() {
        return valorArticuloVacacional;
    }

    /**
     * @param valorArticuloVacacional the valorArticuloVacacional to set
     */
    public void setValorArticuloVacacional(double valorArticuloVacacional) {
        this.valorArticuloVacacional = valorArticuloVacacional;
    }

    /**
     * @return the valorArticuloExcendente
     */
    public double getValorArticuloExcendente() {
        return valorArticuloExcendente;
    }

    /**
     * @param valorArticuloExcendente the valorArticuloExcendente to set
     */
    public void setValorArticuloExcendente(double valorArticuloExcendente) {
        this.valorArticuloExcendente = valorArticuloExcendente;
    }

    /**
     * @return the gastosFijos
     */
    public double getGastosFijos() {
        return gastosFijos;
    }

    /**
     * @param gastosFijos the gastosFijos to set
     */
    public void setGastosFijos(double gastosFijos) {
        this.gastosFijos = gastosFijos;
    }

    /**
     * @return the costosVariables
     */
    public double getCostosVariables() {
        return costosVariables;
    }

    /**
     * @param costosVariables the costosVariables to set
     */
    public void setCostosVariables(double costosVariables) {
        this.costosVariables = costosVariables;
    }

    /**
     * @return the unidadesAProducir
     */
    public double getUnidadesAProducir() {
        return unidadesAProducir;
    }

    /**
     * @param unidadesAProducir the unidadesAProducir to set
     */
    public void setUnidadesAProducir(double unidadesAProducir) {
        this.unidadesAProducir = unidadesAProducir;
    }

    /**
     * @return the demandaCubierta
     */
    public double getDemandaCubierta() {
        return demandaCubierta;
    }

    /**
     * @param demandaCubierta the demandaCubierta to set
     */
    public void setDemandaCubierta(double demandaCubierta) {
        this.demandaCubierta = demandaCubierta;
    }

    /**
     * @return the demandaExcedida
     */
    public double getDemandaExcedida() {
        return demandaExcedida;
    }

    /**
     * @param demandaExcedida the demandaExcedida to set
     */
    public void setDemandaExcedida(double demandaExcedida) {
        this.demandaExcedida = demandaExcedida;
    }

    /**
     * @return the utilidad
     */
    public double getUtilidad() {
        return utilidad;
    }

    /**
     * @param utilidad the utilidad to set
     */
    public void setUtilidad(double utilidad) {
        this.utilidad = utilidad;
    }
}
