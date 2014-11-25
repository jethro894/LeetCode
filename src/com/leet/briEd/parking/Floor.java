package com.leet.briEd.parking;

import java.util.ArrayList;
import java.util.List;

public class Floor {
	int id;
	
	List<Slot> used_regular_slots;
	List<Slot> empty_regular_slots;
	
	List<Slot> used_handicapped_slots;
	List<Slot> empty_handicapped_slots;
	
	int num_of_reg_slots;
	int num_of_dis_slots;
	
	Floor(int i, int r, int d){
		id = i;
		num_of_reg_slots = r;
		num_of_dis_slots = d;
		
		used_regular_slots = new ArrayList<Slot>();
		used_handicapped_slots = new ArrayList<Slot>();
		
		empty_regular_slots = new ArrayList<Slot>();
		for(int j = 0; j < r; j++){
			Slot regular = new Slot(j, false);
			empty_regular_slots.add(regular);
		}
		
		empty_handicapped_slots = new ArrayList<Slot>();
		for(int j = 0; j < d; j++){
			Slot disabled = new Slot(r + j, true);
			empty_handicapped_slots.add(disabled);
		}
		
	}
	
	public int getNumOfCars(){
		return used_regular_slots.size() + used_handicapped_slots.size();
	}
	
	public int getTotalNumSlots(){
		return num_of_reg_slots + num_of_dis_slots;
	}
	
	public int getTotalAvailableSlots(){
		return getNumOfAvailableRegSlots()+getNumOfAvailableDisSlots();
	}
	
	public int getNumOfAvailableRegSlots(){
		return empty_regular_slots.size();
	}
	
	public int getNumOfAvailableDisSlots(){
		return empty_handicapped_slots.size();
	}
	
	public int park(Car c){
		if(c.handicapped){
			if(getNumOfAvailableDisSlots() == 0){
				System.out.println("No available disabled slots! Please check other floors.");
				return -1;
			}
			else{
				Slot slot = empty_handicapped_slots.remove(0);
				used_handicapped_slots.add(slot);
				return slot.id;
			}
		}else{
			if(getNumOfAvailableRegSlots() == 0){
				System.out.println("No available regular slots! Please check other floors.");
				return -1;
			}
			else{
				Slot slot = empty_regular_slots.remove(0);
				used_regular_slots.add(slot);
				return slot.id;
			}
		}
	}
		
	public void unpark(int slot_id){
		if(getNumOfCars() > 0){
			Slot target = null;
			if(slot_id >= num_of_reg_slots){
				for(Slot s : used_handicapped_slots){
					if(s.id == slot_id){
						target = s;
						break;
					}
				}
				if(target == null){
					System.out.println("There is no car on this slot.");
					return;
				}
				used_handicapped_slots.remove(target);
				empty_handicapped_slots.add(target);
			}else{
				for(Slot s : used_regular_slots){
					if(s.id == slot_id){
						target = s;
						break;
					}
				}
				if(target == null){
					System.out.println("There is no car on this slot.");
					return;
				}
				used_regular_slots.remove(target);
				empty_regular_slots.add(target);
			}
		}
		
	}
}
