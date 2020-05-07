package org.example;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

// Java implementation of Server side
// It contains two classes : Server and ClientHandler
// Save file as Server.java

import java.io.*;
import java.net.*;

// Server class
public class Server
{
    public static void main(String[] args) throws IOException
    {
        // server is listening on port 5056
        ServerSocket ss = new ServerSocket(5056);

        // running infinite loop for getting
        // client request
        while (true)
        {
            Socket s = null;

            try
            {
                // socket object to receive incoming client requests
                s = ss.accept();

                System.out.println("A new client is connected : " + s);

                // obtaining input and out streams
                ObjectOutputStream oos= new ObjectOutputStream(s.getOutputStream());
                ObjectInputStream ois= new ObjectInputStream(s.getInputStream());


                System.out.println("Assigning new thread for this client");

                // create a new thread object

                Thread t= new ClientHandler(s, ois, oos);

                // Invoking the start() method
                t.start();

            }
            catch (Exception e){
                s.close();
                e.printStackTrace();
            }
        }
    }
}

