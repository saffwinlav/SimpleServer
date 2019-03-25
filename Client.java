import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static final int PORT_NUMBER = 9999;
	public static final String HOST_NAME ="localhost";
	
	public static void main(String []args) throws IOException  {
		
		//Gets input string from client
		String clientinput = "";
		Scanner kbd = new Scanner(System.in);
		System.out.println("Please enter a message to the server");
		clientinput = kbd.nextLine();
		System.out.println("You say: " + clientinput);
	
		//Creates client socket on localhost port number 9999
		Socket clientsocket = new Socket(HOST_NAME, PORT_NUMBER);
		//Creates PrintWriter to send output stream data to the server socket from client
		PrintWriter out = new PrintWriter(clientsocket.getOutputStream(), true);
		//Creates BufferedReader to read input stream data being sent to client socket from server
		BufferedReader br = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
		//Puts user determined string into the output stream of the client socket to be received by server socket
		out.println(clientinput);
		//Reads response from server from client socket's input stream and prints message to user 	
		System.out.println(br.readLine());
		//Frees resources and closes socket
		clientsocket.close();
		br.close();
		out.close();
		kbd.close();
			
		
		
		}
	}


