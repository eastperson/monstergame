package org.ep.ui;

import java.util.Scanner;
import org.ep.service.MonsterField;

public class MainUI {
	
	private MonsterField monsterField;
	private MonsterGameUI monsterGameUI;
	private Scanner sc;
	private BattleUI battleUI;
	
	public MainUI(MonsterField monsterField, MonsterGameUI monsterGameUI,
					Scanner sc, BattleUI battleUI) {
		super();
		this.monsterField = monsterField;
		this.monsterGameUI = monsterGameUI;
		this.sc = sc;
		this.battleUI = battleUI;
	}
	
	// �����
	public boolean restart() {
		System.out.println("�ٽ� �����Ͻðڽ��ϱ�? (Y/N)");
		String answer = sc.nextLine();
		return answer.equalsIgnoreCase("Y");
	}
	
	// ���ӽ���
	public void gameStart() {
		System.out.println("��� �����ϽǰŸ� Enter!");
		sc.nextLine();
		monsterGameUI.fieldEnter(monsterField, battleUI);
		if(restart()) {
			gameStart();
		} else {
			System.out.println("������ ����Ǿ����ϴ�.");
			return;
		}
	}

}
