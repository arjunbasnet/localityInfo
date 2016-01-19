package domain;

import java.io.Serializable;

public class Room implements Serializable{
	private int roomNo;
	private Person person;
	
	public Room(int roomNo, Person person) {
		this.roomNo = roomNo;
		this.person = person;
	}
	
	public Room(){}
	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Room [roomNo=" + roomNo + ", person=" + person + "]";
	}

	
	
}
