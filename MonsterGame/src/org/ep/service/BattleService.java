package org.ep.service;

import java.util.Scanner;

import org.ep.VO.Monster;
import org.ep.VO.Player;

public class BattleService {
	
	private Scanner sc;
	
	
	public boolean choice() {
		System.out.println("1. ���� 2. ����");
		int choice = Integer.parseInt(sc.nextLine());
		return choice == 1 ? false : true;
	}
	
	public void battle(Player player, Monster monster, Scanner sc, MonsterField monsterField) {
		while(true) {
			
//			if(choice()) {
//				break;
//			}
			sc.nextLine();
			System.out.println("�÷��̾ ���� �����ϴ�.");
			player.attack(monster);
			if(monster.getHP() <= 0) {
				System.out.println(monster.getLevel()+"������ ���Ͱ� ���������ϴ�.");
				monster = monsterField.getNext();
				System.out.println(monster.getLevel()+"������ ���Ͱ� ��Ÿ�����ϴ�.");
				System.out.println(monster);
				battle(player, monster, sc, monsterField);
			}
			if(player.getHP() <= 0) {
				System.out.println(player.getName()+"�� ���������ϴ�.");
				return;
			}
			System.out.println(monster);
			sc.nextLine();
			System.out.println("���Ͱ� �ݰ��߽��ϴ�.");
			monster.attack(player);
			if(player.getHP() <= 0) {
				System.out.println(player.getName()+"�� ���������ϴ�.");
				return;
			}
			System.out.println(player);
			
			}
		}
	}

