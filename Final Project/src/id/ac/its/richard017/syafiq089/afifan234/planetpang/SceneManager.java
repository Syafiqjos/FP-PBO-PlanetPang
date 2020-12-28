package id.ac.its.richard017.syafiq089.afifan234.planetpang;

import java.awt.Graphics;
import java.awt.Image;

public class SceneManager {
	private static Scene currentScene;
	
	public SceneManager() {
		
	}
	
	public static void LoadGameplayScene() {
		currentScene = new SceneGameplay();
		MainApp.mainApp.ResetUI();
	}
	
	public static void LoadMainMenuScene() {
		//currentScene = new SceneGameplay();
		MainApp.mainApp.ResetUI();
	}
	
	public static void LoadCreditsScene() {
		//currentScene = new SceneGameplay();
		MainApp.mainApp.ResetUI();
	}
	
	public static void LoadHowToPlayScene() {
		//currentScene = new SceneGameplay();
		MainApp.mainApp.ResetUI();
	}
	
	public static void LoadHighscoreScene() {
		//currentScene = new SceneGameplay();
		MainApp.mainApp.ResetUI();
	}
	
	public static Scene GetScene() {
		return currentScene;
	}
	
	public static void RefreshScene(Graphics g) {
		currentScene.drawObjects(g);
	}
}
