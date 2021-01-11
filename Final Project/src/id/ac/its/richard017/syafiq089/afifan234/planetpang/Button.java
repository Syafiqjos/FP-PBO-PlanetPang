package id.ac.its.richard017.syafiq089.afifan234.planetpang;

import java.awt.*;
import java.awt.image.ImageObserver;

public class Button {
	
	private Image image;
	private Image hoverImage;
	private Image imagePressed;
	private Image currentImage;
	private int posX, posY;
	
	public Button(Image image, Image hoverImage, Image imagePressed, int posX, int posY) {
		this.image = image;
		this.hoverImage = hoverImage;
		this.imagePressed = imagePressed;
		this.setCurrentImage(this.image);
		this.posX = posX;
		this.posY = posY;	
	}

	//Current Image
	public Image getCurrentImage() {
		return currentImage;
	}
	public void setCurrentImage(Image currentImage) {
		this.currentImage = currentImage;
	}
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

}
