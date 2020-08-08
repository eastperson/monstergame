package org.ep.domain;

import org.ep.service.Fightable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Monster extends Unit implements Fightable {
	
	private int level;
	protected int HP;
	private int attackPoint = 10;

	
	public Monster(int level) {
		super();
		this.level = level;
		this.HP = this.level*10;
	}


	public void attack(Fightable fightable) {
		fightable.setHP(fightable.getHP() - this.attackPoint);
	}
}
