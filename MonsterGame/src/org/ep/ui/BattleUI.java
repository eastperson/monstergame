package org.ep.ui;

import java.util.Scanner;

import org.ep.domain.Monster;
import org.ep.domain.Player;
import org.ep.service.BattleService;
import org.ep.service.Fightable;
import org.ep.service.MonsterField;

import lombok.AllArgsConstructor;

@AllArgsConstructor

public class BattleUI {
	
	// ��ƲUI
	public void battle(Player player, Monster monster, Scanner sc, MonsterField monsterField,BattleService battleService) {
		
		//game over�� ������ ���� ����
		while(!battleService.getIsGameOver()) {
			
			System.out.println("���� ���� ���� :"+ monster.getLevel());
			System.out.println("���� ���� ü�� :"+ monster.getHP());
			System.out.println("--------------vs--------------");
			System.out.println("���� �÷��̾� ü�� :" + player.getHP());
			System.out.println("���� �÷��̾� ���� :" + player.getMP());
			System.out.println("------------------------------");
			System.out.println();
			
			// ��Ʋ�� player �ൿ ����
			battleService.choiceSelect(battleService.choice(player), player, monster);
			
			// game over �� �� ��Ʋ ����
			if(battleService.getIsGameOver()) {
				monsterField.resetCurrentMonsterLevel();
				return;
			}
			
			// monster ü���� ������ �Ǿ��� ��, 
			if(monster.getHP() <= 0) {
				System.out.println();
				System.out.println(monster.getLevel()+"������ ���Ͱ� ���������ϴ�.");
				sc.nextLine();
				
				// 10���� ���͸� ����Ʈ���� ��, ��Ʋ ����
				if(monster.getLevel() == 10) {
					System.out.println("����� �¸����Դϴ�. ���ϵ帳�ϴ�.");
					monsterField.resetCurrentMonsterLevel();
					return;
				}
				
				monster = monsterField.getNext();	// ���� ������
				System.out.println(monster.getLevel()+"������ ���Ͱ� ��Ÿ�����ϴ�.");
				System.out.println("------------------------------");
				continue;
			}
			sc.nextLine();
			System.out.println("���Ͱ� �ݰ��߽��ϴ�.");
			monster.attack((Fightable) player);
			System.out.println("������ :" + monster.getAttackPoint());
			System.out.println();
			if(player.getHP() <= 0) {
				System.out.println(player.getName()+"��(��) ���������ϴ�.");
				monsterField.resetCurrentMonsterLevel();
				return;
			}
			}
		}

}
