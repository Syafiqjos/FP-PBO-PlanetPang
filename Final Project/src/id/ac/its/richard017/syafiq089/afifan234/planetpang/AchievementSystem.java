package id.ac.its.richard017.syafiq089.afifan234.planetpang;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AchievementSystem implements Serializable{
	
	private boolean isReaching10Combo;
	private boolean isReaching30Combo;
	private boolean isReaching50Combo;
	private boolean isSwapping5Planet; //1
	private boolean isSwapping10Planet; //3
	private boolean isSwapping15Planet; //5
	//private boolean isBlindFoldPlaying;
	private boolean isScoreTinggi; //Score > 5000
	private boolean isScoreTengah; //Score > 3000
	private boolean isScoreRendah; //Score > 1000
	private boolean isScore0;
	private boolean isFullPerfect;
	//private boolean isPlayingStanding;
	//private boolean isPlayingOneHand;
	//private boolean isPlayingWithSmartphone;
	
	public AchievementSystem()
	{
		this(false,false,false,false,false,false,false,false,false,false,false);
	}

	public AchievementSystem(boolean isReaching10Combo, boolean isReaching30Combo, boolean isReaching50Combo,
			boolean isSwapping5Planet, boolean isSwapping10Planet, boolean isSwapping15Planet,
			boolean isScoreTinggi, boolean isScoreTengah, boolean isScoreRendah,
			boolean isScore0, boolean isFullPerfect) {
		//super();
		this.isReaching10Combo = isReaching10Combo;
		this.isReaching30Combo = isReaching30Combo;
		this.isReaching50Combo = isReaching50Combo;
		this.isSwapping5Planet = isSwapping5Planet;
		this.isSwapping10Planet = isSwapping10Planet;
		this.isSwapping15Planet = isSwapping15Planet;
		this.isScoreTinggi = isScoreTinggi;
		this.isScoreTengah = isScoreTengah;
		this.isScoreRendah = isScoreRendah;
		this.isScore0 = isScore0;
		this.isFullPerfect = isFullPerfect;
	}

	//GETTERS AND SETTERS
			public boolean isReaching10Combo() {
				return isReaching10Combo;
			}
		
			public void setReaching10Combo(boolean isReaching10Combo) {
				this.isReaching10Combo = isReaching10Combo;
			}
		
			public boolean isReaching30Combo() {
				return isReaching30Combo;
			}
		
			public void setReaching30Combo(boolean isReaching30Combo) {
				this.isReaching30Combo = isReaching30Combo;
			}
		
			public boolean isReaching50Combo() {
				return isReaching50Combo;
			}
		
			public void setReaching50Combo(boolean isReaching50Combo) {
				this.isReaching50Combo = isReaching50Combo;
			}
		
			public boolean isSwapping5Planet() {
				return isSwapping5Planet;
			}
		
			public void setSwapping5Planet(boolean isSwapping5Planet) {
				this.isSwapping5Planet = isSwapping5Planet;
			}
		
			public boolean isSwapping10Planet() {
				return isSwapping10Planet;
			}
		
			public void setSwapping10Planet(boolean isSwapping10Planet) {
				this.isSwapping10Planet = isSwapping10Planet;
			}
		
			public boolean isSwapping15Planet() {
				return isSwapping15Planet;
			}
		
			public void setSwapping15Planet(boolean isSwapping15Planet) {
				this.isSwapping15Planet = isSwapping15Planet;
			}
		
			public boolean isScoreTinggi() {
				return isScoreTinggi;
			}
		
			public void setScoreTinggi(boolean isScoreTinggi) {
				this.isScoreTinggi = isScoreTinggi;
			}
		
			public boolean isScoreTengah() {
				return isScoreTengah;
			}
		
			public void setScoreTengah(boolean isScoreTengah) {
				this.isScoreTengah = isScoreTengah;
			}
		
			public boolean isScoreRendah() {
				return isScoreRendah;
			}
		
			public void setScoreRendah(boolean isScoreRendah) {
				this.isScoreRendah = isScoreRendah;
			}
		
			public boolean isScore0() {
				return isScore0;
			}
		
			public void setScore0(boolean isScore0) {
				this.isScore0 = isScore0;
			}
		
			public boolean isFullPerfect() {
				return isFullPerfect;
			}
		
			public void setFullPerfect(boolean isFullPerfect) {
				this.isFullPerfect = isFullPerfect;
			}
			
	//END OF SETTER GETTER
	
	public void saveAchievement()
	{
		try 
		{
			OutputStream fos = Files.newOutputStream(Paths.get("data2.bin"));
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			/*
			AchievementSystem as = new AchievementSystem(this.isReaching10Combo, this.isReaching30Combo, this.isReaching50Combo,
					this.isSwapping5Planet, this.isSwapping10Planet, this.isSwapping15Planet,
					this.isScoreTinggi, this.isScoreTengah, this.isScoreRendah,
					this.isScore0, this.isFullPerfect);
					*/
			AchievementSystem as = this;

			//as.printAchievement();
			System.out.println("Save");
			
			oos.writeObject(as);
			
			oos.close();

		} catch (IOException ex) 
			{
			    ex.printStackTrace();
			}
	}
	
	public AchievementSystem loadAchievement()
	{
		try 
		{
			InputStream fis = Files.newInputStream(Paths.get("data2.bin"));
			ObjectInputStream ois = new ObjectInputStream(fis);

			printAchievement();
			
			return (AchievementSystem) ois.readObject();		
		} catch (IOException ex) 
			{
			    ex.printStackTrace();
			} 
		  catch (ClassNotFoundException e) 
			{
			e.printStackTrace();
			}
		
		printAchievement();
		
		return this;
	}
	
	public void printAchievement() {
		System.out.println("Printing Achievement..");
		System.out.println(isReaching10Combo);
		System.out.println(isReaching30Combo);
		System.out.println(isReaching50Combo);
		
		System.out.println(isSwapping5Planet);
		System.out.println(isSwapping10Planet);
		System.out.println(isSwapping15Planet);
		
		System.out.println(isScoreTinggi);
		System.out.println(isScoreTengah);
		System.out.println(isScoreRendah);
		
		System.out.println(isScore0);
		
		System.out.println(isFullPerfect);
	}
	
	public void checkAchievement(boolean isSaved, int combo, int comboPerSecond, int score, boolean alreadyMiss)
	{
		if (!isReaching10Combo && combo >= 10) {
			System.out.println("Unlock Combo 10");
			isReaching10Combo = true;
		} if (!isReaching30Combo && combo >= 30) {
			isReaching30Combo = true;
			System.out.println("Unlock Combo 30");
		} if (!isReaching50Combo && combo >= 50) {
			isReaching50Combo = true;
			System.out.println("Unlock Combo 50");
		}
		
		if (!isSwapping5Planet && comboPerSecond >= 1) {
			isSwapping5Planet = true;
			System.out.println("Unlock Swap 1");
		} if (!isSwapping10Planet && comboPerSecond >= 3) {
			isSwapping10Planet = true;
			System.out.println("Unlock Swap 3");
		} if (!isSwapping15Planet && comboPerSecond >= 5) {
			isSwapping15Planet = true;
			System.out.println("Unlock Swap 5");
		}
		
		if (!isScoreRendah && score >= 1000) {
			isScoreRendah = true;
			System.out.println("Unlock Score 1000");
		} if (!isScoreTengah && score >= 3000) {
			isScoreTengah = true;
			System.out.println("Unlock Score 3000");
		} if (!isScoreTinggi && score >= 5000) {
			isScoreTinggi = true;
			System.out.println("Unlock Score 5000");
		}
		
		if (!isScore0 && isSaved && score == 0) {
			isScore0 = true;
			System.out.println("Unlock Score 0");
		}
		
		if (!isFullPerfect && isSaved && !alreadyMiss) {
			isFullPerfect = true;
			System.out.println("Unlock Perfect");
		}
	}
	
}
