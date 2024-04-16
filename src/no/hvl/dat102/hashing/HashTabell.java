package no.hvl.dat102.hashing;

import java.util.Arrays;

public class HashTabell {
	private String[] tabell;
	private int storrelse;
	
	public HashTabell(int storrelse) {
		this.storrelse = storrelse;
		tabell = new String[storrelse];
	}
	
	// Hash-funksjon
	private int hashFunksjon(String nokkel) {
		return Integer.parseInt(nokkel.substring(nokkel.length() -1));
	}
	// Setter inn et element i tabellen ved hjelp av lineær probing
	public void settInn(String nokkel) {
		int index = hashFunksjon(nokkel);
		while(tabell[index] != null) {
			index = (index + 1) % storrelse;
		}
		tabell[index] = nokkel;
	}
	
	// Skriver ut innholdet i tabellen
    public void printTabell() {
        System.out.println(Arrays.toString(tabell));
    }
    
    public static void main(String[] args) {
    	HashTabell tabell = new HashTabell(20);
    	String[] bilnummer = {"EL65431", "TA14374", "ZX87181", "EL47007", "VV50000", "UV14544", "EL32944"};
    	
    	for(String element : bilnummer) {
    		tabell.settInn(element);
    	}
    	
    	tabell.printTabell();
    }
}
