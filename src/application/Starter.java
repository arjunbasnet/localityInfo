package application;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import domain.Apartment;
import domain.Building;
import domain.Locality;
import domain.Room;

public class Starter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Step 1: print basic info
		//Step 2: wait for input
		//Step 3: parse input
		
		//Expect for "init" command, if => print error message
		
		//If entered init, initialize application by populating domain model 
		    //Service required => initApplication()
		
		
		
		//PROJECT => FEATURES => USER STORIES 
		printInfo();
		init();
		
	}
	public static void printInfo(){
		System.out.println("This program generates locality buildings and tenant info with random data \nYou can also search information based on tenant name, phone number."
				+ "\nFirst type 'init' command to initalize the program, this will populate random data");
	}
	
	public static void init(){
		String localityName="Siltakuja 2";
		int totalBuildings=5;
		char[] alphabets="ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray(); //for buildings block name
		
		Locality locality=new Locality();
		locality.setAddress(localityName);;
		locality.setId(01);
		
		List<Building> buildings = new ArrayList<Building>();
		List<Apartment> apartments=new ArrayList<Apartment>();
		List<Room> rooms=new ArrayList<Room>();
		
		for(int i=0; i<totalBuildings; i++)
		{
			Building building=new Building();
			building.setBlock(alphabets[i]);
			int apartmentCount=ThreadLocalRandom.current().nextInt(15, 50); //generates random apartment number
			building.setTotalApartment(apartmentCount);
			
			for(int j=1; j<=apartmentCount;j++)
			{
				Apartment apartment=new Apartment();
				apartment.setApartmentAdds(localityName + " "+ alphabets[i]+" "+ j);
				int roomCount=ThreadLocalRandom.current().nextInt(1, 3+1); //generates random room number
				apartment.setTotalRoom(roomCount);
				
				for(int k=1;k<=roomCount;k++)
				{
					
					Room room=new Room();
					room.setRoomNo(k);
					rooms.add(room);
				}
				apartment.setRooms(rooms);
				apartments.add(apartment);
				
			}
			building.setApartments(apartments);
			buildings.add(building);
		}
		locality.setBuildings(buildings);
		System.out.print(locality.toString());
	}
}
