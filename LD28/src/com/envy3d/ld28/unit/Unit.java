/**
 * @author envy3d
 */

package com.envy3d.ld28.unit;

public abstract class Unit {
	public int x, y;
	public int hp;
	
	
	public abstract void attack();
	
	public abstract void defend();
	
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void die() {
		
	}
	
}
