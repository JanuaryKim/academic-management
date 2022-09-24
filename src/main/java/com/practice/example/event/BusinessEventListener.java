package com.practice.example.event;


import com.practice.example.event.student.StudentRegisterEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class BusinessEventListener { //모든 BusinessEvent를 처리하는 범용적 리스너 클래스

    @Async //해당 메소드를 비동기로 처리
    @EventListener
    public void handleEvent(StudentRegisterEvent event) {
        log.info("이메일 전송");
    }
}
