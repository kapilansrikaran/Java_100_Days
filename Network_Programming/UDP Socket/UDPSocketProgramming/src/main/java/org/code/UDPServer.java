package org.code;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {
    public static void main(String[] args) {
        try {
            // create DatagramSocket and add port number was in the client
            DatagramSocket ds = new DatagramSocket(12345);

            byte[] barr = new byte[1024];

            DatagramPacket dp = new DatagramPacket(barr,barr.length);

            ds.receive(dp);

            String str= new String(dp.getData());
            int num = Integer.parseInt(str.trim());
            System.out.println(num);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
