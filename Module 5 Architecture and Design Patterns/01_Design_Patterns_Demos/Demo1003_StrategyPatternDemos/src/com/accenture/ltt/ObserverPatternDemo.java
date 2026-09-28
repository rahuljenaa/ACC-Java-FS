package com.accenture.ltt;

import java.util.ArrayList;
import java.util.List;

// Observer (Subscriber)
interface Subscriber {
    void notify(String video);
}

// Concrete Observers
class User implements Subscriber {
    private String name;

    public User(String name) { this.name = name; }

    public void notify(String video) {
        System.out.println(name + " notified about: " + video);
    }
}

// Subject (Publisher)
class YouTubeChannel {
    private List<Subscriber> subscribers = new ArrayList<>();

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void uploadVideo(String title) {
        System.out.println("New Video Uploaded: " + title);
        subscribers.forEach(sub -> sub.notify(title)); // Notify all 
    }
}

public class ObserverPatternDemo {
    public static void main(String[] args) {
        YouTubeChannel channel = new YouTubeChannel();

        channel.subscribe(new User("Alice"));
        channel.subscribe(new User("Bob"));

        channel.uploadVideo("Strategy Pattern in Java");
    }
}
//Benefit: Automatic notifications → loose coupling
