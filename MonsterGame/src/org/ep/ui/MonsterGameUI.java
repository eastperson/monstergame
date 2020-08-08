package org.ep.ui;
import java.util.Scanner;

import org.ep.domain.Monster;
import org.ep.domain.Player;
import org.ep.service.BattleService;
import org.ep.service.MonsterField;

public class MonsterGameUI {

	private Player player;
	private Scanner sc;
	private BattleService battleService;
	
	public MonsterGameUI(Player player, Scanner sc, BattleService battleService) {
		super();
		this.player = player;
		this.sc = sc;
		this.battleService = battleService;
	}
	
	//몬스터 필드 입장
	public void fieldEnter(MonsterField monsterField, BattleUI battleUI) {
		System.out.println("----------"+ monsterField.getName()+"에 입장하셨습니다.----------");
		System.out.println();
		Monster mon = monsterField.getNext();
		battleUI.battle(this.player, mon, sc, monsterField,battleService);
		System.out.println("배틀이 끝났습니다.");
	}
	
}
