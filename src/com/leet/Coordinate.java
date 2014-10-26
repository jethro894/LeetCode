package com.leet;

public class Coordinate {
	public int x, y;
	public Coordinate(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public boolean equals(Object o){
	    if(o == null)                return false;
	    if(!(o instanceof Coordinate)) return false;

	    Coordinate other = (Coordinate) o;
	    return this.x == other.x && this.y == other.y;
	}
	
	public int hashCode(){
	    return (int) this.x + this.y;
	  }
}
