import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws Exception {
        String hostName = "127.0.0.1";
        int portNumber = 77;

            Socket echoSocket = new Socket(hostName, portNumber);
            PrintWriter putInServer = new PrintWriter(echoSocket.getOutputStream(), true);
            BufferedReader getFromServer = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            String userInput;
            while ((userInput = in.readLine()) != null) {
                putInServer.println(userInput);
                System.out.println(getFromServer.readLine());
            }
       
    }
}