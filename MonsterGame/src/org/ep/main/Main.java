package org.ep.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.ep.VO.Monster;
import org.ep.VO.Player;
import org.ep.VO.Player;
import org.ep.service.BattleService;
import org.ep.service.MonsterCave;
import org.ep.service.MonsterField;
import org.ep.ui.MainUI;
import org.ep.ui.MonsterGameUI;
import org.ep.ui.PlayerUI;

public class Main {

	public static void main(String[] args) {
		List<Monster> monsterList = new ArrayList<>();
		MonsterField monsterField = new MonsterCave(monsterList);
		Scanner sc = new Scanner(System.in);
		PlayerUI playerUI = new PlayerUI(sc);
		Player player = playerUI.createPlayer();
		MonsterGameUI monsterGameUI = new MonsterGameUI(monsterField, player, sc);
		
		BattleService battleService = new BattleService();

		MainUI ui = new MainUI(monsterField, player, monsterGameUI, playerUI, sc, battleService);
		
		ui.gameStart();
		
	}

}
