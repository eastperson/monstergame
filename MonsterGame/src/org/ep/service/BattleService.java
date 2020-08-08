package org.ep.service;

import java.util.Scanner;

import org.ep.VO.Monster;
import org.ep.VO.Player;

public class BattleService {
	
	private Scanner sc;
	
	
	public boolean choice() {
		System.out.println("1. 공격 2. 도망");
		int choice = Integer.parseInt(sc.nextLine());
		return choice == 1 ? false : true;
	}
	
	public void battle(Player player, Monster monster, Scanner sc, MonsterField monsterField) {
		while(true) {
			
//			if(choice()) {
//				break;
//			}
			sc.nextLine();
			System.out.println("플레이어가 총을 쐈습니다.");
			player.attack(monster);
			if(monster.getHP() <= 0) {
				System.out.println(monster.getLevel()+"레벨의 몬스터가 쓰러졌습니다.");
				monster = monsterField.getNext();
				System.out.println(monster.getLevel()+"레벨의 몬스터가 나타났습니다.");
				System.out.println(monster);
				battle(player, monster, sc, monsterField);
			}
			if(player.getHP() <= 0) {
				System.out.println(player.getName()+"가 쓰러졌습니다.");
				return;
			}
			System.out.println(monster);
			sc.nextLine();
			System.out.println("몬스터가 반격했습니다.");
			monster.attack(player);
			if(player.getHP() <= 0) {
				System.out.println(player.getName()+"가 쓰러졌습니다.");
				return;
			}
			System.out.println(player);
			
			}
		}
	}

