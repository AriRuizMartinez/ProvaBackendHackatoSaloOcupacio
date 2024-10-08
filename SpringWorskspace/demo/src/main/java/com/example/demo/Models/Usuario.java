package com.example.demo.Models;

import java.util.List;
import jakarta.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	private String nom;
    private String cognoms;
    private Integer edat;

    @Column(unique = true, nullable = false)
    private String email;

    @ManyToMany
    @JoinTable(
        name = "usuario_actividad",
        joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "actividad_id")
    )
    private List<Actividad> actividades;

    public void setId(Long id) {
		this.id = id;
	}
    
    
    
    public Long getId() {
		return id;
	}

    
    
	public String getNom() {
		return nom;
	}



	public void setNom(String nombre) {
		this.nom = nombre;
	}



	public String getCognoms() {
		return cognoms;
	}



	public void setCognoms(String apellidos) {
		this.cognoms = apellidos;
	}



	public Integer getEdat() {
		return edat;
	}



	public void setEdat(Integer edad) {
		this.edat = edad;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public List<Actividad> getActividades() {
		return actividades;
	}



	public void setActividades(List<Actividad> actividades) {
		this.actividades = actividades;
	}

	

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nom=" + nom + ", cognoms=" + cognoms + ", edat=" + edat + ", email="
				+ email + "]";
	}
    
}
