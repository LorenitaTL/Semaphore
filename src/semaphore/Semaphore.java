/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaphore;

/**
 *
 * @author lo_re
 */
public class Semaphore {
    private int recursos;//recursos disponibles
    Semaphore(int recursos){
        this.recursos = recursos;
    }
    
    //Método que indica cuando se pueden utilizar los recursos o si el usuario debe esperar
    public synchronized void acquire() throws InterruptedException{
        if(recursos>0){//Si el número de recursos es >0
            recursos--;//Entonces disminuye el número de recursos
            System.out.println("\nPuedes utilizar los recursos");
            }else{
                    System.out.println("\nEspera a que haya recursos disponibles");
                    wait();//Si no, el usurio debe esperar a que se notifique que se han liberado los recursos
                    System.out.println("\nAhora puedes utilizar los recursos");
                    recursos--;//Después de la espera, el usuario toma los recursos necesarios,
                               //por lo tanto estos vuelven a disminuir
                    }
    }
    
    public synchronized void release(){
        recursos++;//Cuando un usuario termina el proceso que está realizando, se liberan recursos 
                   //para que estén disponibles para otro usuario
        if (recursos>0) {
            notify();//Si los recursos son >0 notifica al usuario que está esperando para que tome
                     //los recursos necesarios
        }
    }
    
    
    
}

