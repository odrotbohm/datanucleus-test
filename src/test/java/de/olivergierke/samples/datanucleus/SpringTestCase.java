/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.olivergierke.samples.datanucleus;

import javax.persistence.EntityManagerFactory;

import org.datanucleus.api.jpa.PersistenceProviderImpl;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

/**
 * Test case to bootstrap JPA through Spring API.
 * 
 * @author Oliver Gierke
 */
public class SpringTestCase {

	@Configuration
	@EnableLoadTimeWeaving
	static class Config {

		@Bean
		public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

			LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
			factoryBean.setPersistenceProviderClass(PersistenceProviderImpl.class);
			factoryBean.setPersistenceUnitName("default");
			return factoryBean;
		}
	}

	@Test
	public void bootstrapJpa() {

		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		EntityManagerFactory factory = context.getBean(EntityManagerFactory.class);

		SimpleTestCase.executeTestWith(factory);

		context.close();
	}
}
