package org.code;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServerBob {
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket(125);

            //receiving
            byte[] b1 = new byte[1024];
            DatagramPacket dp = new DatagramPacket(b1,b1.length);
            ds.receive(dp);
            String str = new String(dp.getData());
            int num = Integer.parseInt(str.trim());
            int result = num * num;
            System.out.println(num);
            System.out.println(result);

            //sending
            byte[] b2= String.valueOf(result).getBytes();
            InetAddress localHost = InetAddress.getLocalHost();
            DatagramPacket dp2 = new DatagramPacket(b2,b2.length,localHost,125);
            ds.send(dp2);

            ds.close();

        } catch (Exception e) {
            System.out.println(e);
        }



    }
}
