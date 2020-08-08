package org.ep.VO;

import org.ep.service.Attackable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Player extends Unit implements Attackable {
	
	private String name;
	private int attackPoint;
	private int HP;
	private int exPoint;
	
	public Player() {
		
	}
	
	public Player(String name, int attackPoint) {
		this.name = name;
		this.attackPoint = attackPoint;
		this.HP = 100 - attackPoint;
	}
	
	@Override
	public void attack(Unit monster) {
		monster.setHP(monster.getHP() - this.attackPoint);
	}
	
	
	
	
}
