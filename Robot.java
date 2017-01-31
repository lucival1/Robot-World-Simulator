import processing.core.PApplet;

public class Robot{

  private int colour;
  private int direction;
  private float xPos1;
  private float yPos1;
  private float xPos2;
  private float yPos2;
  private float xPos3;
  private float yPos3;
  private float size;
  private float speed;
  private PApplet screen;

  public Robot(PApplet s, int colour, float xPos1, float yPos1,  float xPos2, float yPos2, float xPos3, float yPos3,float speed){
    direction = 1;
    screen = s;
    this.colour = colour;
    this.xPos1 = xPos1;
    this.yPos1 = yPos1;
    this.xPos2 = xPos2;
    this.yPos2 = yPos2;
    this.xPos3 = xPos3;
    this.yPos3 = yPos3;
    this.speed = speed;
    size = xPos2 - xPos1;
  }

  public void display(){
    screen.fill(colour);
    screen.triangle(this.xPos1, this.yPos1, this.xPos2, this.yPos2, this.xPos3, this.yPos3);
    screen.fill(26);
    screen.ellipse(xPos2+5, yPos2, 10, 10);
  }

  public void stroll(){
    keyPressed();
  }

  private void keyPressed(){
    if ((screen.keyPressed == true) && (screen.key == 'd')) {
      this.direction = 1;
      this.patrol();
    }else if ((screen.keyPressed == true) && (screen.key == 's')) {
      this.direction = 2;
      this.patrol();
    }else if ((screen.keyPressed == true) && (screen.key == 'a')) {
      this.direction = 3;
      this.patrol();
    }else if ((screen.keyPressed == true) && (screen.key == 'w')) {
      this.direction = 4;
      this.patrol();
    }else {
      display();
    }
    
  }

  public void bounce(){
    if(direction == 4){
      this.direction = 1;
    }else if(direction == 2){
      this.direction++;
    }else if(direction == 1){
      this.patrol();
    }else{
      this.patrol();
    }
  }

  public void patrol(){
    switch(direction){
      case 1:
        screen.pushMatrix();
        screen.translate(xPos1, yPos1);
        rotateRobot(0);
        screen.popMatrix();
        this.moveForward();
        break;
      case 2:    
        screen.pushMatrix();
        screen.translate(xPos1+50, yPos1);
        rotateRobot(90);
        screen.popMatrix();
        this.moveDown();
        break;
      case 3:
        screen.pushMatrix();
        screen.translate(xPos2, yPos3);
        rotateRobot(180);
        screen.popMatrix();
        this.moveBackward();
        break;
      case 4:
        screen.pushMatrix();
        screen.translate(xPos3, yPos3);
        rotateRobot(270);
        screen.popMatrix();
        this.moveUp();
        break;
    }
  }

  private void rotateRobot(int angle){;
    screen.rotate(screen.radians((int)angle));
    screen.fill(colour);
    screen.triangle(0, 0, 50, 25, 0, 50);
    screen.fill(26);
    screen.ellipse(55, 25, 10, 10);
  }

  private void moveForward(){
    if(this.xPos2+5 >= screen.width){
      this.direction++;
    }else {
      this.xPos1 = this.xPos1 + this.speed;
      this.xPos2 = this.xPos2 + this.speed;
      this.xPos3 = this.xPos3 + this.speed;
    }
  }

  private void moveBackward(){
    if(this.xPos3-5 <= 0){
      this.direction++;
    }else {
      this.xPos1 = this.xPos1 - this.speed;
      this.xPos2 = this.xPos2 - this.speed;
      this.xPos3 = this.xPos3 - this.speed;
    }
  }

  private void moveDown(){
    if(this.yPos3+5 >= screen.height){
      this.direction++;
    }else {
      this.yPos1 = this.yPos1 + this.speed;
      this.yPos2 = this.yPos2 + this.speed;
      this.yPos3 = this.yPos3 + this.speed;
    }
  }

  private void moveUp(){
    if(this.yPos1-5 <= 0){
      this.direction = 1;
    }else {
      this.yPos1 = this.yPos1 - this.speed;
      this.yPos2 = this.yPos2 - this.speed;
      this.yPos3 = this.yPos3 - this.speed;
    }
  }

  public void stop(){
      display();
  }

}
