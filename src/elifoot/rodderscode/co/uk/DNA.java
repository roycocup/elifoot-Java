package elifoot.rodderscode.co.uk;

class DNA{
	/**
	 * 
	 */
	private final Game game;
	// physical, technical, psychological, tactical, specific
	public float speed, stamina, strength;
	public float dribbling, passing, shooting, tackling;
	public float selfishness, antecipation;
	public float goalkeeping, morale;
	public DNA(Game game){
		this.game = game;
		speed = this.game.random(4,20);
		stamina = this.game.random(5, 20);
		strength = this.game.random(4, 20);
		dribbling = this.game.random(3,20);
		passing = this.game.random(3,20);
		shooting = this.game.random(3,20);
		tackling = this.game.random(3,20);
		selfishness = this.game.random(20);
		antecipation = this.game.random(20);
		goalkeeping = this.game.random(5,10);
		morale = this.game.random(5,20);
	}
	void update(){}
	void draw(){}
}