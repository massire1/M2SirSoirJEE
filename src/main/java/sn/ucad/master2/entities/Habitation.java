package sn.ucad.master2.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "HABITATION")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "champhabitation")
public abstract class Habitation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long codeHabitation;
	
	@NotBlank(message = "*Veuillez remplir le proprietaire")
	private String proprietaire;
	
	@NotEmpty(message = "*Veuillez remplir ladresse")
	private String adresse;
	
	@NotNull()
	@Positive()
	private double surface;

	public Habitation() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getCodeHabitation() {
		return codeHabitation;
	}

	public void setCodeHabitation(Long codeHabitation) {
		this.codeHabitation = codeHabitation;
	}

	@Column(name = "proprietaire")
	public String getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}

	@Column(name = "adresse")
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Column(name = "surface")
	public double getSurface() {
		return surface;
	}

	public void setSurface(double surface) {
		this.surface = surface;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((codeHabitation == null) ? 0 : codeHabitation.hashCode());
		result = prime * result + ((proprietaire == null) ? 0 : proprietaire.hashCode());
		long temp;
		temp = Double.doubleToLongBits(surface);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Habitation other = (Habitation) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (codeHabitation == null) {
			if (other.codeHabitation != null)
				return false;
		} else if (!codeHabitation.equals(other.codeHabitation))
			return false;
		if (proprietaire == null) {
			if (other.proprietaire != null)
				return false;
		} else if (!proprietaire.equals(other.proprietaire))
			return false;
		if (Double.doubleToLongBits(surface) != Double.doubleToLongBits(other.surface))
			return false;
		return true;
	}

}
