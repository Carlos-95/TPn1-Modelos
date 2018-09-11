/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;
import Logica.Controladora;
import Logica.Jugador;
import java.util.List;
/**
 *
 * @author albor
 */
public class ControladoraVisual {
    Controladora unaLogica = new Controladora();
    
    
    public int obtenerEnteroEntreDosNumeros(int max, int min){
        return this.unaLogica.obtenerEnteroEntreDosNumeros(max, min);
    }
    
    public int obtenerDineroParaJugador(int max, int valorMinimo){
        return this.unaLogica.obtenerDineroParaJugador(max, valorMinimo);
    }
    
    public List<Jugador> dameTodosLosJugadores(){
        
        return this.unaLogica.dameTodosLosJugadores();
    }
    
    public int obtenerModuloRecomendado(int longitudPeriodo){
        return this.unaLogica.obtenerModuloRecomendado(longitudPeriodo);
    }
    
    public int obtenerIncrementoRecomendado(int modulo){
        return this.unaLogica.obtenerIncrementoRecomendado(modulo);                       //  QUE ELIAS REVISE ESTO, EL ENTENDIO COMO BUSCAR COPRIMOS Y TODO ESO...
    }
    
    public int obtenerMultiplicadorRecomendao(int modulo){// uso la formula   ((upper-lower+1)*RND+lower)= un entero
        return this.unaLogica.obtenerMultiplicadorRecomendao(modulo);
    }
    
    public int obtenerSemillaRecomendada(int modulo){
        return this.unaLogica.obtenerSemillaRecomendada(modulo);
    }
    
    public List<Double> cargarListaNumerosGenerados(int modulo, int incremento, int multiplicador, double semilla, int longitudPeriodo){
        return this.unaLogica.cargarListaNumerosGenerados(modulo, incremento, multiplicador, semilla, longitudPeriodo);
    }
    
        public List<Double> getNumerosGeneradosPorUsuario(){
        return this.unaLogica.getNumerosGeneradosPorUsuario();
    }
 
    public List<Double> getNumerosGeneradosPorUsuarioEstandarizados(){
        return this.getNumerosGeneradosPorUsuarioEstandarizados();
    }
    
    public List<Jugador> crearJugadoresRonda(int cantJugadores){
        return this.unaLogica.crearJugadoresRonda(cantJugadores);
    }
    
    public void generarApuestasJugador(){
        this.unaLogica.generarApuestasJugador();
    }
}
