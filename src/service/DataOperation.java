package service;

import domain.Apartment;
import domain.Building;
import domain.Locality;
import domain.Person;
import domain.Room;

public class DataOperation {
	private FileOperation fileService= new FileOperation();
	Locality locality=fileService.getData();
	
	public void searchTenantByName(String fullName){
		
		for(Building building: locality.getBuildings()){
			for(Apartment apartment: building.getApartments()){
				for(Room room: apartment.getRooms()){
					Person person=room.getPerson();
					
					if((fullName.split(" ")[0]).equalsIgnoreCase(person.getFirstName()) && (fullName.split(" ")[1]).equalsIgnoreCase(person.getLastName())){
						System.out.println(person.toString());
					}
				}
			}
		}
	}
}
