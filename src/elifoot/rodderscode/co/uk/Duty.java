package elifoot.rodderscode.co.uk;

class Duty{
  public String[] duties = {"lb","cb","rb","lm","cm","rm","lf","cf","rf"};
  public Region region;
  public String selectedDuty;

  public Duty(String duty){
    selectedDuty = duty;
    region = new Region(selectedDuty);
  }
}