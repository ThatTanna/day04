package sendfile.src;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) {
        try {
            Socket cs = new Socket("localhost", 12000);

            DataOutputStream dos = new DataOutputStream(cs.getOutputStream());
                cs.getOutputStream();

            // Read a file
            FileReader fr = new FileReader("src/input.txt");
            BufferedReader bfe = new BufferedReader(fr);
            String line;
            while (null != (line = bfe.readLine())) {
                dos.writeUTF(line);
                dos.flush();
            }

            // SEND an EOF identifier to server
            // dos.writeUTF("EOF");
            // dos.flush();

            bfe.close(); // close the file
            cs.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
