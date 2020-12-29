package id.ac.its.richard017.syafiq089.afifan234.planetpang;

import java.io.Serializable;

class HighScore implements Serializable{
	private int highScore;
	
	public HighScore(int highScore)
	{
		this.highScore = highScore;
	}
	
	public void print()
	{
		System.out.println("Your Highscore : " + highScore);
	}
}
