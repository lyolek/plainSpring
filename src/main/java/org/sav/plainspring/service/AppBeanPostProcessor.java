package org.sav.plainspring.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Slf4j
@Component
public class AppBeanPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
		Iterator<String> i = configurableListableBeanFactory.getBeanNamesIterator();
		while (i.hasNext()) {
			String beanName = i.next();
			log.info("beanName {}", beanName);
		}

	}
}
