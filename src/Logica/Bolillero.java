/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author albor
 */
public class Bolillero {
    private int id;
    private int numero;
    private int color; //0=salió el 0 en la ruleta ; 1=negro; 2=rojo; cualquier otro valor quiere decir que no aposto a ningun color
    /*
    
    */

    public Bolillero(int id, int numero, int color) {
        this.id = id;
        this.numero = numero;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
    
    
    
}
