package com.javarush.test.level30.lesson15.big01;

import java.net.Socket;

/**
 * Created by sergey on 28.12.15.
 */
public class Server {
    private static class Handler extends Thread {
        private Socket socket;

        Handler(Socket socket) {
            this.socket = socket;
        }
    }


    public static void main(String[] args) {

    }
}
