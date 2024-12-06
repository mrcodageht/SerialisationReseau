package com.mrcodage;

import com.mrcodage.model.Article;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.OffsetDateTime;

public class ClientTCP {
    public static void main(String[] args) {
        try {
            var serveur = InetAddress.getByName("localhost");
            var socket = new Socket(serveur,serverTCP.PORT);
            sendRequest(socket);
            readServerResponse(socket);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void readServerResponse(Socket socket) throws IOException, ClassNotFoundException {
        var in = new ObjectInputStream(socket.getInputStream());
        Article article =(Article) in.readObject();
        System.out.printf("Lecture de l'article du serveur : %s",article);
    }

    private static void sendRequest(Socket socket) throws IOException {
        var out = new ObjectOutputStream(socket.getOutputStream());
        System.out.println("Envoie d'un article en cours");
        var articleOut = new Article("Article client","Client","Viens du client", OffsetDateTime.now());
        out.writeObject(articleOut);
        System.out.println("Envoie termine");
    }


}
