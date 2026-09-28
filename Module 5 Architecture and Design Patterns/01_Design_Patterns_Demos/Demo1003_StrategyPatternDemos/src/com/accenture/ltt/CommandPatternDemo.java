package com.accenture.ltt;

//Command interface
interface Command {
 void execute();
}

//Receiver class performing actual action
class Light {
 void on() { System.out.println("Light ON"); }
 void off() { System.out.println("Light OFF"); }
}

//Concrete commands
class LightOnCommand implements Command {
 Light light;
 public LightOnCommand(Light light) { this.light = light; }
 public void execute() { light.on(); }
}

class LightOffCommand implements Command {
 Light light;
 public LightOffCommand(Light light) { this.light = light; }
 public void execute() { light.off(); }
}

//Invoker
class Remote {
 Command command;
 void setCommand(Command command) { this.command = command; }
 void pressButton() { command.execute(); }
}

public class CommandPatternDemo {
 public static void main(String[] args) {
     Light light = new Light();
     Remote remote = new Remote();

     remote.setCommand(new LightOnCommand(light));
     remote.pressButton(); // Light ON 

     remote.setCommand(new LightOffCommand(light));
     remote.pressButton(); // Light OFF 
 }
}
//Benefit: Undo, logging, macro commands become possible
