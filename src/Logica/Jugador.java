/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author albor
 */
public class Jugador {
    private int id;
    private int saldoDisponible;
    private List<Double> apuestasJugador = new LinkedList();
    private List<Double> apuestasJugadorEstandarizado = new LinkedList();
    private int indice =0;//indice para recorrer la lista 
    
    /*
    
    */

    public Jugador(int id, int saldoDisponible) {
        this.id = id;
        this.saldoDisponible = saldoDisponible;
        apuestasJugador = new LinkedList();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(int saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    public List<Double> getApuestasJugador() {
        return apuestasJugador;
    }

    public void setApuestasJugador(List<Double> apuestasJugador) {
        this.apuestasJugador = apuestasJugador;
    }
    public void setUnaApuestaJugador(Double apuestaJugador) {
        this.apuestasJugador.add(apuestaJugador);
    }

    public List<Double> getApuestasJugadorEstandarizado() {
        return apuestasJugadorEstandarizado;
    }

    public void setApuestasJugadorEstandarizado(List<Double> apuestasJugadorEstandarizado) {
        this.apuestasJugadorEstandarizado = apuestasJugadorEstandarizado;
    }
    
    
    
    public int elegirDondeApostar(){//para que determine si se quiere apostar a los numeros, color o paridad
        int dondeApostar= (int)((3-1)*this.apuestasJugadorEstandarizado.get(indice)+1);
        return dondeApostar;
    }
    
    public int elegirMontoApuesta(){//para determinar cuanto dinero apostar
        int montoApuesta =(int) ((this.saldoDisponible-1)*this.apuestasJugadorEstandarizado.get(indice)+1);
        return montoApuesta;
    }
       
    public String elegirValorApuesta(int dondeApostar){//para determinar a que numero, o a que color o a que paridad apostar
      
       int numero, paridad, color;
       String retorno;
        switch(dondeApostar){
            case 1:
                numero = (int)((36-1)*this.apuestasJugadorEstandarizado.get(indice)+1);
                retorno = String.valueOf(numero);
                return retorno;
            case 2:
                paridad = (int)((1-0)*this.apuestasJugadorEstandarizado.get(indice)+0);//par=0 impar =1
                if(paridad==1){
                    retorno = "Impar";
                }else{
                    retorno = "Par";
                }
                return retorno;
            case 3:
                color = (int)((1-0)*this.apuestasJugadorEstandarizado.get(indice)+0);//negro=0, rojo =1
                if(color==1){
                    retorno = "Rojo";
                }else{
                    retorno = "Negro";
                }
                return retorno;
        }
        return "1";
    }
    
    public void estandarizarListaApuestas(int modulo){
        for(Double unD:this.apuestasJugador){
            this.apuestasJugadorEstandarizado.add(unD.doubleValue()/modulo);
        }
    }
    
    @Override
    public String toString(){
        return String.valueOf(this.getSaldoDisponible());
    }
}
