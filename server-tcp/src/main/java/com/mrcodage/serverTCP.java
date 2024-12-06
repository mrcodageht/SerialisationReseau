package com.mrcodage;

import com.mrcodage.model.Article;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.OffsetDateTime;

public class serverTCP {
    public static int PORT = 9630;
    public static void main(String[] args) throws IOException {
        try(ServerSocket serverSocket = new ServerSocket(PORT)){
            System.out.println("Lancement du serveur");

            while(true){
                Socket socketClient = serverSocket.accept();

                Runnable socketThread = ()->{
                    try {
                        processThread(socketClient);
                    }catch (IOException | ClassNotFoundException e){
                        e.printStackTrace();
                    }
                };
                socketThread.run();
            }
        }
    }

    private static void processThread(Socket socketClient) throws IOException, ClassNotFoundException {
        System.out.printf("Connexion avec : %s\n",socketClient.getInetAddress());
        readClientInput(socketClient);
        sendRespose(socketClient);
    }

    private static void sendRespose(Socket socketClient) throws IOException {
        var out = new ObjectOutputStream(socketClient.getOutputStream());
        var articleOut = new Article("Article server","Serveur","Viens du serveur", OffsetDateTime.now());
        out.writeObject(articleOut);
    }

    private static void readClientInput(Socket socketClient) throws IOException, ClassNotFoundException {
        var in = new ObjectInputStream(socketClient.getInputStream());
        Article article =(Article) in.readObject();
        System.out.printf("Lecture de l'article du client : %s\n",article);
    }
}
