import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        int PORT = 12345;
        try {
            Socket cs = new Socket("localhost", PORT);

            // Get the IO stream
            OutputStream os = cs.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(os);
            DataOutputStream dos = new DataOutputStream(bos);

            // dos.writeUTF("Hello world from Client");
            // dos.flush();
            // System.out.println("MESSAGE SENT TO SERVER");
            // cs.close();

            Scanner scan = new Scanner(System.in);
            String line;
            while ((line = scan.nextLine()) !=null) {
                if (line.equalsIgnoreCase("close")) {
                    System.out.println("Exit from shell");
                    break;
                }

                dos.writeUTF(line);
                dos.flush();

            }
            cs.close(); // closing the socket from client.
            dos.flush();
            scan.close();
            System.out.println("MSG sent to client: " + line);

        } catch (UnknownHostException e) {
            System.out.println("Unable to reach the host");
        } catch (IOException e) {
            System.out.println("IO Error");
        }
    }
}
