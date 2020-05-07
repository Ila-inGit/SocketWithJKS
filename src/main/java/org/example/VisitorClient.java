package org.example;

import org.example.event.EventMoveWorker;
import org.example.obj.ObjCard;
import org.example.obj.ObjPerson;

public class VisitorClient {
    ClientMessageHandler clientMessageHandler;

    public VisitorClient(ClientMessageHandler clientMessageHandler) {
        this.clientMessageHandler = clientMessageHandler;
    }
    public void visit(ObjPerson person) {
        System.out.println("io sono il visitor client e sto stampando la persona e dovrei richiamare la view"+ person);
        clientMessageHandler.getViewClient().printPerson(person);
    }

    public void visit(ObjCard card) {
        System.out.println("io sono il visitor client e sto stampando la carta e dovrei richiamare la view"+ card);
        clientMessageHandler.getViewClient().printCard(card);
    }

    public void visit(EventMoveWorker moveWorker){
        System.out.println("io sono il visitor client e sto stampando la moveworker e dovrei richiamare la view"+ moveWorker);
        clientMessageHandler.getViewClient().printWorker(moveWorker);
    }
}
