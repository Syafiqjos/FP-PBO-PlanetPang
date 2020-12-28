package id.ac.its.richard017.syafiq089.afifan234.planetpang;

import java.awt.Graphics;

public class SceneManager {
	private Scene currentScene;
	
	public SceneManager() {
		
	}
	
	public void LoadGameplayScene() {
		currentScene = new SceneGameplay();
	}
	
	public void LoadMainMenuScene() {
		//currentScene = new SceneGameplay();
	}
	
	public void LoadCreditsScene() {
		//currentScene = new SceneGameplay();
	}
	
	public void LoadHowToPlayScene() {
		//currentScene = new SceneGameplay();
	}
	
	public void LoadHighscoreScene() {
		//currentScene = new SceneGameplay();
	}
	
	public Scene GetScene() {
		return currentScene;
	}
	
	public void RefreshScene(Graphics g) {
		currentScene.drawObjects(g);
	}
}
