/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.olimpiadas;

/**
 *
 * @author ramir
 */
import java.util.concurrent.Semaphore;

class Corredor extends Thread {
    private Semaphore semaforo;
    private String nombre;

    public Corredor(Semaphore semaforo, String nombre) {
        this.semaforo = semaforo;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {
            System.out.println(nombre + " está en la línea de salida...");
            semaforo.acquire();
            System.out.println(nombre + " ¡Empieza a correr!");
            
            int tiempo = (int) (Math.random() * 5000 + 2000);
            Thread.sleep(tiempo);

            System.out.println("🏆 " + nombre + " ha cruzado la meta en " + tiempo / 1000.0 + " segundos.");
            semaforo.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
