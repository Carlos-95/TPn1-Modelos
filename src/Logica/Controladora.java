/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import Visual.VentanaPrincipal;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author albor
 */
public class Controladora {

    private double semilla;
    private double modulo;
    private double incremento;
    private double multiplicador;
    private int longitudPeriodo;
//    
    private int cantidadJugadores;
    
    private int generadorSeleccionado;
    private int cantidadNumerosGenerar = 20000;
    
    private List<Apuesta> apuestas = new LinkedList();
    private List<Bolillero> bolillas = new LinkedList();
    private List<Jugador> jugadores = new LinkedList();
    
    private List<Double> numeroGeneradosPorUsuario = new LinkedList();
    private List<Double> numeroGeneradosPorUsuarioEstandarizados = new LinkedList();
    private List<Double> secuenciaCantidadJugadores = new LinkedList();
    
    private int indice=0;//indiceNumerosGeneradosEstandarizados=0;
    //private 
    /**
     * @param args the command line arguments
     */
    
    public void setearGenerador(double semilla, double incremento, double multiplicador, double modulo, int generadorSeleccionado) throws Exception{
        this.semilla = semilla;
        this.incremento = incremento;
        this.multiplicador = multiplicador;
        this.modulo = modulo;
        this.generadorSeleccionado = generadorSeleccionado;
        this.validarVariablesGenerador();
        //this.indiceValoresGenerados=0;
    }
    
    public double generadorCongruencialLineal(int modulo, int incremento, int multiplicador, double semilla){
        double retorno;
        this.semilla=semilla;
        this.modulo = modulo;
        this.incremento=incremento;
        this.multiplicador=multiplicador;
        retorno = (semilla*multiplicador + incremento)%modulo;
        return retorno;
    }
    
    public double generadorCongruencialMultiplicativo(int modulo, int incremento, int multiplicador, Double semilla){
        double retorno;
        this.semilla=semilla;
        this.modulo = modulo;
        this.incremento=incremento;
        this.multiplicador=multiplicador;
        retorno = (semilla*multiplicador + 0)%modulo;
        return retorno;
    }
    
    private double estandarizar(double valor, int modulo){
        double estandarizado = valor/modulo;
        return estandarizado;
    }
    
        
private void validarVariablesGenerador() throws Exception{
        if((modulo < 20000)){
            throw new Exception("Debe cumplirse: m>=20000");
        }
        if(!(0 < multiplicador && multiplicador < modulo)){
            throw new Exception("Debe cumplirse: 0<a<m");
        }
        if( (incremento < 0) || ((incremento == 0) && (generadorSeleccionado == 1)) || (incremento > modulo) ){
            throw new Exception("Debe cumplirse: 0<c<m");
        }
        if(!(0 < semilla && semilla < modulo)){
            throw new Exception("Debe cumplirse: 0<X0<m");
        }
    }

    public int obtenerEnteroEntreDosNumeros(int valorMaximo, int valorMinimo/*, boolean indicador*/){
        double RND=0;//Math.random();
        int retorno=1;
            RND=Math.random();
            retorno = (int)((valorMaximo-valorMinimo+1)*RND+valorMinimo);
        return retorno;
    }
    
    public List<Jugador> crearJugadoresRonda(int cantJugadores){
        this.jugadores.clear();
        for (int i = 0; i < cantJugadores; i++) {
            this.crearJugador();
        }
        return this.jugadores;
    }
    
    public Jugador crearJugador(){
        Jugador unJugador = new Jugador(this.jugadores.size()+1, 0);
        this.jugadores.add(unJugador);
        return unJugador; //crea un jugador con saldo cero
    }
    
    public List<Jugador> dameTodosLosJugadores(){
        System.out.println(jugadores.size());
        return this.jugadores;
    }
    
    public void modificarJugador(Jugador unJugador, int saldo){
        unJugador.setSaldoDisponible(saldo);
    }
    public int obtenerDineroParaJugador(int valorMaximo, int valorMinimo){
        double RND=Math.random();
        int retorno = (int)((valorMaximo-valorMinimo+1)*RND+valorMinimo);
        return retorno;
    }
    /*
    
    ACA SE OBTIENEN LOS VALORES RECOMENDADOS A PARTIR DE LA LONGITUD DEL PERIODO
    
    */
    public int obtenerModuloRecomendado(int longitudPeriodo){
        int k=0;
        boolean bandera = false;
        while(!bandera){
            if((int)Math.pow(2, k) > longitudPeriodo){
                bandera = true;
            }
            k++;
        }
        return (int)Math.pow(2, k-1);
    }
    
    public int obtenerIncrementoRecomendado(int modulo){
        return 0;                               //  QUE ELIAS REVISE ESTO, EL ENTENDIO COMO BUSCAR COPRIMOS Y TODO ESO...
    }
    
