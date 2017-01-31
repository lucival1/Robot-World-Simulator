import processing.core.PApplet;
import processing.core.PFont;

public class Interface{
	
	//Variables
	PApplet screen;
	PFont f;
	int textColour;
	int rectSize = 30;

  //Interface constructor
  public Interface(PApplet screen, PFont f){
	  this.f = f;
	  this.screen = screen;
	  this.textColour = 20;
  }
  
  //Methods
  public void printInterface(){
	  //headline creation
	  screen.textFont(this.f, 30);
	  screen.fill(textColour);
	  screen.text("Robot World Simulator", 100, 33);
  }
}
