package org.code;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        try {

            ServerSocket ss = new ServerSocket(12345);
            Socket s = ss.accept();


            DataInputStream ois  = new DataInputStream(s.getInputStream());
            String msg = (String)ois.readUTF();
            System.out.println(msg);

            ObjectInputStream ois2  = new ObjectInputStream(s.getInputStream());
            String msg2 = (String)ois.readUTF();
            System.out.println(msg2);


            ois.close();
            ss.close();
            ois2.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
