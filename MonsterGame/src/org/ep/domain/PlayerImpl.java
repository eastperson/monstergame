package org.ep.domain;

import org.ep.service.Fightable;
import org.ep.service.Skillable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class PlayerImpl extends Unit implements Player, Fightable, Skillable {
	
	private String name;
	private int attackPoint;
	private int HP;
	private int MP;
	private int AP = 300;
	private int MPAmount = 100;
	
	public PlayerImpl() {
		
	}
	
	public PlayerImpl(String name, int attackPoint) {
		this.name = name;
		this.attackPoint = attackPoint;
		this.HP = 100 - attackPoint;
	}
	
	@Override
	public void attack(Fightable fightable) {
		fightable.setHP(fightable.getHP() - this.attackPoint);
		this.MP += 30;
	}

	@Override
	public void skill(Fightable fightable) {
			System.out.println("석양이 진다..");
			fightable.setHP(fightable.getHP() - this.AP);
			this.MP -= 100;			
	}
	
	
	
	
}
