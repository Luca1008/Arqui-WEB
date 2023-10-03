package com.example.demo.repository;

import com.example.demo.model.Carrera;

import jakarta.persistence.EntityManager;
import com.example.demo.model.Carrera;

public class CarreraRepositoryImpl implements CarreraRepository {
	private EntityManager em;

	public CarreraRepositoryImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public void insertarCarrera (Carrera c) {
		this.em.getTransaction().begin();
		if (!em.contains(c)) {
			em.persist(c);
		} else {
			System.out.println("ya existe");
		}
		this.em.getTransaction().commit();
		
	}
}
