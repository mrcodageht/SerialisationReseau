package com.mrcodage;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class MyHttpServer {
    public static void main(String[] args) throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(8000),0);
        httpServer.createContext("/article", new articleHandler());
        httpServer.setExecutor(null);
        /*
        * Demarrer le serveur pour attendre les resquetes des clients
        * */
        httpServer.start();

        System.out.println("Le serveur est demare ! ");
    }

    static class articleHandler implements HttpHandler{

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            /*
            * Recuperation de l'article recu dans la requete du client
            * */
            var body = new String(exchange.getRequestBody().readAllBytes());
//            Conversion de cet article en format JSON en objet java
            var article = ArticleJsonMapper.toArticle(body);
            System.out.println("Article venant du client : "+article);

            /*
            * Envoie d'une reponse au client qui peut etre autre chose, mais dans notre cas on envoie un article
            * */
            var articleServeur = new Article("Serveur","Artcile du serveur","Un article venant du serveur");
            var articleSeveurJson = ArticleJsonMapper.toJson(articleServeur);

            byte[] articleServeurBytes = articleSeveurJson.getBytes();
            exchange.sendResponseHeaders(200,articleServeurBytes.length);

            /*
            * Recuperation du flux de sortie de la response pour pourvoir ecrire et envoyer une response au client
            * */
            var out = exchange.getResponseBody();
            out.write(articleServeurBytes);
            System.out.println("Envoie d'un article au client");

        }
    }
}
