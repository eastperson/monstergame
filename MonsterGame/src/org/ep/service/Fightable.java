package org.ep.service;

// ���� ������ ����(player, monster, ...)
public interface Fightable {
	
	void attack(Fightable fightable);
	int getAttackPoint();
	int getHP();
	void setHP(int HP);
}
