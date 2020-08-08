package org.ep.service;

// 스킬 구현이 가능한 유닛(Player ...)
public interface Skillable {
	
	public void skill(Fightable fightable);
	public int getAP();
	public int getMP();
	public int getMPAmount();
}
