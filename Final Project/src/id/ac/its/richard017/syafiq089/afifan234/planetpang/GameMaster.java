package id.ac.its.richard017.syafiq089.afifan234.planetpang;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Random;

public class GameMaster {
	private Queue<Ball> pangQueue;
	private Queue<Ball> oldPangQueue;
	
	private int hitCombo;
	
	private int state = 0;
	
	private final int BASE_SCORE = 10;
	private final int MAX_COMBO = 24;
	
	public static int COUNT = 0;
	public static int RAW_COUNT = 0;
	
	private static int score;
	private int highscore = 0;
	
	private final Random generator;
	
	public GameMaster() {
		pangQueue = new LinkedList<Ball>();
		oldPangQueue = new LinkedList<Ball>();
		generator = new Random();
		
		score = 0;
		
		InitialPang();
		
		LoadHighscore();
	}
	
	private void InitialPang() {
		COUNT = 0;
		RAW_COUNT = 0;
		
		state = ((generator.nextInt() % 2) + 2) % 2; //0 atau 1 // kiri atau kanan
		
		System.out.printf("State %d%n",state);
		
		RefreshPang();
	}
	
	private void RefreshPang() {
		while (pangQueue.size() < 16) {
			GeneratePang();
		}
	}
	
	private void GeneratePang() {
		int ctn = ((generator.nextInt() % 3) + 3) % 3 + 1;
		
		for (int i = 0;i < ctn;i++) {
			AddPang(state);
		}
		
		state = (((state + 1) % 2) + 2) % 2;
	}
	
	private void AddPang(int side) {
		Ball b = new Ball(0,0,side);
		b.setCount(RAW_COUNT); //catatan untuk masa depan
		
		pangQueue.add(b);
		oldPangQueue.add(b);
		
		if (oldPangQueue.size() >= 32) {
			oldPangQueue.remove();
		}

		RAW_COUNT++;
	}
	
	public Queue GetPangQueue() {
		return pangQueue;
	}
	
	public Queue GetOldPangQueue() {
		return oldPangQueue;
	}
	
	public Ball GetLatestPang() {
		return pangQueue.peek();
	}
	
	public boolean CheckPang(int typ) {
		Ball temp = GetLatestPang();
		
		if (temp.getSide() == typ) {
			temp.Out();
			AcceptPang();
			return true;
		} else {
			CancelPang();
		}
		return false;
	}
	
	public void AcceptPang() {
		AddCombo();
		DequeuePang();
		RefreshPang();
		
		COUNT++;
		
		System.out.println("Accepted");
	}
	
	public void CancelPang() {
		ResetCombo();
		RefreshPang();
		
		System.out.println("Cancelled");
	}
	
	private void DequeuePang() {
		pangQueue.remove();
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
	
	public static int GetScore() {
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
	
	public void LoadHighscore() {
		highscore = MainApp.highscoreSystem.loadHighScore();
	}

	public void SaveHighscore() {
		MainApp.highscoreSystem.saveHighScore(highscore);
	}
	
	public void UpdateHighscore() {
		if (score > highscore) {
			highscore = score;
		}
		SaveHighscore();
	}
	
	public int GetHighscore() {
		return highscore;
	}
}
