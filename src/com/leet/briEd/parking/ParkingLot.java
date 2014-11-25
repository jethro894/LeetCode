package com.leet.briEd.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
	List<Floor> floors;
	int num_of_floors;
	
	ParkingLot(int n){
		num_of_floors = n;
		floors = new ArrayList<Floor>();
	}
	
	//stored in british style, starting at 0
	public boolean addFloor(int limit_regular, int limit_disabled){
		if(floors.size() < num_of_floors){
			int id = floors.size();
			Floor new_floor = new Floor(id, limit_regular, limit_disabled);
			floors.add(new_floor);
			return true;
		}
		return false;
	}
	
	//retrieved in american style, starting at 1
	public Floor getFloor(int floor_num){
		int floor_index = floor_num -1;
		if(floor_index < 0 || floor_index >= floors.size())
			return null;
		else
			return floors.get(floor_index);
	}
	
	public int getNumberOfCars(int floor_num){
		Floor f = getFloor(floor_num);
		return f.getNumOfCars();
	}
	
	public int getTotalNumberOfSlots(int floor_num){
		Floor f = getFloor(floor_num);
		return f.getTotalNumSlots();
	}
	
	public int getTotalAvailableSlots(int floor_num){
		Floor f = getFloor(floor_num);
		return f.getTotalAvailableSlots();
	}
	
	public int getTotalAvailableRegSlots(int floor_num){
		Floor f = getFloor(floor_num);
		return f.getNumOfAvailableRegSlots();
	}
	
	public int getTotalAvailableDisSlots(int floor_num){
		Floor f = getFloor(floor_num);
		return f.getNumOfAvailableDisSlots();
	}
	
	public int park(Car c, int floor_num){
		Floor f = getFloor(floor_num);
		return f.park(c);
	}
	
	public void unpark(int floor_num, int slot_id){
		Floor f = getFloor(floor_num);
		f.unpark(slot_id);
	}
}
