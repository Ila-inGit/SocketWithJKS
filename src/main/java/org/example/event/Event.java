package org.example.event;

import org.example.VisitorClient;
import org.example.VisitorServer;
import org.example.obj.ObjInNetwork;

public abstract class Event extends ObjInNetwork {
    public abstract void accept(VisitorServer visitor);
    public abstract void accept(VisitorClient visitorClient);
}
