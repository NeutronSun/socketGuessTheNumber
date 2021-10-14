import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
     
        String hostName = "127.0.0.1";
        
        int portNumber = 77;

        try (
            Socket echoSocket = new Socket(hostName, portNumber);
            PrintWriter putInServer = new PrintWriter(echoSocket.getOutputStream(), true);
            BufferedReader getFromServer = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {

            String userInput;
            while ((userInput = in.readLine()) != null) {
                putInServer.println(userInput);
                System.out.println(getFromServer.readLine());
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                hostName);
            System.exit(1);
        } 
    }
}