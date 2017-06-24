package elifoot.rodderscode.co.uk;

import processing.core.PVector;
import processing.core.PApplet;
import processing.data.IntDict;

// CLASSES
class Player{
	private final Game game;
	DNA _dna;
	int size = 15;
	public PVector acc;
	public PVector vel;
	public PVector pos;
	public int teeNumber;
	public Duty duty;
	public Region region;

	public Player(Game g){
		game = g;
		_dna = new DNA(game);
		acc = new PVector();
		vel = new PVector();
		pos = new PVector();
		teeNumber = (int) game.random(1, 33);
		duty = new Duty("lb");
		region = duty.region;
	}


	public void draw(){
		game.fill(255);
		game.ellipse(pos.x, pos.y, size, size);
	};

	public void update(){
		applyForce(vecToBall());
		vel.add(acc);
		pos.add(vel);
		acc.mult(0);
	};

	void applyForce(PVector force){
		acc.add(force);
	}

	PVector vecToBall(){
		return pos.sub(game.ball.pos).normalize().mult(-1);
	}

}