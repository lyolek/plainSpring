package org.sav.plainspring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AppListener implements ApplicationListener {
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		log.info("event:{}", event.toString());
	}
}
