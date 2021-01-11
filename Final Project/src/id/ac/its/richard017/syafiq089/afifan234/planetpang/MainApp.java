package id.ac.its.richard017.syafiq089.afifan234.planetpang;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class MainApp extends JFrame {
	public static MainApp mainApp;
	
	public static SceneManager sceneManager;
	public static AssetManager assetManager;
	public static HighscoreSystem highscoreSystem;
	public static AchievementSystem achievementSystem;
	
	public MainApp() {
		mainApp = this;
		sceneManager = new SceneManager();
		highscoreSystem = new HighscoreSystem();
		achievementSystem = new AchievementSystem();
		AssetManager.LoadAssets();		
		
        initUI();
        SceneManager.LoadMainMenuScene();
        
        //RESET
        //achievementSystem.saveAchievement();
        //highscoreSystem.saveHighScore(0);
        
        achievementSystem = achievementSystem.loadAchievement();
        highscoreSystem.loadHighScore();
    }
    
    private void initUI() {
        setTitle("Planet Pang");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void ResetUI() {
    	getContentPane().removeAll();
    	repaint();
    	
    	add(sceneManager.GetScene());
        
        setResizable(false);
        pack();
        
        transferFocus();
        
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
    	System.out.println("Starting Planet Pang!..");
    	
        EventQueue.invokeLater(() -> {
            MainApp ex = new MainApp();
            ex.setVisible(true);
        });
        
        System.out.println("Exitting Planet Pang!..");
    }
}
