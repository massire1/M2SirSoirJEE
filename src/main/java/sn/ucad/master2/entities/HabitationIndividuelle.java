package sn.ucad.master2.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("individuelle")
public class HabitationIndividuelle extends Habitation implements Serializable {

	private static final long serialVersionUID = 1L;
	private int nbrPiece;
	private boolean piscine;

	public HabitationIndividuelle() {

	}

	public HabitationIndividuelle(String proprietaire, String adresse, Double surface, int nbrPiece, boolean piscine) {
		super();
		this.setProprietaire(proprietaire);
		this.setAdresse(adresse);
		this.setSurface(surface);
		this.nbrPiece = nbrPiece;
		this.piscine = piscine;
	}

	@Column(name = "nbrpiece", length = 10)
	public int getNbrPiece() {
		return nbrPiece;
	}

	public void setNbrPiece(int nbrPiece) {
		this.nbrPiece = nbrPiece;
	}

	@Column(name = "piscine")
	public boolean isPiscine() {
		return piscine;
	}

	public void setPiscine(boolean piscine) {
		this.piscine = piscine;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + nbrPiece;
		result = prime * result + (piscine ? 1231 : 1237);
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
		HabitationIndividuelle other = (HabitationIndividuelle) obj;
		if (nbrPiece != other.nbrPiece)
			return false;
		if (piscine != other.piscine)
			return false;
		return true;
	}

}
