package org.ep.service;

// ��ų ������ ������ ����(Player ...)
public interface Skillable {
	
	public void skill(Fightable fightable);
	public int getAP();
	public int getMP();
	public int getMPAmount();
}