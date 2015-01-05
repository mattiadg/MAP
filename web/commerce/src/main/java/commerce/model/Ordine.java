package commerce.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Ordine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Temporal(TemporalType.DATE)
	private Date data;
	@OneToMany
	@JoinColumn()
	private List<RigaOrdine> righe;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<RigaOrdine> getRighe() {
		return righe;
	}

	public void setRighe(List<RigaOrdine> righe) {
		this.righe = righe;
	}
	
	public void addRigaOrdine(RigaOrdine e)
	{
		if (this.righe==null)
			this.righe=new ArrayList<RigaOrdine>();
		this.righe.add(e);
	}
}
