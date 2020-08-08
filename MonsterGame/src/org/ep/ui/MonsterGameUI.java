package org.ep.ui;

import java.util.List;
import java.util.Scanner;

import org.ep.VO.Monster;
import org.ep.VO.Player;
import org.ep.service.BattleService;
import org.ep.service.MonsterField;

public class MonsterGameUI {

	private MonsterField monsterField;
	private Player player;
	private Monster monster;
	private Scanner sc;
	private List<Monster> monsterList;
	
	
	
	
	
	public MonsterGameUI(MonsterField monsterField, Player player, Scanner sc) {
		super();
		this.monsterField = monsterField;
		this.player = player;
		this.sc = sc;
	}



	public void fieldEnter(MonsterField monsterField, BattleService battleService) {
		System.out.println("OO �ʵ忡 �����ϼ̽��ϴ�."); // �ʵ� �̸��� ��� �־���� �ұ�?
		Monster mon = monsterField.getNext();
		System.out.println("���� ���� ���� :"+mon.getLevel());
		System.out.println("���� ���� ü�� :"+mon.getHP());
		battleService.battle(this.player, mon, sc, monsterField);
		System.out.println("��Ʋ�� �������ϴ�.");
	}
	
}
