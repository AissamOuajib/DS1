package ds1_java;

import java.util.LinkedList;

public class MyBuffer {
	private LinkedList<String> data;
	private int size;

	public MyBuffer(int size) {
		this.size = size;
		data = new LinkedList<String>();
	}

	public synchronized void addWord(String word) throws InterruptedException {
		while(data.size() == this.getsize())
		wait();
		data.add(word);
		System.out.println("----------- Add Word ----------- \n"+ word);
		notify();
	}
	public synchronized String getWord() throws InterruptedException {
		while(data.size() == 0)
			wait();
	
		String word = data.poll();
		System.out.println("----------- Get Word ----------- \n"+ word);
		notify();
		return word;
	}
	public  LinkedList<String> getdata(){
		return data;
	}
	public int getsize() {
		return this.size;
	}

}
