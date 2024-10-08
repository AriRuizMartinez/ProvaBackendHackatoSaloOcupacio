package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Models.Actividad;

public interface IActividadRepository extends JpaRepository<Actividad, Long> {
}

