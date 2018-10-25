/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaphore;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lo_re
 */
public class Users implements Runnable{
    Semaphore sem;//Objeto de la clase semaforo, para utilizar métodos que 
                  //validan los recursos disponibles
    Users(Semaphore sem){
        this.sem=sem;
    }

    @Override
    public void run() {
        try {
            System.out.println("\nUsusario solicita recursos \n============================");
            sem.acquire();//Validar si hay recursos disponibles para los usuarios
            Thread.sleep((Math.round(Math.random()*5000)));//El usuario deberá utilizar los recursos 
                                                           //por un máximo de 5 segundos
            sem.release();//El usuario termina su ejecución y manda a llamar el método release para 
                          //indicar que se han liberado los recursos
        } catch (InterruptedException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        int recursos;
        int usuarios;
        
        Scanner e = new Scanner(System.in);
        System.out.println("Ingresa los recursos disponibles");
        recursos=e.nextInt();//Se recibe la cantidad de recursos disponibles
        System.out.println("Ingresa los usuarios que desean utilizar los recursos");
        usuarios=e.nextInt();//Se recibe la cantidad de usuarios que deean utilizar los recursos
        
        Semaphore sem = new Semaphore(recursos);//El objeto de la clase Semaphore recibe los recursos que habrá disponibles
        
        for(int i=0;i<usuarios;i++){//Ciclo que inicia la ejecución de usuarios que desean utilizar los recursos
            new Thread(new Users(sem)).start();//Inicio de cada usuario (hilo) que utilizará los recursos
            
        }
        
        
    }
    
}