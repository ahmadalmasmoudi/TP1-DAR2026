package clientPackage;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("Je suis un client pas encore connecté…");
        Socket socket=new Socket("localhost",1234);
        System.out.println("je suis un client connecté");
        Scanner sc=new Scanner(System.in);
        int nb;
        DataOutputStream os=new DataOutputStream(socket.getOutputStream());
        DataInputStream is=new DataInputStream(socket.getInputStream());
        do{
            nb=sc.nextInt();

            os.writeInt(nb);
            if(nb!=0){
                nb=is.readInt();
                System.out.println("resultat: "+nb);
            }

        }while(nb!=0);




        socket.close();
    }
}
