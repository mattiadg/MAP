package jpa.model.ids;

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

}
