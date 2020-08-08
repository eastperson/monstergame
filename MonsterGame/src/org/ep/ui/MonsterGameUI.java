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
	
	//���� �ʵ� ����
	public void fieldEnter(MonsterField monsterField, BattleUI battleUI) {
		System.out.println("----------"+ monsterField.getName()+"�� �����ϼ̽��ϴ�.----------");
		System.out.println();
		Monster mon = monsterField.getNext();
		battleUI.battle(this.player, mon, sc, monsterField,battleService);
		System.out.println("��Ʋ�� �������ϴ�.");
	}
	
}
