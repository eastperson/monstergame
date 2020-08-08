package org.ep.service;

import org.ep.domain.Monster;

// 몬스터 필드(cave, forest, space ...)
public interface MonsterField {
	
	public void createMonster();
	public Monster getNext();
	public void resetCurrentMonsterLevel();
	public String getName();
}
