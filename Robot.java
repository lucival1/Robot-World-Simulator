import processing.core.PApplet;

public class Robot{

  //variables
  private int colour;
  private int direction;
  private float xPos1;
  private float yPos1;
  private float xPos2;
  private float yPos2;
  private float xPos3;
  private float yPos3;
  private float xCenter;
  private float yCenter;
  private float position;
  private float pointA;
  private float pointB;
  private float speed;
  int rotation;
  int rectSize = 30;
  private boolean stop = true;
  private PApplet screen;

  //Constructor
  public Robot(PApplet s, int colour,float xPosition, float yPosition, float size, float speed, int rotation){
    direction = 1;
    screen = s;
    this.colour = colour;
    this.speed = speed;
    this.robotSize(size, xPosition, yPosition);
    this.pointA = xPos2 - xPos1;
    this.xCenter = xPosition + pointA;
    this.yCenter = yPosition + pointA;
    this.rotation = rotation;
  }

  //Methods

  //Defines robot size and position
  private void robotSize(float size, float xCenter, float yCenter){
    if (size > 5){      
      this.xPos1 = 10 * 5 + xCenter;
      this.yPos1 = 10 * 5 + yCenter;
      this.xPos2 = 20 * 5 + xCenter;
      this.yPos2 = 15 * 5 + yCenter;
      this.xPos3 = 10 * 5 + xCenter;
      this.yPos3 = 20 * 5 + yCenter;
    } else if(size < 1){        
        this.xPos1 = 10 * 1 + xCenter;
        this.yPos1 = 10 * 1 + yCenter;
        this.xPos2 = 20 * 1 + xCenter;
        this.yPos2 = 15 * 1 + yCenter;
        this.xPos3 = 10 * 1 + xCenter;
        this.yPos3 = 20 * 1 + yCenter;
    } else{
        this.xPos1 = (10 * size) + xCenter;
        this.yPos1 = (10 * size) + yCenter;
        this.xPos2 = (20 * size) + xCenter;
        this.yPos2 = (15 * size) + yCenter;
        this.xPos3 = (10 * size) + xCenter;
        this.yPos3 = (20 * size) + yCenter;
    }
  }

  //Calculates triangle center for rotate method
  private void triangleCenter(){
    this.xCenter = ((xPos1 + xPos2 + xPos3)/3);
    this.yCenter = ((yPos1 + yPos2 + yPos3)/3);
  }

  //Rotates matrix
  private void rotateRobot(int rotation){
    screen.pushMatrix();
    screen.translate(xCenter, yCenter);
    screen.rotate(screen.radians((int)rotation));
    screen.fill(colour);
    screen.triangle(-pointA/2, -pointA/2, pointA/2, 0, -pointA/2, pointA/2);
    screen.fill(26);
    screen.ellipse(pointA/2 + 5, 0, 10, 10);
    screen.popMatrix();
	screen.rectMode(screen.CENTER);
	if(stop){
		screen.fill(200, 0, 0);
		screen.rect(930, 30, rectSize, rectSize, 9);
	} else{
		screen.fill(0, 180, 0);
		screen.rect(970, 30, rectSize, rectSize, 9);
	}
  }

  //Used to display robot on screen
  public void display(){
    rotateRobot(rotation);
  }
  
  //All moviments starts on this method, defining the direction and rotate axis
  public void patrol(){
	  if (stop){
		  this.display();
	  } else{
		  switch(direction){
			  case 1:
				this.rotation = 0;
				this.triangleCenter();
				this.rotateRobot(rotation);
				this.moveForward();
				break;
			  case 2:
				this.rotation = 90;
				this.triangleCenter();
				this.rotateRobot(rotation);
				this.moveDown();
				break;
			  case 3:
				this.rotation = 180;
				this.triangleCenter();
				this.rotateRobot(rotation);
				this.moveBackward();
				break;
			  case 4:
				this.rotation = 270;
				this.triangleCenter();
				this.rotateRobot(rotation);
				this.moveUp();
				break;
			  case 5:
				this.triangleCenter();
				this.rotateRobot(rotation);
				this.moveBackB();
				break;
			  case 6:
				this.triangleCenter();
				this.rotateRobot(rotation);
				this.moveBackU();
				break;
			  case 7:
				this.triangleCenter();
				this.rotateRobot(rotation);
				this.moveBackF();
				break;
			  case 8:
				this.triangleCenter();
				this.rotateRobot(rotation);
				this.moveBackD();
				break;
			}
		}
	}

