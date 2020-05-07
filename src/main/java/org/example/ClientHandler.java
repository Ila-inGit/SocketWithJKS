package org.example;

import org.example.obj.ObjInNetwork;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

// ClientHandler class
class ClientHandler extends Thread
{
    final ObjectOutputStream oos;
    final ObjectInputStream ois;
    final Socket s;
    final VirtualView virtualView;


    // Constructor
    public ClientHandler(Socket s, ObjectInputStream ois, ObjectOutputStream oos)
    {
        this.s = s;

        this.oos=oos;
        this.ois=ois;
        virtualView=new VirtualView(new Controller(), this);
    }

    public VirtualView getVirtualView() {
        return virtualView;
    }

    @Override
    public void run() {

        while (true){

// Ask user what he wants
            try {
                oos.writeObject("What do you want?[Date | Time]..Type Exit to terminate connection.");
            } catch (IOException e) {
                e.printStackTrace();
            }

// receive the answer from client
            ObjInNetwork message= null;
            try {
                message = (ObjInNetwork) ois.readObject();
                message.accept(new VisitorServer(this));

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    //metodo per mandare un oggetto aggiornato in seguito di una modifica al model(notifyObserver)
    public void sendUpdate(ObjInNetwork objInNetwork){
        try {
            oos.writeObject(objInNetwork);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

