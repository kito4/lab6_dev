package com.kito.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public final class Client {
    private Client() {
        throw new UnsupportedOperationException("This is an utility class and can not be instantiated");
    }

    public static void main(String[] args) {
        try {
            Socket sock= new Socket("localhost",4234);
            OutputStream os = sock.getOutputStream();
            DataOutputStream out=new DataOutputStream(os);
            DataInputStream is = new DataInputStream(sock.getInputStream());
            Scanner scanner = new Scanner(System.in);
            System.out.println(is.readUTF());
            while(true) {

                out.writeUTF(scanner.nextLine());
                System.out.println(is.readUTF());
                // TODO: условие exit
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
