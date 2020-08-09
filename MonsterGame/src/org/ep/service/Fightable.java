package org.ep.service;

// 전투 가능한 유닛(player, monster, ...)
public interface Fightable {
	
	void attack(Fightable fightable);
	int getAttackPoint();
	int getHP();
	void setHP(int HP);
}