

package chatprogram1;

import static com.sun.glass.ui.Application.run;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClientConnection extends Thread{

    static ArrayList ara = new ArrayList();
    static int rowValue = 0;
    static Thread t = new Thread();
    static Thread t2 = new Thread();
    public static void handleClient(Socket s){
        runnable r = new runnable();
        runnable r2 = new runnable();
      r.run();
      r2.run();
    }
    static Socket s = new Socket();

    public static class runnable implements Runnable {

        @Override
        public void run() {

            try {

                Scanner scn = new Scanner(s.getInputStream());
                PrintWriter prnt = new PrintWriter(s.getOutputStream(), true);
                String msg = "";
                prnt.println("welcome to my server, Please enter a username");

                if (!msg.equals("stop")) {
                    msg = scn.nextLine();
                    ara.add(scn.nextLine());
                    prnt.println("welcome");
                    prnt.println(ara);
                    if (rowValue != 0) {
                        rowValue++;
                    }

                }

                while (!msg.equals("c logout")) {

                    prnt.println(ara.get(rowValue));
                    msg = scn.nextLine();

                    if (msg.equals("clientlist")) {
                        prnt.println(ara);
                    }

                }
                prnt.println("you have been logged out");
                rowValue--;
                scn.close();
                prnt.close();
                s.close();
            } catch (IOException ex) {
                Logger.getLogger(ChatProgram1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
