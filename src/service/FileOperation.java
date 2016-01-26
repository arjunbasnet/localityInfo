package service;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import domain.Building;
import domain.Locality;
import domain.Person;
import domain.Room;
import domain.Apartment;

public class FileOperation {
	
	public void saveData(Object obj){
		
		try{
			File file=new File("localityInfo.txt");
			FileWriter fw=new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw= new BufferedWriter(fw);
			bw.write(obj.toString());
			bw.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void saveWithCustomFormat(Locality locality){
		final String VAL_SEPARATOR=",";
		try{
			File file=new File("localityData.txt");
			FileWriter fw=new FileWriter(file.getAbsolutePath());
			BufferedWriter bw=new BufferedWriter(fw);
			
			String localityInfo=locality.getAddress()+VAL_SEPARATOR+locality.getId();
			bw.write(localityInfo);
			bw.newLine();
			
			for(Building building: locality.getBuildings()){
				
				String buildingInfo=""+building.getBlock()+VAL_SEPARATOR+building.getTotalApartment()+"";
				bw.write(buildingInfo);
				bw.newLine();
				
				for(Apartment apartment: building.getApartments()){
					
					String apartmentInfo=""+apartment.getApartmentNo()+VAL_SEPARATOR+apartment.getApartmentAdds()+VAL_SEPARATOR+apartment.getTotalRoom()+"";
					bw.write(apartmentInfo);
					bw.newLine();
					
					for(Room room: apartment.getRooms()){
						Person person=room.getPerson();
						String roomInfo=""+room.getRoomNo()+VAL_SEPARATOR+person.getFirstName()+VAL_SEPARATOR+""
								+ person.getLastName()+VAL_SEPARATOR+person.getAdds()+VAL_SEPARATOR+person.getPhone()+"";
						bw.write(roomInfo);
						bw.newLine();
					}
				}
			}
			
			bw.flush();
			bw.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public Locality getData(){
		BufferedReader br=null;
		Locality locality=new Locality();
		
		try{
			
			FileReader fr=new FileReader("localityData.txt");
			br=new BufferedReader(fr);
			
			String localityInfo=br.readLine();
			String address=localityInfo.split(",")[0];
			int id=Integer.parseInt(localityInfo.split(",")[1]);
			//System.out.println(address+id);
			
			locality.setAddress(address);
			locality.setId(id);
			
			List<Building> buildings = new ArrayList<Building>();
			List<Apartment> apartments=new ArrayList<Apartment>();
			List<Room> rooms=new ArrayList<Room>();
			
			for(int i=0;i<5;i++){
				String buildingInfo=br.readLine();
				Building building=new Building();
				
				char block=buildingInfo.charAt(0);
				int totalApartments=Integer.parseInt(buildingInfo.split(",")[1]);
				building.setBlock(block);
				building.setTotalApartment(totalApartments);
				
				for(int j=0;j<totalApartments;j++){
					String apartmentInfo=br.readLine();
					Apartment apartment=new Apartment();
					
					int apartmentNo=Integer.parseInt(apartmentInfo.split(",")[0]);
					String apartmentAdds=apartmentInfo.split(",")[1];
					int totalRoom=Integer.parseInt(apartmentInfo.split(",")[2]);
					apartment.setApartmentNo(apartmentNo);
					apartment.setApartmentAdds(apartmentAdds);
					apartment.setTotalRoom(totalRoom);
					
					for(int k=0;k<totalRoom;k++){
						String roomInfo=br.readLine();
						Room room=new Room();
						Person person=new Person();
						
						int roomNo=Integer.parseInt(roomInfo.split(",")[0]);
						String firstName=roomInfo.split(",")[1];
						String lastName=roomInfo.split(",")[2];
						String adds=roomInfo.split(",")[3];
						long phone=Long.parseLong(roomInfo.split(",")[4]);
						person.setFirstName(firstName);
						person.setLastName(lastName);
						person.setAdds(adds);
						person.setPhone(phone);
						
						room.setRoomNo(roomNo);
						room.setPerson(person);
						rooms.add(room);
					}
					apartments.add(apartment);
					apartment.setRooms(rooms);
					rooms=new ArrayList<Room>();
					
				}
				buildings.add(building);
				building.setApartments(apartments);
				apartments=new ArrayList<Apartment>();
			}
			locality.setBuildings(buildings);
			
		}
		catch(IOException e){
			e.printStackTrace();
		}finally {
			try {
				if (br != null)br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return locality;
	}
}
