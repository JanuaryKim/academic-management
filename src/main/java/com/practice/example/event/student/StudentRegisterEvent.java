package com.practice.example.event.student;

import com.practice.example.event.BusinessEvent;

public class StudentRegisterEvent extends BusinessEvent {

    public StudentRegisterEvent(Object source, EventCode eventCode, Object event) {
        super(source, eventCode, event);
    }
}
