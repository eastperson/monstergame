package org.ep.ui;

import java.util.Scanner;

import org.ep.VO.Player;
import org.ep.VO.Player;

public class PlayerUI {
	
	private Scanner sc;
	private Player player;
	
	
	
	public PlayerUI(Scanner sc) {
		super();
		this.sc = sc;
	}

	public Player createPlayer() {
		System.out.println("당신의 이름을 입력해주세요.");
		String name = sc.nextLine();
		System.out.println("당신의 공격력을 입력해주세요.");
		int attackPoint = Integer.parseInt(sc.nextLine());
		this.player = new Player(name, attackPoint);
		
		System.out.println("이름 :"+player.getName());
		System.out.println("공격력 :"+player.getAttackPoint());
		System.out.println("체력 :"+player.getHP());
		System.out.println();
		return this.player;
	}
	
}
