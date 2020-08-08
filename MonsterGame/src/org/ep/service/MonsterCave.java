package org.ep.service;

import java.util.List;

import org.ep.VO.BossMonster;
import org.ep.VO.Monster;

import lombok.AllArgsConstructor;


public class MonsterCave implements MonsterField {
	
	public static String name = "µ¿±¼";
	private List<Monster> list;
	private int currentMonsterLevel = 0;
	
	
	
	public MonsterCave(List<Monster> list) {
		super();
		this.list = list;
		createMonster();
	}

	@Override
	public void createMonster() {
		for(int i = 1; i <= 10; i++) {
			if(i % 4 == 0) {
				this.list.add(new BossMonster(i));
			} else {
				this.list.add(new Monster(i));
			}
		}
	}

	@Override
	public Monster getNext() {
		return list.get(currentMonsterLevel++);
	}

}
