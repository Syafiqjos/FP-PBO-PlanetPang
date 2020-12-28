package id.ac.its.richard017.syafiq089.afifan234.planetpang;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Formatter;


public class HighscoreSystem {

	private int score;
	private int highScore;
	private static ObjectOutputStream output;
	private static ObjectInputStream input;
	
	public HighscoreSystem()
	{
		this(0);
	}
	
	public HighscoreSystem(int highScore)
	{
		this.highScore = highScore;
	}
	public static void createHighScoreFile()
	{
		try
		{
			output = new ObjectOutputStream(
					Files.newOutputStream(Paths.get("clients.ser")));
		}
		catch (IOException ioException)
		{
			System.err.println("Error opening file. Terminating.");
			System.exit(1);
		}
	}
	
	public void checkHighScore()
	{
		try
		{
			input = new ObjectInputStream(
					Files.newInputStream(Paths.get("clients.ser")));
		}
		catch (IOException ioException)
		{
			System.err.println("Error opening file.");
			System.exit(1);
		}
		try
		{
				HighscoreSystem record = (HighscoreSystem) input.readObject();
				if (record.getHighScore() < this.highScore)
				{
					this.highScore = record.getHighScore();
				}
		}
		catch (ClassNotFoundException classNotFoundException)
		{
			System.err.println("Invalid object type. Terminating.");
		}
		catch (IOException ioException)
		{
			System.err.println("Error reading from file. Terminating.");
		}
	}
	
	public int getHighScore()
	{
		return highScore;
	}
	public static void checkScore()
	{
		
	}
}
