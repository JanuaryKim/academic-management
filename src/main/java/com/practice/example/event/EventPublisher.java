package com.practice.example.event;


import com.practice.example.event.student.StudentRegisterEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class EventPublisher <T> { // 이벤트 발행 역할 클래스,범용적 Publisher 로써 사용하기 위해 제네릭 타입 추가

    private final ApplicationEventPublisher eventPublisher;

    public void publish(T event, BusinessEvent.EventCode eventCode) { // event = 이벤트 주체 객체, eventCode = 이벤트 코드
        log.debug(eventCode.message);
        BusinessEvent createdEvent = createEvent(event, eventCode);
        eventPublisher.publishEvent(createdEvent);

    }

    private BusinessEvent createEvent(T event, BusinessEvent.EventCode eventCode) {

        switch (eventCode)
        {
            case MEMBER_REGISTER:
                return new StudentRegisterEvent(this, eventCode, event);
            default:
                return null;
        }
    }
}
