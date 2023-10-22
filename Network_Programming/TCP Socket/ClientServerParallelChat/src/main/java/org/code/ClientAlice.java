package org.code;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientAlice {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 12345);

            // reading data from keyboard
            DataInputStream keyInp = new DataInputStream(System.in);
            // reading data from ServerSocket
            DataInputStream dis = new DataInputStream(s.getInputStream());
            // sending data to server
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            String data;

            while(true){
                System.out.println("Enter your message to Bob: ");
                data = keyInp.readLine();
                dos.writeUTF(data);
                data= dis.readUTF();
                System.out.println("Bob: " + data);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
