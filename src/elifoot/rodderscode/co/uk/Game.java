package elifoot.rodderscode.co.uk;

import processing.core.PApplet;

public class Game extends PApplet{

	public static void main(String[] args) {
		PApplet.main("elifoot.rodderscode.co.uk.Game");
	}
	
	Player player;
	Ball ball;
	Team team;
	Pitch pitch;

	// MAIN METHODS
	public void settings() {
		size(800, 600);
	}
	
	public void setup(){
	  
	  player = new Player(this);
	  ball = new Ball(this);
	  team = new Team();
	  pitch = new Pitch(this);
	  println(player);
	}

	public void draw(){
	  background(0);
	  updateAll();
	  drawAll();
	}

	public void keyPressed() {
	  if (key == 'm' || key == 'M'){
	    ball.toggleFollowMouse();
	  }
	}


	// OWN METHODS
	void drawAll(){
	  pitch.draw();
	  ball.draw();
	  team.draw();
	  player.draw();
	}

	void updateAll(){
	  team.update();
	  player.update();
	  ball.update();
	  pitch.update();
	}

}
