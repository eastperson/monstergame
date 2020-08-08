package org.ep.domain;

public class BossMonster extends Monster {
	
	public BossMonster(int level) {
		super(level);
		this.HP = super.HP * 5;
	}

}
