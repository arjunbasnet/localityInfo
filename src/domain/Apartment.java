package domain;

import java.util.List;

public class Apartment {
	private int apartmentNo;
	private String apartmentAdds;
	private int totalRoom;
	private List<Room> rooms;
	
	public Apartment(int apartmentNo, String apartmentAdds, int totalRoom, List<Room> rooms) {
		this.apartmentNo = apartmentNo;
		this.apartmentAdds = apartmentAdds;
		this.totalRoom = totalRoom;
		this.rooms = rooms;
	}
	
	public Apartment(){}
	
	public int getApartmentNo() {
		return apartmentNo;
	}

	public void setApartmentNo(int apartmentNo) {
		this.apartmentNo = apartmentNo;
	}

	public String getApartmentAdds() {
		return apartmentAdds;
	}

	public void setApartmentAdds(String apartmentAdds) {
		this.apartmentAdds = apartmentAdds;
	}

	public int getTotalRoom() {
		return totalRoom;
	}

	public void setTotalRoom(int totalRoom) {
		this.totalRoom = totalRoom;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	@Override
	public String toString() {
		return "Apartment [apartmentNo=" + apartmentNo + ", apartmentAdds=" + apartmentAdds + ", totalRoom=" + totalRoom
				+ ", rooms=" + rooms + "]";
	}
	
	
}
