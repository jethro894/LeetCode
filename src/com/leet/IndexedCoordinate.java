package com.leet;

public class IndexedCoordinate {
	public int x, y, i, j;
	public IndexedCoordinate(int x, int y, int i, int j){
		this.x = x;
		this.y = y;
		this.i = i;
		this.j = j;
	}
	
	public boolean equals(Object o){
	    if(o == null)                return false;
	    if(!(o instanceof IndexedCoordinate)) return false;

	    IndexedCoordinate other = (IndexedCoordinate) o;
	    return this.x == other.x && this.y == other.y;
	}
	
	public int hashCode(){
	    return (int) this.x + this.y;
	  }
}
