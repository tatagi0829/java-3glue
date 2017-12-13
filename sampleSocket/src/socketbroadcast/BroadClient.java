package socketbroadcast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class BroadClient {

	public static void main(String[] args) {
		
		Socket socket = null;
		
		try {
			String name = "["+args[0]+"]";
			socket = new Socket("70.12.109.51", 9001);
			System.out.println("Á¢¼ÓµÊ");
			
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			
			InputStream in = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			OutputStream out = socket.getOutputStream();
			System.out.println(keyboard.readLine());
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
			
			new ClientThread(socket, br).start();
			
			String message = null;
			while((message = keyboard.readLine())!= null){
				if(message.equals("quit")) break;
				pw.println(name+message);
				pw.flush();
				//String echoMessage = br.readLine();
				//System.out.println(echoMessage);
			}
			br.close();
			pw.close();
			socket.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
				
		
	}

}
class ClientThread extends Thread{
	Socket socket;
	BufferedReader br ;
		
	
	public ClientThread(Socket socket, BufferedReader br) {
		super();
		this.socket = socket;
		this.br = br;
	}


	public ClientThread() {
		super();
	}


	public void run(){
	try{
		String msg = null;
		while((msg=br.readLine())!=null){
			System.out.println(msg);
		}
	}catch( Exception e){
		
	}finally{
		
	}
	}
}
