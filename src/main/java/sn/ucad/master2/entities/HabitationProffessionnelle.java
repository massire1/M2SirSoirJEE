package sn.ucad.master2.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("professionnelle")
public class HabitationProffessionnelle extends Habitation implements Serializable {

	private static final long serialVersionUID = 1L;
	private int nbrEmploye;

	public HabitationProffessionnelle() {

	}

	public HabitationProffessionnelle(String proprietaire, String adresse, Double surface, int nbrEmploye) {
		super();
		this.setProprietaire(proprietaire);
		this.setAdresse(adresse);
		this.setSurface(surface);
		this.nbrEmploye = nbrEmploye;
	}
	
	@Column(name = "nbremploye", length = 10)
	public int getNbrEmploye() {
		return nbrEmploye;
	}

	public void setNbrEmploye(int nbrEmploye) {
		this.nbrEmploye = nbrEmploye;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + nbrEmploye;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		HabitationProffessionnelle other = (HabitationProffessionnelle) obj;
		if (nbrEmploye != other.nbrEmploye)
			return false;
		return true;
	}

}
