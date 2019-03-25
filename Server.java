import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static final int PORT_NUMBER = 9999;

	public static void main(String args[]) throws IOException {
		//Creates new server socket on port 9999
		ServerSocket serverSocket = new ServerSocket(PORT_NUMBER);
		Socket socket = serverSocket.accept();
		//Creates BufferedReader to read server socket input stream that has data from client
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		//Creates OutputStream and PrintWriter to put data into server output stream to be sent to client socket
		OutputStream os = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(os, true);
		//Reads message from client
		String clientMessage = br.readLine();
		//Reverses message
		String serverResponse = reverseString(clientMessage);
		//Responds to client
		pw.println("Server says: " + serverResponse);
		
		//Frees resources and closes socket
		os.close();
		pw.close();
		socket.close();
		serverSocket.close();
		
		
}
	//Takes string as a parameter and returns that string reversed
	// Hello -> olleH
	public static String reverseString(String s) {
		String reversed = "";
		for(int i = s.length() - 1; i>=0; i--) {
			reversed += s.charAt(i);
		}
		return reversed;
	}
}
