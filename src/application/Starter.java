package application;

import java.io.Console;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.text.WordUtils;

import domain.Apartment;
import domain.Building;
import domain.Locality;
import domain.Person;
import domain.Room;
import service.FileOperation;

public class Starter {
	
	private FileOperation fileService= new FileOperation();

	public static void main(String[] args) throws IOException {
		
		printInfo();
		System.out.println("Enter Command: ");
		Scanner scanner = new Scanner(System.in);
		String command = scanner.nextLine();
		if("init".equalsIgnoreCase(command)){
			new Starter().init();
		}
		else{ 
			System.out.println("Please Enter Correct Command!!!\n 1. Enter 'init' for intalization.\n2.Enter 'search' for searching infromation.");
		}
		
	}
	public static void printInfo(){
		System.out.println("This program generates locality buildings and tenant info with random data \nYou can also search information based on tenant name, phone number."
				+ "\nFirst type 'init' command to initalize the program, this will populate random data");
	}
	
	public void init() throws IOException {
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
				apartment.setApartmentNo(j);
				//System.out.println("i inside second for loop "+i);
				apartment.setApartmentAdds(localityName + " "+ alphabets[i]+" "+ j);
				int roomCount=ThreadLocalRandom.current().nextInt(1, 3+1); //generates random room number
				apartment.setTotalRoom(roomCount);
				
				for(int k=1;k<=roomCount;k++)
				{
					
					Room room=new Room();
					Person person=new Person();
					
					int FnameLength=ThreadLocalRandom.current().nextInt(5, 13);
					int LnameLength=ThreadLocalRandom.current().nextInt(5, 13);
					String firstName=WordUtils.capitalizeFully(RandomStringUtils.randomAlphabetic(FnameLength));
					String lastName=WordUtils.capitalizeFully(RandomStringUtils.randomAlphabetic(LnameLength));
					long phoneNumber = (long) Math.floor(Math.random() * 9000000000L) + 1000000000L;
					String adds=localityName + " "+ alphabets[i]+" "+ j;
					
					person.setFirstName(firstName);
					person.setLastName(lastName);
					person.setPhone(phoneNumber);
					person.setAdds(adds);
					
					room.setRoomNo(k);
					room.setPerson(person);
					rooms.add(room);
				}
				apartment.setRooms(rooms);
				//System.out.print(apartment.toString());
				rooms=new ArrayList<Room>();
				apartments.add(apartment);
				
			}
			building.setApartments(apartments);
			//System.out.print(building.toString());
			apartments=new ArrayList<Apartment>();
			buildings.add(building);
		}
		locality.setBuildings(buildings);
		fileService.saveData(locality);
		//System.out.print(locality.toString());
	}
}
