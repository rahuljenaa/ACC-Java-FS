package com.accenture.ltt.threading.sample;

/**
 * @author ishika.agarwal
 * Sender - Receiver problem
 * The Sender is supposed to send a data packet to the Receiver
 * The Receiver cannot process the data packet until the Sender is finished sending it
 * Similarly, the Sender mustn’t attempt to send another packet unless the Receiver has already processed the previous packet
 *
 */
public class SenderReceiverTest {
	public static void main(String[] args) {
	    Data data = new Data();
	    
	    //create object of Sender and Receiver class and start both the threads
	    Sender sender = new Sender(data);
	    Receiver receiver = new Receiver(data);
	     
	    sender.start();
	    receiver.start();
	}
}
// Sender class to send the data
class Sender extends Thread {
	private Data data;

	// standard constructors
	public Sender(Data data) {
		this.data = data;
	}

	public void run() {
		String packets[] = { "First packet", "Second packet", "Third packet", "Fourth packet", "End" };

		for (String packet : packets) {
			//call send method of Data class to send the data
			data.send(packet);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
//Receiver class to receive the data
class Receiver extends Thread {
    private Data load;

    //standard constructors
    public Receiver(Data load) {
		this.load = load;
	}    
  
    public void run() {
    	//call receive method of Data class to receive the data
    	String receivedMessage = load.receive();
    	//terminating condition : stop when the received message is 'End'
    	while(!"End".equals(receivedMessage)){             
            System.out.println(receivedMessage);
          //call receive method of Data class to receive the data
            receivedMessage = load.receive();
        }
    }
}
class Data {
	private String packet;

	// True if receiver should wait
	// False if sender should wait
	private boolean transfer = true;

	// method to transfer the data
	public synchronized void send(String packet) {
		while (!transfer) {
			try {
				//call wait so that receiver can receive the message before sending another message
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();

			}
		}
		transfer = false;

		this.packet = packet;
		
		//notifying receiver that message is sent .. please receive it...
		notifyAll();
	}

	//method to receive the data
	public synchronized String receive() {
		while (transfer) {
			try {
				//call wait so that sender can send the next message
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		transfer = true;
		
		//notify the sender that receiver has processed the data .. send another one
		notifyAll();
		return packet;
	}
}