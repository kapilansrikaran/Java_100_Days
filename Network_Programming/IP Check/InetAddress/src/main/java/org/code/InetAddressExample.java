package org.code;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressExample {
    public static void main(String[] args) {
        try {
            InetAddress ina = InetAddress.getByName("www.ruh.ac.lk"); //omit the URL protocol and path
            System.out.println("InetAddress: " + ina);
            System.out.println("Host Name: " + ina.getHostName());
            System.out.println("Ip Address: " + ina.getHostAddress());

            InetAddress myina = InetAddress.getLocalHost();
            System.out.println("InetAddress: " + myina);
            System.out.println("Host Name: " + myina.getHostName());
            System.out.println("Ip Address: " + myina.getHostAddress());

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

    }
}
