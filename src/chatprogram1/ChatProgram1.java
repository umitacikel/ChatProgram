package chatprogram1;

import static chatprogram1.ClientConnection.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatProgram1 {

    static String ip = "localhost";
    static int portNum = 8084;

    public static void main(String[] args) throws IOException {
        if (args.length == 2) {
            ip = args[0];
            portNum = Integer.parseInt(args[1]);

        }
        ServerSocket ss = new ServerSocket();
        ss.bind(new InetSocketAddress(ip, portNum));
        
        

        while (true) {

            Socket link = ss.accept();
            System.out.println("new Client Connection");
            ClientConnection.handleClient(link);
            
            Socket link2 = ss.accept();
            System.out.println("new Client Connection");
            ClientConnection.handleClient(link2);
            
            
        
            
            
            
//           runnable rc = new runnable();
//           Thread t1 = new Thread(rc);
//            t1.start();
//            
//            Thread t2 = new Thread(rc);
//            t2.start();
            
            
        }


    }

}
