package org.example;


import org.example.event.EventMoveWorker;
import org.example.obj.ObjCard;
import org.example.obj.ObjPerson;

public class VisitorServer {
    ClientHandler clientHandler;

    public VisitorServer(ClientHandler clientHandler) {
        this.clientHandler = clientHandler;
    }

    public void visit(ObjPerson person) {
        clientHandler.getVirtualView().setPerson(person);
    }

    public void visit(ObjCard card) {
        clientHandler.getVirtualView().setCard(card);
    }

    public void visit(EventMoveWorker moveWorker){
        clientHandler.getVirtualView().moveWorker(moveWorker);
    }


}