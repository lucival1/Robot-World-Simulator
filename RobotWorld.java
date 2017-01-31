import processing.core.PApplet;

public class RobotWorld extends PApplet{
  Robot[] robot;

  public static void main(String[] args){
    PApplet.main("RobotWorld"); //create the windows (world) where objects live
  }

  public void settings(){
    size(1000, 500);
    robot = new Robot[3];
    robot[0] = new Robot(this, color(255, 0, 0), 100, 100, 3, 3f, 90);
    robot[1] = new Robot(this, color(0, 255, 0), 200, 200, 5, 4f, 0);
    robot[2] = new Robot(this, color(0, 0, 255), 200, 300, 5, 5f, 270);
  }

  public void setup(){
  }

  public void draw(){
    background(255);
    robot[0].randomWalk();
    robot[1].patrol();
    robot[2].stroll();
  }
}
