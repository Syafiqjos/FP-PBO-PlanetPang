package id.ac.its.richard017.syafiq089.afifan234.planetpang;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class MainApp extends JFrame {
	
	public SceneManager sceneManager;
	public AssetManager assetManager;
	
	public MainApp() {
		sceneManager = new SceneManager();
		AssetManager.LoadAssets();		
		
        initUI();
        sceneManager.LoadGameplayScene();
        ResetUI();
    }
    
    private void initUI() {
        setTitle("Planet Pang");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void ResetUI() {
    	getContentPane().removeAll();
    	repaint();
    	
    	add(sceneManager.GetScene());
        
        setResizable(false);
        pack();
        
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
