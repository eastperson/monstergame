package org.ep.domain;

import org.ep.service.Fightable;

public interface Player {
	
	public int getAttackPoint();
	public int getHP();
	public int getMP();
	public int getAP();
	public void setHP(int HP);
	public String getName();
	public void attack(Fightable fightable);
	public void skill(Fightable fightable);
	public int getMPAmount();

}