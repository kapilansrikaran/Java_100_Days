package org.code;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerChat {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(12345);
            Socket s = ss.accept();

            DataInputStream dis = new DataInputStream(s.getInputStream());
            String msg = (String)dis.readUTF();
            System.out.println(msg);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
