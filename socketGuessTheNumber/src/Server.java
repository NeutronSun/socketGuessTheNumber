import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws IOException {
        int portNumber = 77;
        int nToGuess = (int)(Math.random() * 100) + 1;
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();

            PrintWriter putIncliet = new PrintWriter(clientSocket.getOutputStream(), true);                   
            BufferedReader getFromItSelf = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String userInput;
            System.out.println(nToGuess);
            while ((userInput = getFromItSelf.readLine()) != null) {
                if(Integer.parseInt(userInput) == nToGuess){
                    putIncliet.println("You guessed the Numer!! Now there is a new one to guess ;D");
                    nToGuess = (int)(Math.random() * 100) + 1;
                    continue;
                }
                if(Integer.parseInt(userInput) > nToGuess)
                    putIncliet.println("The number is smaller ;D");
                else
                    putIncliet.println("The number is bigger ;D");
            }
        
    }
}