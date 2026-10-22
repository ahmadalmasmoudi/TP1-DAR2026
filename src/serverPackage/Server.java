package serverPackage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String args[]) throws IOException {
        ServerSocket serveurSocket=new ServerSocket(1234);
        System.out.println("Je suis un serveur en attente la connexion d'un client");
        Socket socket=serveurSocket.accept();
        System.out.println("un client est connecté");
        DataInputStream is=new DataInputStream(socket.getInputStream());
        DataOutputStream os=new DataOutputStream(socket.getOutputStream());
        int nb;
        do{

            nb =is.readInt();
            if(nb!=0){
                os.writeInt(nb*5);
            }


        }while(nb!=0);

        socket.close();
        serveurSocket.close();


    }
}
