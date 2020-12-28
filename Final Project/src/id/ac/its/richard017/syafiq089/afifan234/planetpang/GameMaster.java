package id.ac.its.richard017.syafiq089.afifan234.planetpang;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Random;

public class GameMaster {
	private Queue<Ball> pangQueue;
	private int hitCombo;
	
	private int state = 0;
	
	private final int BASE_SCORE = 100;
	private final int MAX_COMBO = 24;
	
	public static int COUNT = 0;
	
	private int score;
	
	private final Random generator;
	
	public GameMaster() {
		pangQueue = new LinkedList<Ball>();
		generator = new Random();
		
		InitialPang();
	}
	
	private void InitialPang() {
		state = generator.nextInt() % 2; //0 atau 1 // kiri atau kanan
		
		RefreshPang();
	}
	
	private void RefreshPang() {
		while (pangQueue.size() <= 16) {
			GeneratePang();
		}
	}
	
	private void GeneratePang() {
		int ctn = generator.nextInt() % 3 + 1;
		
		for (int i = 0;i < ctn;i++) {
			AddPang(state);
		}
		
		state = (state + 1) % 2;
	}
	
	private void AddPang(int side) {
		Ball b = new Ball(0,0,side);
		//b.SetCount(count); //catatan untuk masa depan
		
		pangQueue.add(b);

		COUNT++;
	}
	
	public Queue GetPangQueue() {
		return pangQueue;
	}
	
	public Ball GetLatestPang() {
		return pangQueue.peek();
	}
	
	public void CheckPang(int typ) {
		Ball temp = GetLatestPang();
		
		if (temp.getSide() == typ) {
			AcceptPang();
		} else {
			CancelPang();
		}
	}
	
	public void AcceptPang() {
		AddCombo();
		DequeuePang();
		RefreshPang();
		
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
