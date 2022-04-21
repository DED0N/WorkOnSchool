package server;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpContext;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;


public class Server {

    public static void main(String[] args) {

       int portNumber = 4446;

       // int portNumber = Integer.parseInt(System.getProperty("ServerPort"));

        HttpServer sv = null;

        try {
            sv = HttpServer.create();
            sv.bind(new InetSocketAddress(portNumber), 0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        HttpContext svCon = sv.createContext("/", new Server.echoHandler());


        HttpContext svCon2 = sv.createContext("/help", new Server.echoHandlerHelp());

        sv.setExecutor(null);
        sv.start();
    }

    static class echoHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            StringBuilder stringBuilder = new StringBuilder();

            ArrayList<String> headers = new ArrayList<>();

            exchange.getRequestHeaders().values().forEach(o -> headers.add(o.toString()));

            exchange.getRequestHeaders().values().forEach(s -> System.out.println("header: " + s));

            for (String a : headers) {
                if (a.contains("Hello")) {
                    stringBuilder.append("Hello to, my friend ");
                }
            }
            stringBuilder.append("Something random thing");


            byte[] byteArray = stringBuilder.toString().getBytes();
            exchange.sendResponseHeaders(200, byteArray.length);

            OutputStream os = exchange.getResponseBody();

            os.write(byteArray);
            os.close();
            exchange.close();
        }
    }

    static class echoHandlerHelp implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            StringBuilder stringBuilder = new StringBuilder();

            ArrayList<String> headers = new ArrayList<>();

            exchange.getRequestHeaders().values().forEach(s -> System.out.println("header: " + s));

            for (String a : headers) {
                if (a.contains("Help")) {
                    stringBuilder.append("Welcome to help page. We're waiting your questions!");

                }
            }
            stringBuilder.append("Choose the command ");

            byte[] byteArray = stringBuilder.toString().getBytes();
            exchange.sendResponseHeaders(200, byteArray.length);

            OutputStream os = exchange.getResponseBody();

            os.write(byteArray);
            os.close();
            exchange.close();
        }
    }

}
