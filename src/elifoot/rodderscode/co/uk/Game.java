package elifoot.rodderscode.co.uk;

import processing.core.PApplet;
import processing.core.PVector;
import processing.data.IntDict;

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
	  
	  player = new Player();
	  ball = new Ball();
	  team = new Team();
	  pitch = new Pitch();
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
	
	// CLASSES
	class Player{
		  DNA _dna;
		  int size = 15;
		  public PVector acc;
		  public PVector vel;
		  public PVector pos;
		  public int teeNumber;
		  public Duty duty;
		  public Region region;

		  public Player(){
		    _dna = new DNA();
		    acc = new PVector();
		    vel = new PVector();
		    pos = new PVector();
		    teeNumber = (int) random(1,33);
		    duty = new Duty("lb");
		    region = duty.region;
		  }


		  public void draw(){
		    fill(255);
		    ellipse(pos.x, pos.y, size, size);
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
		    return pos.sub(ball.pos).normalize().mult(-1);
		  }

		}

	class DNA{
		// physical, technical, psychological, tactical, specific
		public float speed, stamina, strength;
		public float dribbling, passing, shooting, tackling;
		public float selfishness, antecipation;
		public float goalkeeping, morale;
		public DNA(){
			speed = random(4,20);
			stamina = random(5, 20);
			strength = random(4, 20);
			dribbling = random(3,20);
			passing = random(3,20);
			shooting = random(3,20);
			tackling = random(3,20);
			selfishness = random(20);
			antecipation = random(20);
			goalkeeping = random(5,10);
			morale = random(5,20);
		}
		void update(){}
		void draw(){}
	}

	class Team {
		void update(){}
		void draw(){}
	}

	class Pitch{
		int x, y, w, h;
		int margin = 50;
		int innerMargin = 20;
		public IntDict boundaries;
		public Region[] regions;

		public Pitch(){
			x = y = margin;
			w = width - y - margin;
			h = height - x - margin;
			setBoundaries();
		}

		void update(){

		}

		void draw(){
			drawGreen();
			drawBoundaries();
		}

		void drawGreen(){
			fill(1,128,30); // green
			rect(x, y, w, h);
		}

		void setBoundaries(){
			boundaries = new IntDict();
			boundaries.set("x", x + innerMargin);
			boundaries.set("y", y + innerMargin);
			boundaries.set("w", w - (innerMargin*2));
			boundaries.set("h", h - (innerMargin*2));
		}

		void drawBoundaries(){
			noFill();
			stroke(255);
			strokeWeight(3);
			rect(boundaries.get("x"), boundaries.get("y"), boundaries.get("w"), boundaries.get("h"));
		}

		// splits the whole pitch in regions
		void updateRegions(){

		}

		// for debug purposes
		void drawRegions(){

		}
	}

	class Ball {
		boolean _followMouse;

		public int radius;
		public PVector pos;
		public float size;

		public Ball(){
			size = 10;
			pos = new PVector(width / 2, height / 2);
		}
		void update(){
			if (_followMouse){
				pos = new PVector(mouseX, mouseY);
			}
		}

		void draw(){
			noStroke();
			fill(255);
			ellipse(pos.x,pos.y, size, size);
		}

		public void toggleFollowMouse(){
			if (_followMouse){
				_followMouse = false;
			} else {
				_followMouse = true;
			}
		}

	}

	class Score{
		void update(){}
		void draw(){}
	}

	class Time{
		void update(){}
		void draw(){}
	}

	class Region{
		public String[] regions = {"lb","cb","rb","lm","cm","rm","lf","cf","rf"};
		public String selectedRegion;
		public IntDict boundaries;

		public Region(String selectedRegion){
			boundaries = new IntDict();

			switch(selectedRegion){
			case "lb":
				boundaries.set("x", 120);
				boundaries.set("y", 120);
				boundaries.set("w", 120);
				boundaries.set("h", 120);
				break;
			case "cb":
				break;
			case "rb":
				break;
			case "lm":
				break;
			case "cm":
				break;
			case "rm":
				break;
			case "lf":
				break;
			case "cf":
				break;
			case "rf":
				break;
			}

		}


	}

	class Duty{
		  public String[] duties = {"lb","cb","rb","lm","cm","rm","lf","cf","rf"};
		  public Region region;
		  public String selectedDuty;

		  public Duty(String duty){
		    selectedDuty = duty;
		    region = new Region(selectedDuty);
		  }
		}

}
