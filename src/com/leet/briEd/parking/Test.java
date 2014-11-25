package com.leet.briEd.parking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ParkingLot p = new ParkingLot(7);
		for(int i = 0; i < 7; i++){
			p.addFloor(80, 20);
		}
		
		int fn = 7;
		List<Car> cars  = new ArrayList<Car>();
		for(int i = 0; i < 10; i++){
			Car c = new Car(i, true);
			cars.add(c);
		}
		
		for(int i = 0; i < 83; i++){
			Car c = new Car(i, false);
			cars.add(c);
		}
		
		List<Integer> slot_ids = new ArrayList<Integer>();
		for(Car c : cars){
			int id = p.park(c, fn);
			if(id != -1)
				slot_ids.add(id);
		}
		
		System.out.println("available reg: " + p.getTotalAvailableRegSlots(fn));
		System.out.println("available dis: " + p.getTotalAvailableDisSlots(fn));
		
		Collections.shuffle(slot_ids);
		
		for(int i = 0; i < 28; i++){
			System.out.println("Unparking: " + slot_ids.get(i));
			p.unpark(fn, slot_ids.get(i));
		}
		slot_ids = slot_ids.subList(28, slot_ids.size());
		
		System.out.println("available reg: " + p.getTotalAvailableRegSlots(fn));
		System.out.println("available dis: " + p.getTotalAvailableDisSlots(fn));
		
		cars  = new ArrayList<Car>();
		for(int i = 0; i < 4; i++){
			Car c = new Car(i, true);
			cars.add(c);
		}
		
		for(int i = 0; i < 20; i++){
			Car c = new Car(i, false);
			cars.add(c);
		}
		
		for(Car c : cars){
			int id = p.park(c, fn);
			if(id != -1)
				slot_ids.add(id);
		}
		
		System.out.println("available reg: " + p.getTotalAvailableRegSlots(fn));
		System.out.println("available dis: " + p.getTotalAvailableDisSlots(fn));
		
		Collections.shuffle(slot_ids);
		
		for(int i = 0; i < 28; i++){
			System.out.println("Unparking: " + slot_ids.get(i));
			p.unpark(fn, slot_ids.get(i));
		}
		slot_ids = slot_ids.subList(28, slot_ids.size());
		
		System.out.println("available reg: " + p.getTotalAvailableRegSlots(fn));
		System.out.println("available dis: " + p.getTotalAvailableDisSlots(fn));
		
		cars  = new ArrayList<Car>();
		for(int i = 0; i < 12; i++){
			Car c = new Car(i, true);
			cars.add(c);
		}
		
		for(int i = 0; i < 30; i++){
			Car c = new Car(i, false);
			cars.add(c);
		}
		
		for(Car c : cars){
			int id = p.park(c, fn);
			if(id != -1)
				slot_ids.add(id);
		}
		
		System.out.println("total cars: " + p.getNumberOfCars(fn));
		System.out.println("available reg: " + p.getTotalAvailableRegSlots(fn));
		System.out.println("available dis: " + p.getTotalAvailableDisSlots(fn));
	}

}
