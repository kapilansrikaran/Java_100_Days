package org.code;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPClient {
    public static void main(String[] args) {
        try {
            //create DatagramSocket
            DatagramSocket ds = new DatagramSocket();

            int i=10;

            // 'i' is the data that want to send
            // before send convert in to packet means byte array
            // first convert 'i' to String then do byte array
            byte[] b = String.valueOf(i).getBytes();

            InetAddress myPcAddress = InetAddress.getLocalHost();
            DatagramPacket dp = new DatagramPacket(b,b.length,myPcAddress,12345); // 4 arguments

            // send to server
            ds.send(dp);


        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
