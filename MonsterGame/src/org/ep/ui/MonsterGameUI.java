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
		System.out.println("OO 필드에 입장하셨습니다."); // 필드 이름을 어떻게 넣어줘야 할까?
		Monster mon = monsterField.getNext();
		System.out.println("현재 몬스터 레벨 :"+mon.getLevel());
		System.out.println("현재 몬스터 체력 :"+mon.getHP());
		battleService.battle(this.player, mon, sc, monsterField);
		System.out.println("배틀이 끝났습니다.");
	}
	
}
