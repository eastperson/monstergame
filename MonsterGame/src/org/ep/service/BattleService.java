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
		System.out.println("1. ���� 2. ��ų 3. ����");
		int choice = Integer.parseInt(this.sc.nextLine());
		return choice;
	}
	
	public void choiceSelect(int choice, Player player, Monster monster) {
		if(choice == 1) {
			System.out.println(player.getName()+"��(��) ���� �����ϴ�.");
			player.attack(monster);
		} else if(choice == 2) {
			if(player.getMP() < 100) {
				System.out.println("������ �����մϴ٤�");
				choiceSelect(choice(player), player, monster);
				return;
			}
			System.out.println("������ ����...");
			player.skill(monster);
		} else if(choice == 3) {
			this.gameOver = true;
		}
	}
	
	public void battle(Player player, Monster monster, Scanner sc, MonsterField monsterField) {
		while(!gameOver) {
			
			System.out.println("���� ���� ���� :"+monster.getLevel());
			System.out.println("���� ���� ü�� :"+monster.getHP());
			System.out.println("-----------vs-----------------");
			System.out.println("���� �÷��̾� ü�� :" +player.getHP());
			System.out.println("���� �÷��̾� ���� :" +player.getMP());
			System.out.println();
			
			choiceSelect(choice(player), player, monster);
			if(gameOver) {
				return;
			}
			
			if(monster.getHP() <= 0) {
				System.out.println();
				System.out.println(monster.getLevel()+"������ ���Ͱ� ���������ϴ�.");
				sc.nextLine();
				if(monster.getLevel() == 10) {
					System.out.println("����� �¸����Դϴ�. ���ϵ帳�ϴ�.");
					return;
				}
				
				monster = monsterField.getNext();
				System.out.println(monster.getLevel()+"������ ���Ͱ� ��Ÿ�����ϴ�.");
				System.out.println("------------------------------");
				continue;
			}
			sc.nextLine();
			System.out.println("���Ͱ� �ݰ��߽��ϴ�.");
			System.out.println();
			monster.attack(player);
			if(player.getHP() <= 0) {
				System.out.println(player.getName()+"��(��) ���������ϴ�.");
				return;
			}
			}
		}
	}

