package org.code;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPClientAlice {
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket();

            //sending
            int num = 5;
            byte[] barr = String.valueOf(num).getBytes();
            InetAddress localHost = InetAddress.getLocalHost();
            DatagramPacket dp = new DatagramPacket(barr,barr.length,localHost,125);
            ds.send(dp);


            //receiving
            byte[] barr2 = new byte[1024];
            DatagramPacket dp2 = new DatagramPacket(barr2,barr2.length);
            ds.receive(dp2);

            String str = new String(dp2.getData(),0, dp2.getLength());
            int num2 = Integer.parseInt(str.trim());
            System.out.println(num2);

            ds.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
