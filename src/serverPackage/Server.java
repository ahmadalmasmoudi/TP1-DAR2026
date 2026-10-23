package serverPackage;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String args[]) throws IOException {
        ServerSocket serveurSocket=new ServerSocket();
        InetAddress ip=InetAddress.getByName("192.168.1.244");
        InetSocketAddress adresse=new InetSocketAddress(ip,1234);
        serveurSocket.bind(adresse);
        System.out.println("Je suis un serveur en attente la connexion d un client");
        Socket socket=serveurSocket.accept();
        System.out.println("un client est connecté");
        DataInputStream is=new DataInputStream(socket.getInputStream());
        DataOutputStream os=new DataOutputStream(socket.getOutputStream());
        int nb;
        char op;
        do{
            nb =is.readInt();
            if(nb!=0){
                op=is.readChar();
                switch (op){
                    case '*':nb=nb*5; break;
                    case '/':nb=nb/5; break;
                    case '+':nb=nb+5; break;
                    case '-':nb=nb-5; break;

                }
                os.writeInt(nb);
            }

        }while(nb!=0);
        socket.close();
        serveurSocket.close();
    }
}
