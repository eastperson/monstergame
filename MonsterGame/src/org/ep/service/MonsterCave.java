package org.ep.service;

import java.util.List;

import org.ep.domain.BossMonster;
import org.ep.domain.Monster;

import lombok.AllArgsConstructor;


public class MonsterCave implements MonsterField {
	
	private String name = "동굴";
	private List<Monster> list;
	private int currentMonsterLevel = 0; // 
	
	public String getName() {
		return this.name;
	}
	
	// MonsterCave 객체 생성시 몬스터 자동 생성
	public MonsterCave(List<Monster> list) {
		super();
		this.list = list;
		createMonster();
	}
	
	// 레벨 1부터 10까지 몬스터 각 1마리 생성
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
	
	// 다음 몬스터 생성
	@Override
	public Monster getNext() {
		return list.get(currentMonsterLevel++);
	}
	
	// 몬스터 동굴 빠져나갔을 때, 현재 몬스터 레벨 초기화
	@Override
	public void resetCurrentMonsterLevel() {
		this.currentMonsterLevel = 0;
	}

}
