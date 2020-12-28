package id.ac.its.richard017.syafiq089.afifan234.planetpang;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Random;

public class GameMaster {
	private Queue<Ball> pangQueue;
	private int hitCombo;
	
	private final int BASE_SCORE = 100;
	private final int MAX_COMBO = 24;
	
	private int score;
	
	private final Random generator;
	
	public GameMaster() {
		pangQueue = new LinkedList<Ball>();
		generator = new Random();
	}
	
	private void RefreshPang() {
		if (pangQueue.size() <= 16) {
			AddPang();
		}
	}
	
	private void AddPang() {
		int ctn = generator.nextInt() % 3 + 1;
		int ran = generator.nextInt() % 2; //0 atau 1 // kiri atau kanan
		
		for (int i = 0;i < ctn;i++) {
			pangQueue.add(new Ball(0,0,ran));
		}
	}
	
	public Queue GetPangQueue() {
		return pangQueue;
	}
	
	public Ball GetLatestPang() {
		return pangQueue.peek();
	}
	
	public boolean CheckPang(int typ) {
		Ball temp = GetLatestPang();
		
		if (temp.getSide() == typ) {
			AcceptPang();
			return true;
		} else {
			CancelPang();
		}
		
		return false;
	}
	
	public void AcceptPang() {
		RefreshPang();
	}
	
	public void CancelPang() {
		ResetCombo();
		RefreshPang();
	}
	
	private void AddCombo() {
		AddScore();
		hitCombo += 1;
	}
	
	private void ResetCombo() {
		hitCombo = 0;
	}
	
	public int GetCombo() {
		return hitCombo;
	}
	
	public int GetScore() {
		return score;
	}
	
	private void AddScore() {
		//Menghitung dengan combo dan base score
		int temp = hitCombo;
		if (temp >= MAX_COMBO) {
			temp = MAX_COMBO;
		}
		score += BASE_SCORE + temp;
	}
}
