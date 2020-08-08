package org.ep.VO;

import org.ep.service.Attackable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Monster extends Unit implements Attackable {
	
	private int level;
	protected int HP;
	private int attackPoint = 10;

	
	public Monster(int level) {
		super();
		this.level = level;
		this.HP = this.level*10;
	}


	public void attack(Unit player) {
		player.setHP(player.getHP() - this.attackPoint);
	}
}
