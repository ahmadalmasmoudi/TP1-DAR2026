package serverPackage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String args[]) throws IOException {
        ServerSocket serveurSocket=new ServerSocket(1234);
        System.out.println("Je suis un serveur en attente la connexion d'un client");
        Socket socket=serveurSocket.accept();
        System.out.println("un client est connecté");
        socket.close();
        serveurSocket.close();


    }
}
