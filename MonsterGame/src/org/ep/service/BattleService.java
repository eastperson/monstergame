package org.ep.service;

import java.util.Scanner;

import org.ep.domain.Monster;
import org.ep.domain.Player;

public class BattleService {
	
	private Scanner sc;
	private boolean isGameOver; // battle 종료
	
	public boolean getIsGameOver() {
		return this.isGameOver;
	}
	
	// 추후 BattleUI로 이전
	public BattleService(Scanner sc) {
		this.sc = sc;
	}
	
	// 배틀시 player 행동 선택
	public int choice(Player player) {
		System.out.println("1. 공격 2. 스킬 3. 도망");
		int choice = Integer.parseInt(this.sc.nextLine());
		return choice;
	}
	
	// 배틀시 player 행동 구현
	public void choiceSelect(int choice, Player player, Monster monster) {
		if(choice == 1) {
			System.out.println(player.getName()+"이(가) 총을 쐈습니다.");
			player.attack(monster);
			System.out.println("공격 데미지 : " + player.getAttackPoint());
		} else if(choice == 2) {
			if(player.getMP() < player.getMPAmount()) {
				System.out.println("마나가 부족합니다ㅠ");
				choiceSelect(choice(player), player, monster);
				return;
			}
			System.out.println("스킬 데미지 : "+player.getAP());
			player.skill(monster);
		} else if(choice == 3) {
			this.isGameOver = true;
		}
	}
}
	
