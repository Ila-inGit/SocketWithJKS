package org.example.obj;

import org.example.VisitorClient;
import org.example.VisitorServer;

public class ObjCard extends ObjInNetwork {

    private String godName;
    private boolean scelta;


    public ObjCard(String godName, boolean scelta) {
        this.godName = godName;
        this.scelta = scelta;
    }

    public String getGodName() {
        return godName;
    }

    public void setGodName(String godName) {
        this.godName = godName;
    }

    public boolean isScelta() {
        return scelta;
    }

    public void setScelta(boolean scelta) {
        this.scelta = scelta;
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
