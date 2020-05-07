package org.example.event;


import org.example.VisitorClient;
import org.example.VisitorServer;

public class EventMoveWorker extends Event {

    private int riga;
    private int colonna;

    public EventMoveWorker(int riga, int colonna) {
        this.riga = riga;
        this.colonna = colonna;
    }

    public int getRiga() {
        return riga;
    }

    public void setRiga(int riga) {
        this.riga = riga;
    }

    public int getColonna() {
        return colonna;
    }

    public void setColonna(int colonna) {
        this.colonna = colonna;
    }

    @Override
    public void accept(VisitorServer visitor) {
        visitor.visit(this);
    }

    @Override
    public void accept(VisitorClient visitorClient) {
        visitorClient.visit(this);
    }
}
