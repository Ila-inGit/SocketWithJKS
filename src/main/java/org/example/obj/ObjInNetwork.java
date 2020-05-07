package org.example.obj;


import org.example.VisitorClient;
import org.example.VisitorServer;

import java.io.Serializable;


public abstract class ObjInNetwork implements Serializable {
    public abstract void accept(VisitorServer visitor);
    public abstract void accept(VisitorClient visitorClient);
}

