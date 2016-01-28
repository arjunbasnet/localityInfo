package service;


import java.util.ArrayList;
import java.util.List;

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
	
	public void searchTenantByLnameFname(String name){
		int i=1;
		
		System.out.println("List of person matching your search");
		for(Building building: locality.getBuildings()){
			for(Apartment apartment: building.getApartments()){
				for(Room room: apartment.getRooms()){
					Person person=room.getPerson();
					
					if(name.equalsIgnoreCase(person.getFirstName())||name.equalsIgnoreCase(person.getLastName())){
						System.out.println(""+i+". "+person.getFirstName()+" "+person.getLastName()+" "+person.getAdds()+" "+person.getPhone());
						i++;
					}
				}
			}
		}
	}
	
	public void searchTenantByPhone(long phone){
		
		for(Building building: locality.getBuildings()){
			for(Apartment apartment: building.getApartments()){
				for(Room room: apartment.getRooms()){
					Person person=room.getPerson();
					
					if(phone==person.getPhone()){
						System.out.println(person.toString());
					}
				}
			}
		}
	}
	
	public void localityOverview(){
		int personCount=0,buildingCount=0,i=0,j=0,k=0;
		List<Integer> apartmentCountList=new ArrayList<Integer>();
		List<Character> blockList=new ArrayList<Character>();
		for(Building building: locality.getBuildings()){
			for(Apartment apartment: building.getApartments()){
				for(Room room: apartment.getRooms()){
					Person person=room.getPerson();
					
					if(person!=null){
						personCount++;
					}
				}
			}
			blockList.add(building.getBlock());
			apartmentCountList.add(building.getTotalApartment());
			i++;
			buildingCount++;
		}
		
		System.out.println("Locality Address: "+locality.getAddress());
		System.out.println("Total buildings: "+buildingCount+" Total People: "+personCount+"\nBuildings Detail");
		System.out.print("Block\t\t");
		for(j=0;j<i;j++){
			System.out.print("\t"+blockList.get(j));
		}
		System.out.print("\nTotal Apartments");
		for(k=0;k<i;k++){
			System.out.print("\t"+apartmentCountList.get(k));
		}
	}
	
	public void buildingOverview(char block){
		
		for(Building building: locality.getBuildings()){
			if(block==building.getBlock()){
				System.out.println("Block: "+block+"  Total Apartments: "+building.getTotalApartment());
				System.out.println("List with person last name and apartment Number");
				System.out.println("Last Name\t\tApartment No.");
				for(Apartment apartment: building.getApartments()){
					for(Room room: apartment.getRooms()){
						Person person=room.getPerson();
						System.out.println(""+person.getLastName()+"\t\t\t"+apartment.getApartmentNo());
					}
				}
			}
		}
	}
}
