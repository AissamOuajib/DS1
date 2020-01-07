package ds1_java;

import java.io.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

public class Test {
	public static void main(String[] args) throws IOException {
		MyBuffer myBuffer = new MyBuffer(90);
		Reader lecteur = new Reader("Reader", "fichier.txt", myBuffer);
		Processor processor = new Processor(myBuffer, "Processor");

		lecteur.start();
		processor.start();

		while(lecteur.isAlive()) {}
		
		Set<Entry<String, Integer>> set = processor.getWordsCounts().entrySet();
		Iterator<Entry<String, Integer>> iterator = set.iterator();

		while(iterator.hasNext()) {
			Entry<String, Integer> d = iterator.next();
			System.out.println(d.getKey() +" "+ d.getValue());
		}
	}
}
