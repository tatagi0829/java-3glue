package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
	
		Socket socket = null;
		
		try {
			socket = new Socket("70.12.109.51", 9000);
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

			InputStream in = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			OutputStream out = socket.getOutputStream();
			System.out.println(keyboard.readLine());
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
			
			String message = null;
			while((message = keyboard.readLine())!= null){
				pw.println(message);
				pw.flush();
				String echoMessage = br.readLine();
				System.out.println("서버 --> 클라이언트로  : "+echoMessage);
			}
			br.close();
			pw.close();
			socket.close();
		} catch (UnknownHostException e) {
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
