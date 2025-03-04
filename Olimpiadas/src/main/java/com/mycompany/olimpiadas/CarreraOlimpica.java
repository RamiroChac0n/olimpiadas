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
        Semaphore semaforo = new Semaphore(0);

        Corredor c1 = new Corredor(semaforo, "Atleta 1");
        Corredor c2 = new Corredor(semaforo, "Atleta 2");
        Corredor c3 = new Corredor(semaforo, "Atleta 3");

        c1.start();
        c2.start();
        c3.start();

        Thread.sleep(3000);
        System.out.println("🔥 ¡Pistoletazo de salida! 🔥");
        semaforo.release(3);
    }
}
