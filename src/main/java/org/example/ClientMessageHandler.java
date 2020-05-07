package org.example;

import org.example.event.Event;
import org.example.event.EventMoveWorker;
import org.example.obj.ObjCard;
import org.example.obj.ObjInNetwork;
import org.example.obj.ObjPerson;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientMessageHandler {
    final ObjectOutputStream oos;
    final ObjectInputStream ois;
    final Socket s;
    final ViewClient viewClient;

    public ClientMessageHandler(ObjectOutputStream oos, ObjectInputStream ois, Socket s, ViewClient viewClient) {
        this.oos = oos;
        this.ois = ois;
        this.s = s;
        this.viewClient=viewClient;
    }

    public ViewClient getViewClient() {
        return viewClient;
    }

    public void running(){
// the following loop performs the exchange of
// information between client and client handler
        while (true) {

            String recived= null;
            try {
                recived = (String)ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println(recived);

            Scanner scanner=new Scanner(System.in);
            String tosend = scanner.nextLine();

            switch (tosend) {
                case "Date":
                    ObjInNetwork personToSend = new ObjPerson(tosend, 34);
                    try {
                        oos.writeObject(personToSend);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "Time":
                    ObjInNetwork cardToSend = new ObjCard(tosend, true);
                    try {
                        oos.writeObject(cardToSend);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "moveworker":
                    Event eventMoveWorkerToSend = new EventMoveWorker(2, 3);
                    try {
                        oos.writeObject(eventMoveWorkerToSend);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
            }

// If client sends exit,close this connection
// and then break from the while loop
            if(tosend.equals("Exit"))
            {
                System.out.println("Closing this connection : " + s);
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Connection closed");
                break;
            }else{
                ObjInNetwork objReceived= null;
                try {
                    objReceived = (ObjInNetwork)ois.readObject();
                    objReceived.accept(new VisitorClient(this));


                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        }

        try {
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
