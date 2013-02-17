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

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

/**
 * Test case to bootstrap JPA throug plain JPA APIs.
 * 
 * @author Oliver Gierke
 */
public class SimpleTestCase {

	@Test
	public void bootstrapJpa() {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
		executeTestWith(factory);
	}

	public static void executeTestWith(EntityManagerFactory emf) {

		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.persist(new Person());
		} finally {
			tx.commit();
		}
	}
}
