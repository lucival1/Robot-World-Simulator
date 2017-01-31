# Robot-World-Simulator

  This is a project developed with the Processing-3.2.3 toolkit.
  This instruction sheet regards how to use the RobotWorld Simulator.
  RobotWorld simulator is a enviroment where you can simulate a serie of robots.
  Each robot can realize a serie of moviments around the lab. They must not leave the screen.
  Robots are definied as triangles with a point denoting the front.

  - file RobotWorld.java -> file where main is located, all the objects must be created here, following the class requirements
  - file Robot.java -> Class where all the robot's content are kept (behaviours, variables, moviments, etc)
  - file Interface.java -> Class meant to store a GUI.

To compile my code: 
  - Unzip the file RobotWorld.rar
  - Copy the Processing "core.jar" file to the same fold where you want to run this project
  - Open the cmd.exe
  - Type the path to the fold where the file RobotWorld.java is located. 
      Example: cd c:\Users\Admin...
  - Compile the following files: RobotWorld.java, Robot.java, Interface.java. 
      Use the command: [javac -cp ".;core.jar" RobotWorld.java], without brackets.
      Repeat the same for Robot.java.

To run my code:
  - After compiling the code just need to run the app.
  - To run the app use the command: java -cp ".;core.jar" RobotWorld
