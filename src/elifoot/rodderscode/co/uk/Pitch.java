package elifoot.rodderscode.co.uk;

import processing.data.IntDict;

class Pitch{
	/**
	 * 
	 */
	private final Game game;
	int x, y, w, h;
	int margin = 50;
	int innerMargin = 20;
	public IntDict boundaries;
	public Region[] regions;

	public Pitch(Game game){
		this.game = game;
		x = y = margin;
		w = this.game.width - y - margin;
		h = this.game.height - x - margin;
		setBoundaries();
	}

	void update(){

	}

	void draw(){
		drawGreen();
		drawBoundaries();
	}

	void drawGreen(){
		this.game.fill(1,128,30); // green
		this.game.rect(x, y, w, h);
	}

	void setBoundaries(){
		boundaries = new IntDict();
		boundaries.set("x", x + innerMargin);
		boundaries.set("y", y + innerMargin);
		boundaries.set("w", w - (innerMargin*2));
		boundaries.set("h", h - (innerMargin*2));
	}

	void drawBoundaries(){
		this.game.noFill();
		this.game.stroke(255);
		this.game.strokeWeight(3);
		this.game.rect(boundaries.get("x"), boundaries.get("y"), boundaries.get("w"), boundaries.get("h"));
	}

	// splits the whole pitch in regions
	void updateRegions(){

	}

	// for debug purposes
	void drawRegions(){

	}
}