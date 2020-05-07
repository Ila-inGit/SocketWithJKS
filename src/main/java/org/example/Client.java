package org.example;
import java.io.*;
import java.net.*;

// Client class
public class Client {

    public static void main(String[] args) throws IOException
    {
// getting localhost ip
        InetAddress ip = InetAddress.getByName("localhost");

// establish the connection with server port 5056
        Socket s = new Socket(ip, 5056);

// obtaining input and out streams
        ObjectOutputStream oos= new ObjectOutputStream(s.getOutputStream());
        ObjectInputStream ois= new ObjectInputStream(s.getInputStream());


        ClientMessageHandler clientMessageHandler = new ClientMessageHandler(oos,ois,s,new ViewClient());
        clientMessageHandler.running();
    }
}
