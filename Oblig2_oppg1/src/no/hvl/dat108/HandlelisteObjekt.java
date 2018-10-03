package no.hvl.dat108;

import java.util.ArrayList;

public class HandlelisteObjekt {
	private ArrayList<String> listen;

	public HandlelisteObjekt() {
		listen = new ArrayList<>();
	}
	
	public void leggTil(String item) {
		listen.add(item);
	}
	
	public void fjernItem(String item) {
		listen.remove(item);
	}
	
	public ArrayList<String> getHandlelisteObjekt(){
		return listen;
	}
	
}
