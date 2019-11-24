import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import javax.sound.midi.Synthesizer;

public class Dowloader {
	public static void main(String[] args) throws IOException{
		Scanner s = new Scanner (System.in);
		System.out.println("Enter the Url");
		String urlStr =s.next();
		URL url = new URL(urlStr);
		URLConnection connectObj = url.openConnection();
		connectObj.connect();
		InputStream is = connectObj.getInputStream();
		BufferedInputStream bs = new BufferedInputStream(is);
		System.out.println("hello");
		FileOutputStream fs = new FileOutputStream("\\C:\\Users\\Sh.SANJAY Maheshwar .LAPTOP-6O53OMLG\\Documents"
				+ "\\file\\google.jpg");
		BufferedOutputStream bo = new BufferedOutputStream(fs);
		int SingleByte = bs.read();
		while(SingleByte!=-1){
			bo.write(SingleByte);
			SingleByte = bs.read();
		}
		
		System.out.println("File Download...");
		bs.close();
		bo.close();
		fs.close();
		is.close();
		s.close();
	}

	private static URLConnection connect() {
		// TODO Auto-generated method stub
		return null;
	}


	}



