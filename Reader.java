package ds1_java;

import java.io.*;

public class Reader extends Thread {
	private String fileName;
	private String ReaderName;
	private MyBuffer myBuffer;
	BufferedInputStream bufferedInputStream;
	public static int stp = 0;

	public Reader(String ReaderName, String fileName, MyBuffer buffer) throws FileNotFoundException {
		this.ReaderName = ReaderName;
		this.fileName = fileName;
		this.myBuffer = buffer;
		this.bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(this.fileName)));
	}

	public String readWord() throws IOException {
		byte[] b = new byte[1];
		int i = 0;
		String word = "";
		while ((i = this.bufferedInputStream.read(b)) >= 0 && Character.toString((char) b[0]).matches("\\w") && ((char) b[0]) != '\n') {
			word += (char) b[0];
		}
		stp = i;
		return word;
	}

	public void run() {
		while (true) {
			try {
				String word = readWord();
				if(word != "") myBuffer.addWord(word);
				if(stp == -1) break;
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
