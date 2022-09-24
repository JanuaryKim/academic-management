package com.practice.example.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 *
 * 모든 이벤트 객체들이 상속 받는 부모 이벤트 객체체 *
 */
@Getter
public class BusinessEvent <T> extends ApplicationEvent { //발생된 이벤트 정보를 담는 클래스

    private EventCode eventCode;
    private T event;

    public BusinessEvent(Object source, EventCode eventCode, T event) {
        super(source);
        this.eventCode = eventCode;
        this.event = event;
    }


    public enum EventCode {

        MEMBER_REGISTER(101, "Member Register");

        int code;
        String message;


        EventCode(int code, String message) {
            this.code = code;
            this.message = message;
        }
    }
}
