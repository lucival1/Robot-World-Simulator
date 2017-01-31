import processing.core.PApplet;

public class RobotWorld extends PApplet{
  Robot[] robot;

  public static void main(String[] args){
    PApplet.main("RobotWorld"); //create the windows (world) where objects live
  }

  public void settings(){
    size(1000, 500);
  }

  public void setup(){
    robot = new Robot[3];
    robot[0] = new Robot(this, color(255, 0, 0), (float)(width/10), (float)(height/10),
	 (float)(3*width/20), (float)(3*height/20),
	 (float)(width/10), (float)(height/5), 5f);

    robot[1] = new Robot(this, color(0, 255, 0), (float)(width/10), (float)(3*height/10),
	 (float)(3*width/20), (float)(21*height/60),
	 (float)(width/10), (float)(2*height/5), 5f);

    robot[2] = new Robot(this, color(0, 0, 255), (float)(width/10), (float)(height/2),
	 (float)(3*width/20), (float)(11*height/20),
	 (float)(width/10), (float)(6*height/10), 5f);
  }

  public void draw(){
    background(255);
      robot[0].bounce();
      robot[1].patrol();
      robot[2].stroll();
  }
}
