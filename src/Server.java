import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        System.out.println("SOCK SERVER: ");
        int PORT = 12345;

        // Create ServerSocket
        try {
            ServerSocket server = new ServerSocket(PORT);

            // Get the socket object
            Socket socket = server.accept();
            // New connection from a client. (We've just accepted it)

            InputStream is = socket.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            DataInputStream dis = new DataInputStream(bis);

            // String msg = dis.readUTF(); // If there's any message from the client, if will be available here..
            // System.out.println("Message received -> " + msg );
            // String msg2 = dis.readUTF(); // if there's any msg
            // System.out.println("MSG received -> " + msg2)
            // socket.close();
            
            String fromClient = dis.readUTF();
            while (!fromClient.equalsIgnoreCase("close") && fromClient != null) {
                
                // process the msg
                System.out.println("Received msg from client: " + fromClient);
                // read the next line from the input stream
                fromClient = dis.readUTF();
            }
            socket.close();

        } catch (IOException e) {
            System.out.println("IO Error");
        }
    }
}