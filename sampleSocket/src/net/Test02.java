package net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Test02 {

	public static void main(String[] args) {

		try {
			URL url = new URL("https://www.naver.com/index.html");
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			String readLine = null;
			while ((readLine = br.readLine()) != null) {
				System.out.println(readLine);

			}
			br.close();//? finally

		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("main end");
	}

}
