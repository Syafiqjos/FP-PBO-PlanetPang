package id.ac.its.richard017.syafiq089.afifan234.planetpang;

import java.awt.Graphics;
import java.awt.Image;

public class SceneManager {
	private Scene currentScene;
	
	public SceneManager() {
		
	}
	
	public void LoadGameplayScene() {
		currentScene = new SceneGameplay();
		MainApp.mainApp.ResetUI();
	}
	
	public void LoadMainMenuScene() {
		currentScene = new MainMenuScene();
		MainApp.mainApp.ResetUI();
	}
	
	public void LoadCreditsScene() {
		//currentScene = new SceneGameplay();
		MainApp.mainApp.ResetUI();
	}
	
	public void LoadHowToPlayScene() {
		//currentScene = new SceneGameplay();
		MainApp.mainApp.ResetUI();
	}
	
	public void LoadHighscoreScene() {
		//currentScene = new SceneGameplay();
		MainApp.mainApp.ResetUI();
	}
	
	public Scene GetScene() {
		return currentScene;
	}
	
	public void RefreshScene(Graphics g) {
		currentScene.drawObjects(g);
	}
}
