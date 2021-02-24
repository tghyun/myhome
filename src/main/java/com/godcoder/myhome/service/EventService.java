package com.godcoder.myhome.service;

import com.godcoder.myhome.model.Event;
import com.godcoder.myhome.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    public Event save(Event event){
        return eventRepository.save(event);
    }
}
