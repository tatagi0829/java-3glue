package net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test01 {

	public static void main(String[] args) {

		try {
			InetAddress address = InetAddress.getLocalHost();
			System.out.println(address.getHostName());
			System.out.println(address.getHostAddress());
			address = InetAddress.getByName("www.naver.com");
			System.out.println("naver:"+address.getHostAddress());
			System.out.println();
			
		} catch (UnknownHostException e) {
			System.out.println("주소확인점");
			
		}
		System.out.println("main end");
	}

}
