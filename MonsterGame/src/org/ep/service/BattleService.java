package org.ep.service;

import java.util.Scanner;

import org.ep.VO.Monster;
import org.ep.VO.Player;

public class BattleService {
	
	private Scanner sc;
	private boolean gameOver;
	
	
	public BattleService(Scanner sc) {
		this.sc = sc;
	}

	public int choice(Player player) {
		System.out.println("1. 공격 2. 스킬 3. 도망");
		int choice = Integer.parseInt(this.sc.nextLine());
		return choice;
	}
	
	public void choiceSelect(int choice, Player player, Monster monster) {
		if(choice == 1) {
			System.out.println(player.getName()+"이(가) 총을 쐈습니다.");
			player.attack(monster);
		} else if(choice == 2) {
			if(player.getMP() < 100) {
				System.out.println("마나가 부족합니다ㅠ");
				choiceSelect(choice(player), player, monster);
				return;
			}
			System.out.println("석양이 진다...");
			player.skill(monster);
		} else if(choice == 3) {
			this.gameOver = true;
		}
	}
	
	public void battle(Player player, Monster monster, Scanner sc, MonsterField monsterField) {
		while(!gameOver) {
			
			System.out.println("현재 몬스터 레벨 :"+monster.getLevel());
			System.out.println("현재 몬스터 체력 :"+monster.getHP());
			System.out.println("-----------vs-----------------");
			System.out.println("현재 플레이어 체력 :" +player.getHP());
			System.out.println("현재 플레이어 마나 :" +player.getMP());
			System.out.println();
			
			choiceSelect(choice(player), player, monster);
			if(gameOver) {
				return;
			}
			
			if(monster.getHP() <= 0) {
				System.out.println();
				System.out.println(monster.getLevel()+"레벨의 몬스터가 쓰러졌습니다.");
				sc.nextLine();
				if(monster.getLevel() == 10) {
					System.out.println("당신은 승리자입니다. 축하드립니다.");
					return;
				}
				
				monster = monsterField.getNext();
				System.out.println(monster.getLevel()+"레벨의 몬스터가 나타났습니다.");
				System.out.println("------------------------------");
				continue;
			}
			sc.nextLine();
			System.out.println("몬스터가 반격했습니다.");
			System.out.println();
			monster.attack(player);
			if(player.getHP() <= 0) {
				System.out.println(player.getName()+"이(가) 쓰러졌습니다.");
				return;
			}
			}
		}
	}

