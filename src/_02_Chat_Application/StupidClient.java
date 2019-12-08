package _02_Chat_Application;


import java.net.*;
import java.util.Scanner;
import java.io.*;

public class StupidClient {

   public static void main(String [] args) {
	  //1. Create a String for the ip address of the server. 
	  // If you don't know how to find a computer's ip address, ask about ifconfig on linux/mac and ipconfig on windows.
	   String ip = getIPAddress();
      
      //2. Create an integer for the server's port number
      int portNumber = 8080;
      //3. Surround steps 4-9 in a try-catch block that catches any IOExceptions.
    try {
    	 //4. Create an object of the Socket class. When initializing the object, pass in the ip address and the port number
    	
    	Socket socket = new Socket(ip, portNumber);
         //5. Create a DataOutputStream object. When initializing it, use the Socket object you created in step 4 to call the getOutputStream() method.
    	DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
         //6. Use the DataOutputStream object to send a message to the server using the writeUTF(String message) method
         dataOut.writeUTF("death is inevitable");
         //7. Create a DataInputStream object. When initializing it, use the Server object you created in step 4 to call the getInputStream() method.
         DataInputStream dataIn = new DataInputStream(socket.getInputStream());
         //8. Use the DataInputStream object to print a message from the server using the readUTF() method.
         System.out.println(dataIn.readUTF());
         //9. Close the client's server object
         Scanner scanner = new Scanner(System.in);
         while(true) {
        	 System.out.println("what do you say?");
        	 dataOut.writeUTF(scanner.nextLine());
        	 System.out.println("Responce: " + dataIn.readUTF());
         }
    }
    catch(IOException e) {
    	e.printStackTrace();
    }

   }
   public static String getIPAddress() {
		try {
			return InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			return "ERROR!!!!!";
		}
	}
}
