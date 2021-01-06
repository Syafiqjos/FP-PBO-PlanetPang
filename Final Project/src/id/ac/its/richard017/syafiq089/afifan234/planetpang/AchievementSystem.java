package id.ac.its.richard017.syafiq089.afifan234.planetpang;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class AchievementSystem implements Serializable{
	
	private boolean isReaching10Combo;
	private boolean isReaching30Combo;
	private boolean isReaching50Combo;
	private boolean isSwapping5Planet;
	private boolean isSwapping10Planet;
	private boolean isSwapping15Planet;
	private boolean isBlindFoldPlaying;
	private boolean isScoreTinggi;
	private boolean isScoreTengah;
	private boolean isScoreRendah;
	private boolean isScore0;
	private boolean isFullPerfect;
	private boolean isPlayingStanding;
	private boolean isPlayingOneHand;
	private boolean isPlayingWithSmartphone;
	
	public AchievementSystem()
	{
		this(false,false,false,false,false,false,false,false,false,false,false,false,false,false,false);
	}

	public AchievementSystem(boolean isReaching10Combo, boolean isReaching30Combo, boolean isReaching50Combo,
			boolean isSwapping5Planet, boolean isSwapping10Planet, boolean isSwapping15Planet,
			boolean isBlindFoldPlaying, boolean isScoreTinggi, boolean isScoreTengah, boolean isScoreRendah,
			boolean isScore0, boolean isFullPerfect, boolean isPlayingStanding, boolean isPlayingOneHand,
			boolean isPlayingWithSmartphone) {
		super();
		this.isReaching10Combo = isReaching10Combo;
		this.isReaching30Combo = isReaching30Combo;
		this.isReaching50Combo = isReaching50Combo;
		this.isSwapping5Planet = isSwapping5Planet;
		this.isSwapping10Planet = isSwapping10Planet;
		this.isSwapping15Planet = isSwapping15Planet;
		this.isBlindFoldPlaying = isBlindFoldPlaying;
		this.isScoreTinggi = isScoreTinggi;
		this.isScoreTengah = isScoreTengah;
		this.isScoreRendah = isScoreRendah;
		this.isScore0 = isScore0;
		this.isFullPerfect = isFullPerfect;
		this.isPlayingStanding = isPlayingStanding;
		this.isPlayingOneHand = isPlayingOneHand;
		this.isPlayingWithSmartphone = isPlayingWithSmartphone;
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
		
			public boolean isBlindFoldPlaying() {
				return isBlindFoldPlaying;
			}
		
			public void setBlindFoldPlaying(boolean isBlindFoldPlaying) {
				this.isBlindFoldPlaying = isBlindFoldPlaying;
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
		
			public boolean isPlayingStanding() {
				return isPlayingStanding;
			}
		
			public void setPlayingStanding(boolean isPlayingStanding) {
				this.isPlayingStanding = isPlayingStanding;
			}
		
			public boolean isPlayingOneHand() {
				return isPlayingOneHand;
			}
		
			public void setPlayingOneHand(boolean isPlayingOneHand) {
				this.isPlayingOneHand = isPlayingOneHand;
			}
		
			public boolean isPlayingWithSmartphone() {
				return isPlayingWithSmartphone;
			}
		
			public void setPlayingWithSmartphone(boolean isPlayingWithSmartphone) {
				this.isPlayingWithSmartphone = isPlayingWithSmartphone;
			}
	//END OF SETTER GETTER
	
	public void writeFile()
	{
		try 
		{
			FileOutputStream fos = new FileOutputStream("Data2.bin");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			AchievementSystem as = new AchievementSystem();

			oos.writeObject(as);
			
			oos.close();

		} catch (IOException ex) 
			{
			    ex.printStackTrace();
			}
	}
	
	public boolean readFile(int type)
	{
		try 
		{
			FileInputStream fis = new FileInputStream("Data2.bin");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			AchievementSystem as = (AchievementSystem) ois.readObject();		
			if (type==1)
				return as.isBlindFoldPlaying;
			if (type==2)
				return as.isFullPerfect;
			if (type==3)
				return as.isPlayingOneHand;
			if (type==4)
				return as.isPlayingStanding;
			if (type==5)
				return as.isPlayingWithSmartphone;
			if (type==6)
				return as.isReaching10Combo;
			if (type==7)
				return as.isReaching30Combo;
			if (type==8)
				return as.isReaching50Combo;
			if (type==9)
				return as.isScore0;
			if (type==10)
				return as.isScoreRendah;
			if (type==11)
				return as.isScoreTengah;
			if (type==12)
				return as.isScoreTinggi;
			if (type==13)
				return as.isSwapping10Planet;
			if (type==14)
				return as.isSwapping15Planet;
			if (type==15)
				return as.isSwapping5Planet;
		} catch (IOException ex) 
			{
			    ex.printStackTrace();
			} 
		  catch (ClassNotFoundException e) 
			{
			e.printStackTrace();
			}

		return false;
	}
	
}
