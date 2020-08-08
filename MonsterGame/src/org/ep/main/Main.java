package org.ep.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.ep.domain.Monster;
import org.ep.domain.Player;
import org.ep.service.BattleService;
import org.ep.service.MonsterCave;
import org.ep.service.MonsterField;
import org.ep.ui.BattleUI;
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
		BattleService battleService = new BattleService(sc);
		BattleUI battleUI = new BattleUI();
		MonsterGameUI monsterGameUI = new MonsterGameUI(player, sc, battleService);

		MainUI ui = new MainUI(monsterField, monsterGameUI, sc, battleUI);
		
		ui.gameStart();
		
	}

}
