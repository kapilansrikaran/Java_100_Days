package org.code;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerBob {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(12345);
            Socket s = ss.accept();

            //reading data from client
            DataInputStream dis = new DataInputStream(s.getInputStream());
            //reading data from keyboard
            DataInputStream keyInp = new DataInputStream(System.in);
            //sending data to client
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            String data;

            while(true){
                data = dis.readUTF();
                System.out.println("Alice: "+ data);
                if(data.equalsIgnoreCase("bye")){
                    s.close();
                    break;
                }
                System.out.println("Me: ");
                data = keyInp.readLine();
                dos.writeUTF(data);
                dos.flush();

                if(data.equalsIgnoreCase("bye")){
                    s.close();
                    break;
                }

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
