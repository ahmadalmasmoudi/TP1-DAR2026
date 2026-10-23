package clientPackage;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("Je suis un client pas encore connecté…");
        InetAddress ip =InetAddress.getByName("192.168.1.244");
        InetSocketAddress adresse=new InetSocketAddress(ip,1234);
        Socket socket=new Socket();
        socket.connect(adresse);

        System.out.println("j' suis un client connecté");
        Scanner sc=new Scanner(System.in);
        int nb;
        DataOutputStream os=new DataOutputStream(socket.getOutputStream());
        DataInputStream is=new DataInputStream(socket.getInputStream());
        char op;
        do{
            nb=sc.nextInt();
             op=sc.next().charAt(0);

            os.writeInt(nb);
            os.writeChar(op);
            if(nb!=0){
                nb=is.readInt();
                System.out.println("resultat: "+nb);
            }

        }while(nb!=0);
        socket.close();
    }
}
