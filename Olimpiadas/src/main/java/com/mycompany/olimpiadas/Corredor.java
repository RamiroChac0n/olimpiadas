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
    private static Ventana ventana;

    public Corredor(Semaphore semaforo, String nombre, Ventana ventana) {
        this.semaforo = semaforo;
        this.nombre = nombre;
        this.ventana = ventana;
    }

    @Override
    public void run() {
        try {
            
            semaforo.acquire();
            
            switch (nombre) {
                case "Corredor A":
                    ventana.corredorA.setLocation(0, 0);
                    for (int i = 0; i < 400; i++) {
                        ventana.corredorA.setLocation(i, 0);
                        int tiempo = (int) (Math.random()+100);
                        Thread.sleep(tiempo);                
                    }
                    break;
                case "Corredor B":
                    ventana.corredorB.setLocation(0, 20);
                    for (int i = 0; i < 400; i++) {
                        ventana.corredorB.setLocation(i, 20);
                        int tiempo = (int) (Math.random()+100);
                        Thread.sleep(tiempo);                
                    }                    
                    break;   
                case "Corredor C":
                    ventana.corredorC.setLocation(0, 40);
                    for (int i = 0; i < 400; i++) {
                        ventana.corredorC.setLocation(i, 40);
                        int tiempo = (int) (Math.random()+100);
                        Thread.sleep(tiempo);                
                    }                    
                    break;  
                case "Corredor D":
                    ventana.corredorD.setLocation(0, 60);
                    for (int i = 0; i < 400; i++) {
                        ventana.corredorD.setLocation(i, 60);
                        int tiempo = (int) (Math.random()+100);
                        Thread.sleep(tiempo);                
                    }                    
                    break;                    
                default:
                    throw new AssertionError();
            }
            
            System.out.println(nombre);
            
            semaforo.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
