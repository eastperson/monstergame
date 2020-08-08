package org.ep.ui;

import java.util.Scanner;

import org.ep.VO.Player;
import org.ep.service.BattleService;
import org.ep.service.MonsterField;

public class MainUI {
	
	private MonsterField monsterField;
	private Player player;
	private MonsterGameUI monsterGameUI;
	private PlayerUI playerUI;
	private Scanner sc;
	private BattleService battleService;
	
	
	
	public MainUI(MonsterField monsterField, Player player, MonsterGameUI monsterGameUI,
			PlayerUI playerUI, Scanner sc, BattleService battleService) {
		super();
		this.monsterField = monsterField;
		this.player = player;
		this.monsterGameUI = monsterGameUI;
		this.playerUI = playerUI;
		this.sc = sc;
		this.battleService = battleService;
	}




	public void gameStart() {
		System.out.println("계속 진행하실거면 Enter!");
		sc.nextLine();
		monsterGameUI.fieldEnter(monsterField, battleService);
	}

}
