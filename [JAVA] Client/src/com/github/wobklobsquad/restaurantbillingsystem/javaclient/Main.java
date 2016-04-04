package com.github.wobklobsquad.restaurantbillingsystem.javaclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Main {
	
	public static void main(String [] args)
	{
		String serverName = args[0];
		int port = Integer.parseInt(args[1]);
		String cmd = args[2];
		String product = args[3];
		try
		{
			Socket client = new Socket(serverName, port);
			OutputStream outToServer = client.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
         
			//Send the message from the third argument
			out.writeUTF(cmd + "-" + product);
         
			InputStream inFromServer = client.getInputStream();
			DataInputStream in = new DataInputStream(inFromServer);
         
			//Get the message from the server
			System.out.println(in.readUTF());
         
			client.close();
      }catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}