package com.example.demo.Models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Actividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String descripció;
    private Integer capacitat_màxima;
    private Integer capacitat_actual;

    @ManyToMany(mappedBy = "actividades")
    private List<Usuario> usuariosInscritos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nombre) {
		this.nom = nombre;
	}

	public String getDescripció() {
		return descripció;
	}

	public void setDescripció(String descripcion) {
		this.descripció = descripcion;
	}

	public Integer getCapacitat_màxima() {
		return capacitat_màxima;
	}

	public void setCapacitat_màxima(Integer capacidadMaxima) {
		this.capacitat_màxima = capacidadMaxima;
	}
	
	public Integer getCapacitat_actual() {
		return usuariosInscritos.size();
	}

	public void setCapacitat_actual(Integer capacidadActual) {
		this.capacitat_actual = usuariosInscritos.size();
	}

	public void setUsuariosInscritos(List<Usuario> usuariosInscritos) {
		this.usuariosInscritos = usuariosInscritos;
	}

	@Override
	public String toString() {
		return "Actividad [id=" + id + ", nom=" + nom + ", descripció=" + descripció + ", capacitat_màxima="
				+ capacitat_màxima + "]";
	}
    
}

