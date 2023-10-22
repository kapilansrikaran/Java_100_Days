package org.code;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientChat {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost",12345);

            // Method 1: Using Scanner Class
            /*
            Scanner scan = new Scanner(System.in);
            String msg = scan.next();
            **/

            // Method 2: Using DataInputStream Class
            DataInputStream kis = new DataInputStream(System.in);
            System.out.println("Enter your message to server: ");
            String str = kis.readLine();

            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            dos.writeUTF(str); // msg for Scanner class || str for DataInputStream

            s.close();
            dos.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
