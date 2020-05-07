package org.example;

import org.example.event.EventMoveWorker;

public class Controller {

    public void moveWorker(EventMoveWorker moveWorker){
        System.out.println("io sono il controller e sto facendo la moveworker");
        System.out.println("riga: "+ moveWorker.getRiga()+ " colonna: " + moveWorker.getColonna());
        //notify sul model che mi farà l'update
    }
    public void setPerson(){
        System.out.println("io sono il controller e sto settando la persona");
        //notify
    }
    public void setCard(){
        System.out.println("io sono il controller e sto settando la carta");
        //notify
    }

}
