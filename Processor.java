package ds1_java;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

public class Processor extends Thread{
	private MyBuffer myBuffer;
	private String ProcessorName;
	private HashMap<String, Integer> wordsCounts;
	
	public Processor(MyBuffer buffer, String ProcessorName) {
		this.myBuffer = buffer;
		this.ProcessorName = ProcessorName;
		this.wordsCounts = new HashMap<String, Integer>();
	}

	public void run() {
		while(true){
			try {
				this.processe();
				if(Reader.stp == -1) break;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void processe() throws InterruptedException {
		String word = myBuffer.getWord();
		int i = 0;
		Set<Entry<String, Integer>> set = wordsCounts.entrySet();
		Iterator<Entry<String, Integer>> iterator = set.iterator();
		while(iterator.hasNext()) {
			Entry<String, Integer> d = iterator.next();
			if(word.equals(d.getKey())) i = d.getValue();
		}
		if(wordsCounts.containsKey(word)) wordsCounts.put(word, i+1);
		else wordsCounts.put(word, 1);
	}

	public HashMap<String, Integer> getWordsCounts(){
		return  wordsCounts;
	}
}