package org.example;

import org.example.event.Event;
import org.example.event.EventMoveWorker;
import org.example.obj.ObjCard;
import org.example.obj.ObjPerson;

public class VirtualView {
    private Controller controller;
    private ClientHandler clientHandler;

    public VirtualView(Controller controller, ClientHandler clientHandler) {
        this.clientHandler=clientHandler;
        this.controller = controller;
    }

    public void setPerson(ObjPerson person){
        System.out.println("io come virtual view riesco a leggere l'oggetto "+ person);
        controller.setPerson();
        updatePerson();
    }
    public void setCard(ObjCard card){
        System.out.println("io come virtual view riesco a leggere l'oggetto "+ card);
        controller.setCard();
        updateCard();
        //eventuali azioni aggiuntive
    }
    public void moveWorker(EventMoveWorker eventMoveWorker){
        System.out.println("io come virtual view riesco a leggere l'evento "+ eventMoveWorker);
        controller.moveWorker(eventMoveWorker);
        clientHandler.sendUpdate(new EventMoveWorker(4,5));
        //eventuali azioni aggiuntive
    }
    public void updateCard(){
        System.out.println("io virtual view richiedo al model di passarmi l'update della carta");
        //get carte
        clientHandler.sendUpdate(new ObjCard("apollo",true));
    }
    public void updatePerson(){
        System.out.println("io virtual view richiedo al model di passarmi l'update della persona");
        //get carte
        clientHandler.sendUpdate(new ObjPerson("Paolo",54));
    }
}
