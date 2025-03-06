/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.olimpiadas;

import java.util.concurrent.Semaphore;

/**
 *
 * @author ramir
 */
public class CarreraOlimpica {
    public static void main(String[] args) throws InterruptedException {
        
        Ventana ventana = new Ventana();
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        
        Semaphore semaforo = new Semaphore(0);

        Corredor c1 = new Corredor(semaforo, "Corredor A", ventana);
        Corredor c2 = new Corredor(semaforo, "Corredor B", ventana);
        Corredor c3 = new Corredor(semaforo, "Corredor C", ventana);
        Corredor c4 = new Corredor(semaforo, "Corredor D", ventana);

        c1.start();
        c2.start();
        c3.start();
        c4.start();

        Thread.sleep(3000);
        System.out.println("¡¡¡ CORRAN !!!");
        System.out.println("Orden de llegada: ");
        semaforo.release(4);        
    }
}
