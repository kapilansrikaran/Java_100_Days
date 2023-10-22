package org.code;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientAlice {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 12345);

            //reading data from keyboard
            DataInputStream keyInp = new DataInputStream(System.in);
            //sending data to ServerSocket
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            //reading data from the ServerSocket
            DataInputStream dis = new DataInputStream(s.getInputStream());

            String data;

            while(true){
                System.out.println("Me: ");
                data = keyInp.readLine();
                dos.writeUTF(data);
                dos.flush();

                if(data.equalsIgnoreCase("bye")){
                    s.close();
                    break;
                }

                data = dis.readUTF();
                System.out.println("Bob: "+data);
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
