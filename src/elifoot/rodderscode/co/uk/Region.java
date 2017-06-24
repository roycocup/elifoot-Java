package elifoot.rodderscode.co.uk;

import processing.data.IntDict;

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