    public int obtenerMultiplicadorRecomendao(int modulo){// uso la formula   ((upper-lower+1)*RND+lower)= un entero
        int retorno = modulo-1;
        boolean bandera = false;
        while(!bandera){
            retorno =4*this.obtenerEnteroEntreDosNumeros(10, 0)+1;
            if(retorno > 4 && 4*this.obtenerEnteroEntreDosNumeros(10, 0)+1<modulo){
                bandera = true;
            }
        }
        return retorno;
    }
    
    public int obtenerSemillaRecomendada(int modulo){
        return this.obtenerEnteroEntreDosNumeros(modulo, 1);
    }
    
    /*
    
    
    
    */
    
    public List<Double> cargarListaNumerosGenerados(int modulo, int incremento, int multiplicador, double semilla, int longitudPeriodo){
        
        for (int i = 0; i < modulo/*longitudPeriodo*/; i++) {//ITERAR HASTA EL MODULO O LONGITUDPERIODO?
            semilla = this.generadorCongruencialLineal(modulo, incremento, multiplicador, semilla);
            this.numeroGeneradosPorUsuario.add(semilla);
        }
        this.cargarNumerosGeneradosPorUsuarioEstandarizado(modulo);

        return this.numeroGeneradosPorUsuario;
    }
    
    public List<Double> dameSecuenciaCantidadJugadores(){
        return this.secuenciaCantidadJugadores;
    }
    
    public void generarSecuenciaCantidadJugadores(){
        
    }
    
    public void cargarNumerosGeneradosPorUsuarioEstandarizado(int modulo){///quitar modulo tratar de llevarlo de otra forma.. estoy cansado--este metodo es para cargar la secuencia estandarizada a partir de la secuencia sin estandarizar. esta secuencia corresponde a bolliero
        
        Double unElemento;
        double valorEstandarizado;
        Iterator<Double> iteradorSecuencia = this.numeroGeneradosPorUsuario.iterator();
       while(iteradorSecuencia.hasNext()){
           unElemento = iteradorSecuencia.next();
           valorEstandarizado = this.estandarizar(unElemento, modulo);
           this.numeroGeneradosPorUsuarioEstandarizados.add(valorEstandarizado);
       }
    }
    
    public List<Double> getNumerosGeneradosPorUsuario(){
        return this.numeroGeneradosPorUsuario;
    }
 
    public List<Double> getNumerosGeneradosPorUsuarioEstandarizados(){
        return this.numeroGeneradosPorUsuarioEstandarizados;
    }
    
    public void generarApuestasJugador(){
        double[] vectorAux = new double[this.jugadores.size()];
        int i=0;
        for(Double aux : this.numeroGeneradosPorUsuarioEstandarizados){
            if(i<this.jugadores.size()){
                vectorAux[i]=(double)aux.doubleValue();
            }
            i++;
        }
        for(i=0;i<vectorAux.length;i++){
            System.out.println("valor del vector en posicion " + String.valueOf(i) + " es "+ String.valueOf(vectorAux[i]) );
        }
        for(Jugador aux : this.jugadores){
            double semilla = this.obtenerSemillaRecomendada((int)modulo);
            for(int j=0;j<5;j++){                                                                                                                                                                                                                                                               //CAMBIAR EL 5 POR 20.000 PARA MAS NUMEROS EN LA LISTA DE CADA JUGADOR
               //MODULO REEMPLAZADO POR 2^11 = 2048
              // int modulo = 2048;
                //aux.setUnaApuestaJugador(this.generadorCongruencialLineal(modulo, this.obtenerIncrementoRecomendado(modulo), this.obtenerMultiplicadorRecomendao(modulo), semilla));
                aux.setUnaApuestaJugador(this.generadorCongruencialLineal((int)modulo, (int)incremento, (int)multiplicador, semilla));
                semilla=this.generadorCongruencialLineal((int)modulo, (int)incremento, (int)multiplicador, semilla);
            }
            aux.estandarizarListaApuestas((int)modulo);
        }
        int k= 0;
        while( k <3){
            Jugador aux = this.jugadores.get(k);
            System.out.println("Id jugador: "+String.valueOf(aux.getId()));
            System.out.println("Saldo disponible "+ aux.getSaldoDisponible());
            System.out.println("apuesta sin estandarizar "+aux.getApuestasJugador().get(k));
            System.out.println("apuesta estandarizada "+aux.getApuestasJugadorEstandarizado().get(k));
            System.out.println("donde apostar "+aux.elegirDondeApostar());
            System.out.println("monto a apostar "+aux.elegirMontoApuesta());
            System.out.println("valor a  apostar "+aux.elegirValorApuesta(k));
            k++;
        }
        
//        for(Jugador aux : this.jugadores){
//            System.out.println("Id jugador: "+String.valueOf(aux.getId()));
//            for(Double unD:aux.getApuestasJugador()){
//                System.out.println(unD.doubleValue());
//            }
//            for(Double unD:aux.getApuestasJugadorEstandarizado()){
//                System.out.println(unD.doubleValue());
//            }
//        }
    }
    public static void main(String[] args) {
        VentanaPrincipal juego = new VentanaPrincipal();
        juego.show();
    }
    
}
