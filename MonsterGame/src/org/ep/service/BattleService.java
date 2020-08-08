package org.ep.service;

import java.util.Scanner;

import org.ep.domain.Monster;
import org.ep.domain.Player;

public class BattleService {
	
	private Scanner sc;
	private boolean isGameOver; // battle ����
	
	public boolean getIsGameOver() {
		return this.isGameOver;
	}
	
	// ���� BattleUI�� ����
	public BattleService(Scanner sc) {
		this.sc = sc;
	}
	
	// ��Ʋ�� player �ൿ ����
	public int choice(Player player) {
		System.out.println("1. ���� 2. ��ų 3. ����");
		int choice = Integer.parseInt(this.sc.nextLine());
		return choice;
	}
	
	// ��Ʋ�� player �ൿ ����
	public void choiceSelect(int choice, Player player, Monster monster) {
		if(choice == 1) {
			System.out.println(player.getName()+"��(��) ���� �����ϴ�.");
			player.attack(monster);
			System.out.println("���� ������ : " + player.getAttackPoint());
		} else if(choice == 2) {
			if(player.getMP() < player.getMPAmount()) {
				System.out.println("������ �����մϴ٤�");
				choiceSelect(choice(player), player, monster);
				return;
			}
			System.out.println("��ų ������ : "+player.getAP());
			player.skill(monster);
		} else if(choice == 3) {
			this.isGameOver = true;
		}
	}
}
	
