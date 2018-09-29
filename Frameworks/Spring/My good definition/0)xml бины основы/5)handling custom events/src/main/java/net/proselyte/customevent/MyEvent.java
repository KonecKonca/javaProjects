package net.proselyte.customevent;

import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent {
    public MyEvent(Object source) {
        super(source);
    }

    @Override
    public String toString() {
        return "This is event created by me.";
    }
}

