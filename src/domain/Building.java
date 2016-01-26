package domain;

import java.io.Serializable;
import java.util.List;

public class Building implements Serializable{
	private char block;
	private int totalApartment;
	private List<Apartment> apartments;
	
	public Building(char block, int totalApartment, List<Apartment> apartments) {
		this.block = block;
		this.totalApartment = totalApartment;
		this.apartments = apartments;
	}
	
	public Building(){};
	
	public char getBlock() {
		return block;
	}

	public void setBlock(char block) {
		this.block = block;
	}

	public int getTotalApartment() {
		return totalApartment;
	}

	public void setTotalApartment(int totalApartment) {
		this.totalApartment = totalApartment;
	}

	public List<Apartment> getApartments() {
		return apartments;
	}

	public void setApartments(List<Apartment> apartments) {
		this.apartments = apartments;
	}

	@Override
	public String toString() {
		return "\n[block=" + block + ", totalApartment=" + totalApartment + "\napartments="+apartments+"]\n";
	}


	
	
	
}
