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

public class Server1 {

	public static void main(String[] args) {
		Socket socket = null;
		ServerSocket server = null;
		
		try {
			server = new ServerSocket(9000);
			System.out.println(" Server : 접속대기중");
			socket = server.accept();
			InetAddress address = socket.getInetAddress();
			System.out.println(socket.getInetAddress()+"접속합");
			
			
			OutputStream out = socket.getOutputStream();
			InputStream in = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
			
			String message = null;
			while((message = br.readLine())!= null){
				System.out.println("클라이언트 --> 서버로 : "+message);
				pw.println(message);
				pw.flush();
			
			}
			br.close();
			pw.close();
			socket.close();
		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		
	}

}
