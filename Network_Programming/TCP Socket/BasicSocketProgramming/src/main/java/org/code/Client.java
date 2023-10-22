package org.code;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {

            Socket s = new Socket("localhost",12345);

            // why?
            DataOutputStream oos = new DataOutputStream(s.getOutputStream());
            oos.writeUTF("my message");

            // why?
            ObjectOutputStream oos2 = new ObjectOutputStream(s.getOutputStream());
            oos.writeUTF("2nd my message");

            oos.close();
            s.close();
            oos2.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
