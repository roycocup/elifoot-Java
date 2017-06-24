package elifoot.rodderscode.co.uk;

import processing.core.PVector;

class Ball {
	/**
	 * 
	 */
	private final Game game;

	boolean _followMouse;

	public int radius;
	public PVector pos;
	public float size;

	public Ball(Game game){
		this.game = game;
		size = 10;
		pos = new PVector(this.game.width / 2, this.game.height / 2);
	}
	void update(){
		if (_followMouse){
			pos = new PVector(this.game.mouseX, this.game.mouseY);
		}
	}

	void draw(){
		this.game.noStroke();
		this.game.fill(255);
		this.game.ellipse(pos.x,pos.y, size, size);
	}

	public void toggleFollowMouse(){
		if (_followMouse){
			_followMouse = false;
		} else {
			_followMouse = true;
		}
	}

}