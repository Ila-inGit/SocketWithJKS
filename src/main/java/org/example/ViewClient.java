package org.example;

import org.example.event.EventMoveWorker;
import org.example.obj.ObjCard;
import org.example.obj.ObjPerson;

public class ViewClient {
    public void printCard(ObjCard card){
        System.out.println("sono la view del client e sto stampando la carta "+card);
    }
    public void printPerson(ObjPerson person){
        System.out.println("sono la view del client e sto stampando la persona "+person);
    }
    public void printWorker(EventMoveWorker eventMoveWorker){
        System.out.println("sono la view del client e sto stampando la nuova pos del worker "+ eventMoveWorker.getRiga() + " " + eventMoveWorker.getColonna());
    }
}