  //Call the keyPressed method for keyboard remote control
  public void stroll(){
    keyPressed();
  }

  private void keyPressed(){
    if ((screen.keyPressed == true) && (screen.key == 'd')) {
      this.direction = 1;
      if(this.xPos2 + (pointA/2) <= screen.width){
        this.patrol();
      } else{
          this.display();
      }
    } else if ((screen.keyPressed == true) && (screen.key == 's')) {
        this.direction = 2;
      if(this.xPos3 + (pointA/2) <= screen.width){
        this.patrol();
      } else{
          this.display();
      }
    }else if ((screen.keyPressed == true) && (screen.key == 'a')) {
      this.direction = 3;
      if(this.xPos3 - (pointA/2) <= screen.width){
        this.patrol();
      } else{
          this.display();
      }
    } else if ((screen.keyPressed == true) && (screen.key == 'w')) {
        this.direction = 4;
      if(this.xPos1 - (pointA/2) <= screen.width){
        this.patrol();
      } else{
          this.display();
      }
    } else {
        this.display();
    }    
  }

  //random walk method
  public void randomWalk(){
    if(direction == 1 && this.xPos2 + (pointA/2) >= screen.width){
		this.direction = 5;
		this.patrol();
    } else if(direction == 2 && this.yPos3 + (pointA/2) >= screen.height){
        this.direction = 6;
        this.patrol();
    } else if(direction == 3 && this.xPos3 - (pointA/2) <= 0){
        this.direction = 7;
        this.patrol();
    } else if(direction == 4 && this.yPos1 - (pointA/2) <= 30){
        this.direction = 8;
        this.patrol();
    } else{
        this.patrol();
    }
  }

  //Movement methods
  private void moveForward(){
    if(this.xPos2 + (pointA/2) >= screen.width){
      this.direction++;
    } else {
        this.xPos1 = this.xPos1 + this.speed;
        this.xPos2 = this.xPos2 + this.speed;
        this.xPos3 = this.xPos3 + this.speed;
    }
  }

  private void moveBackward(){
    if(this.xPos3 - (pointA/2) <= 0){
      this.direction++;
    } else {
        this.xPos1 = this.xPos1 - this.speed;
        this.xPos2 = this.xPos2 - this.speed;
        this.xPos3 = this.xPos3 - this.speed;
    }
  }

  private void moveDown(){
    if(this.yPos3 + (pointA/2) >= screen.height){
      this.direction++;
    } else {
        this.yPos1 = this.yPos1 + this.speed;
        this.yPos2 = this.yPos2 + this.speed;
        this.yPos3 = this.yPos3 + this.speed;
    }
  }

  private void moveUp(){
    if(this.yPos1 - (pointA/2) <= 30){
      this.direction = 1;
    } else{
        this.yPos1 = this.yPos1 - this.speed;
        this.yPos2 = this.yPos2 - this.speed;
        this.yPos3 = this.yPos3 - this.speed;
    }
  }
    private void moveBackB(){
		if(this.xPos1 <= screen.width - (3 * pointA)){
			this.direction = (int)screen.random(1, 5);
		} else{
			this.xPos1 = this.xPos1 - this.speed;
			this.xPos2 = this.xPos2 - this.speed;
			this.xPos3 = this.xPos3 - this.speed;
		}
	}
	
	private void moveBackU(){
		if(this.yPos3 <= screen.height - (3 * pointA)){
			this.direction = (int)screen.random(1, 5);
			} else {
				this.yPos1 = this.yPos1 - this.speed;
				this.yPos2 = this.yPos2 - this.speed;
				this.yPos3 = this.yPos3 - this.speed;
			}
	}
	
	private void moveBackF(){
		if(this.xPos1 >= (3 * pointA)){
			this.direction = (int)screen.random(1, 5);
			} else {
				this.xPos1 = this.xPos1 + this.speed;
				this.xPos2 = this.xPos2 + this.speed;
				this.xPos3 = this.xPos3 + this.speed;
			}
	}
	
	private void moveBackD(){
	if(this.yPos3 >= (3 * pointA)){
      this.direction = (int)screen.random(1, 5);
    } else {
        this.yPos1 = this.yPos1 + this.speed;
        this.yPos2 = this.yPos2 + this.speed;
        this.yPos3 = this.yPos3 + this.speed;
    }
  }

  public void stopCheck(){
	  if ((screen.keyPressed == true) && (screen.key == 'i')){
		  this.stop = true;
	  } else if((screen.keyPressed == true) && (screen.key == 'p')){
		  this.stop = false;
	  }
  }
}
