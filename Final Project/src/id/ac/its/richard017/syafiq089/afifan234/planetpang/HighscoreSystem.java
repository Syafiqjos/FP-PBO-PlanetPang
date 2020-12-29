package id.ac.its.richard017.syafiq089.afifan234.planetpang;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Formatter;
import java.io.Serializable;
import java.util.NoSuchElementException;

public class HighscoreSystem implements Serializable{

	private int score;
	private int highScore;
	private static ObjectOutputStream output;
	private static ObjectInputStream input;
	HighscoreSystem record;
	
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
	
	public int loadHighScore()
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
			record = (HighscoreSystem) input.readObject();	
		}
		catch (ClassNotFoundException classNotFoundException)
		{
			System.err.println("Invalid object type. Terminating.");
		}
		catch (IOException ioException)
		{
		}
		return record.getHighScore();
	}
	
	public void saveHighScore(int score)
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
		try
		{
			record = new HighscoreSystem(score);
			output.writeObject(record);
		}
		catch (IOException ioException)
		{
		}
	}
	
	public int getHighScore()
	{
		return highScore;
	}
}
