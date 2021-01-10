package id.ac.its.richard017.syafiq089.afifan234.planetpang;

import java.awt.*;
import java.awt.image.ImageObserver;

public class Button {
	
	private Image image;
	private Image hoverImage;
	private Image imagePressed;
	private int posX, posY;
	private boolean hover, pressed;
	
	public Button () {}
	
	public Button(Image image, Image hoverImage, Image imagePressed, int posX, int posY) {
		this.image = image;
		this.hoverImage = hoverImage;
		this.imagePressed = imagePressed;
		this.posX = posX;
		this.posY = posY;	
	}
	
//	public void DrawButton(Graphics g, Button b) {
//		g.drawImage(b.image, b.posX, b.posY, (ImageObserver) this);
//	}
//	
//	public void HoverStatus(Graphics g, Button b) {
//		g.drawImage(b.hoverImage, b.posX, b.posY, (ImageObserver) this);
//	}
//	
//	public void ButtonPressed(Graphics g, Button b) {
//		g.drawImage(b.imagePressed, b.posX, b.posY, (ImageObserver) this);
//	}
	
	//image
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	//hoverImage
	public Image getHoverImage() {
		return hoverImage;
	}
	public void setHoverImage(Image hoverImage) {
		this.hoverImage = hoverImage;
	}
	//imagePressed
	public Image getImagePressed() {
		return imagePressed;
	}
	public void setImagePressed(Image imagePressed) {
		this.imagePressed = imagePressed;
	}
	//posX
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	//posY
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	//hover
	public boolean isHover() {
		return hover;
	}
	public void setHover(boolean hover) {
		this.hover = hover;
	}
	//pressed
	public boolean isPressed() {
		return pressed;
	}
	public void setPressed(boolean pressed) {
		this.pressed = pressed;
	}

}
