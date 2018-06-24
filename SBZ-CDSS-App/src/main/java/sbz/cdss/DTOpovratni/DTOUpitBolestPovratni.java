package sbz.cdss.DTOpovratni;

import java.util.ArrayList;
import java.util.List;

public class DTOUpitBolestPovratni {
	
	List<DTOBolestPovratni> bolesti;
	List<Integer> brojSimptoma;
	
	public DTOUpitBolestPovratni() {
		this.bolesti = new ArrayList<>();
		this.brojSimptoma = new ArrayList<>();
	}

	public DTOUpitBolestPovratni(List<DTOBolestPovratni> bolesti, List<Integer> brojSimptoma) {
		super();
		this.bolesti = bolesti;
		this.brojSimptoma = brojSimptoma;
	}

	public List<DTOBolestPovratni> getBolesti() {
		return bolesti;
	}

	public void setBolesti(List<DTOBolestPovratni> bolesti) {
		this.bolesti = bolesti;
	}

	public List<Integer> getBrojSimptoma() {
		return brojSimptoma;
	}

	public void setBrojSimptoma(List<Integer> brojSimptoma) {
		this.brojSimptoma = brojSimptoma;
	}

}
