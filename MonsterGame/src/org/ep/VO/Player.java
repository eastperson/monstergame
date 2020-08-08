package org.ep.VO;

import org.ep.service.Attackable;
import org.ep.service.Skillable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Player extends Unit implements Attackable, Skillable {
	
	private String name;
	private int attackPoint;
	private int HP;
	private int MP;
	private int AP = 300;
	
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
		this.MP += 30;
	}

	@Override
	public void skill(Unit monster) {
			monster.setHP(monster.getHP() - this.AP);
			this.MP -= 100;			
	}
	
	
	
	
}
