package org.example.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AtmEventHandler {
    @EventListener
    public void handleAtmEvent(AtmEvent event){
        System.out.println("Event:::: "+event.getMessage());
    }
}
