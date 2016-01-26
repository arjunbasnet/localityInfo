package domain;

import java.io.Serializable;
import java.util.List;

public class Locality implements Serializable{

	private String address;
	private int id;
	private List<Building> buildings;
	
	public Locality(String address, int id, List<Building> buildings) {
		this.address = address;
		this.id = id;
		this.buildings = buildings;
	}
	public Locality(){};
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Building> getBuildings() {
		return buildings;
	}

	public void setBuildings(List<Building> buildings) {
		this.buildings = buildings;
	}
	
	@Override
	public String toString() {
		return "Locality [address=" + address + ", id=" + id + "\nbuildings=" + buildings + "]";
	}
	

	
	
}
