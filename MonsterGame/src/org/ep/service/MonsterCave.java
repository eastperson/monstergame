package org.ep.service;

import java.util.List;

import org.ep.domain.BossMonster;
import org.ep.domain.Monster;

import lombok.AllArgsConstructor;


public class MonsterCave implements MonsterField {
	
	private String name = "����";
	private List<Monster> list;
	private int currentMonsterLevel = 0; // 
	
	public String getName() {
		return this.name;
	}
	
	// MonsterCave ��ü ������ ���� �ڵ� ����
	public MonsterCave(List<Monster> list) {
		super();
		this.list = list;
		createMonster();
	}
	
	// ���� 1���� 10���� ���� �� 1���� ����
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
	
	// ���� ���� ����
	@Override
	public Monster getNext() {
		return list.get(currentMonsterLevel++);
	}
	
	// ���� ���� ���������� ��, ���� ���� ���� �ʱ�ȭ
	@Override
	public void resetCurrentMonsterLevel() {
		this.currentMonsterLevel = 0;
	}

}
