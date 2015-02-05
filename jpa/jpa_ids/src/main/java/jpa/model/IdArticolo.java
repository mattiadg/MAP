package jpa.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class IdArticolo implements Serializable {
	private int codiceProduttore;
	private int codiceProdotto;

	public int getCodiceProduttore() {
		return codiceProduttore;
	}

	public void setCodiceProduttore(int codiceProduttore) {
		this.codiceProduttore = codiceProduttore;
	}

	public int getCodiceProdotto() {
		return codiceProdotto;
	}

	public void setCodiceProdotto(int codiceProdotto) {
		this.codiceProdotto = codiceProdotto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codiceProdotto;
		result = prime * result + codiceProduttore;
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
		IdArticolo other = (IdArticolo) obj;
		if (codiceProdotto != other.codiceProdotto)
			return false;
		if (codiceProduttore != other.codiceProduttore)
			return false;
		return true;
	}

}
