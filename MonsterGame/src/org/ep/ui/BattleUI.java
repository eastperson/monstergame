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
	
	// 배틀UI
	public void battle(Player player, Monster monster, Scanner sc, MonsterField monsterField,BattleService battleService) {
		
		//game over될 때까지 무한 루프
		while(!battleService.getIsGameOver()) {
			
			System.out.println("현재 몬스터 레벨 :"+ monster.getLevel());
			System.out.println("현재 몬스터 체력 :"+ monster.getHP());
			System.out.println("--------------vs--------------");
			System.out.println("현재 플레이어 체력 :" + player.getHP());
			System.out.println("현재 플레이어 마나 :" + player.getMP());
			System.out.println("------------------------------");
			System.out.println();
			
			// 배틀시 player 행동 선택
			battleService.choiceSelect(battleService.choice(player), player, monster);
			
			// game over 될 시 배틀 종료
			if(battleService.getIsGameOver()) {
				monsterField.resetCurrentMonsterLevel();
				return;
			}
			
			// monster 체력이 음수가 되었을 때, 
			if(monster.getHP() <= 0) {
				System.out.println();
				System.out.println(monster.getLevel()+"레벨의 몬스터가 쓰러졌습니다.");
				sc.nextLine();
				
				// 10레벨 몬스터를 쓰러트렷을 때, 배틀 종료
				if(monster.getLevel() == 10) {
					System.out.println("당신은 승리자입니다. 축하드립니다.");
					monsterField.resetCurrentMonsterLevel();
					return;
				}
				
				monster = monsterField.getNext();	// 몬스터 레벨업
				System.out.println(monster.getLevel()+"레벨의 몬스터가 나타났습니다.");
				System.out.println("------------------------------");
				continue;
			}
			sc.nextLine();
			System.out.println("몬스터가 반격했습니다.");
			monster.attack((Fightable) player);
			System.out.println("데미지 :" + monster.getAttackPoint());
			System.out.println();
			if(player.getHP() <= 0) {
				System.out.println(player.getName()+"이(가) 쓰러졌습니다.");
				monsterField.resetCurrentMonsterLevel();
				return;
			}
			}
		}

}
