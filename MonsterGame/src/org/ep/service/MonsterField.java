package org.ep.service;

import org.ep.domain.Monster;

// ���� �ʵ�(cave, forest, space ...)
public interface MonsterField {
	
	public void createMonster();
	public Monster getNext();
	public void resetCurrentMonsterLevel();
	public String getName();
}
