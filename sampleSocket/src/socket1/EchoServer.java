package socket1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	public static void main(String[] args) {
		ServerSocket server =null;
		try{
			server = new ServerSocket(9001);
			System.out.println("접속대기");
			while(true){
				Socket socket =server.accept();
				new EchoThread(socket).start();
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			try{
				if(server !=null) server.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}

}

class EchoThread extends Thread{
	Socket socket; 
	
	public EchoThread(Socket socket) {
		super();
		this.socket = socket;
	}

	public EchoThread() {
		super();
	}

	@Override
		public void run(){
		InetAddress address = socket.getInetAddress();
		System.out.println(socket.getInetAddress()+"접속합");
		
		try{
		OutputStream out = socket.getOutputStream();
		InputStream in = socket.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
		
		String message = null;
		while((message = br.readLine())!= null){
		//	System.out.println("클라이언트 --> 서버로 : "+message);
			pw.println(message);
			pw.flush();
		
		}
		br.close();
		pw.close();
		socket.close();
		}catch(Exception e){
			
		}finally{
			
		}
		}
}