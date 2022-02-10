/* This program defines the state and simple behavior of droids */

public class Droid {
  String name;
  int batteryLevel = 100;

  public Droid(String name) {
    this.name = name;
  }

  public String toString() {
    String res = "Hello, I\'m the droid: " + name;
    return res;
  }

  public void performTask(String task) {
    System.out.println(name + " is performing the task: " + task);
    batteryLevel -= 10;
  }

  public void energyReport() {
    System.out.println("The battery level of " + name + " is " + batteryLevel);
  }

  public void energyTransfer(Droid d) {
    int tmp = d.batteryLevel;
    d.batteryLevel = this.batteryLevel;
    this.batteryLevel = tmp;
  }

  public static void main(String[] args) {
    Droid codey = new Droid("Codey");
    Droid mac = new Droid("Mac");
    
    // performing tasks
    codey.performTask("painting");
    codey.performTask("dancing");
    mac.performTask("writing");

    // checking battery levels of each droid
    codey.energyReport();
    mac.energyReport();

    // exchanging batter levels
    codey.energyTransfer(mac);

    // re-checking battery levels of each droid
    codey.energyReport();
    mac.energyReport();

  }
}
