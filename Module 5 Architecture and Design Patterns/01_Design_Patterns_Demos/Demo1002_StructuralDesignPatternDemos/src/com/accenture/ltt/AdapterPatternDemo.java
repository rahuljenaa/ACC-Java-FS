package com.accenture.ltt;
//Target interface expected by client
interface Charger {
 void charge();
}

//Adaptee class having different interface
class MicroUsbCharger {
 void plugMicroUsb() {
     System.out.println("Charging using Micro USB...");
 }
}

//Adapter makes Micro USB compatible with Charger interface
class UsbTypeCAdapter implements Charger {

 private MicroUsbCharger microUsb;

 public UsbTypeCAdapter(MicroUsbCharger microUsb) {
     this.microUsb = microUsb;
 }

 @Override
 public void charge() {
     // converting behavior of MicroUSB to USB-C
     microUsb.plugMicroUsb();
 }
}

public class AdapterPatternDemo {
 public static void main(String[] args) {
     MicroUsbCharger microUsb = new MicroUsbCharger();
     Charger charger = new UsbTypeCAdapter(microUsb);
     charger.charge(); //  Works even though interfaces differ
 }
}
//Benifit- No change required in old classes → plug-and-play compatibility
