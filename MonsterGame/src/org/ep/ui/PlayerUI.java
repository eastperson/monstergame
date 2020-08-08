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
		System.out.println("����� �̸��� �Է����ּ���.");
		String name = sc.nextLine();
		System.out.println("����� ���ݷ��� �Է����ּ���.");
		int attackPoint = Integer.parseInt(sc.nextLine());
		this.player = new Player(name, attackPoint);
		
		System.out.println("�̸� :"+player.getName());
		System.out.println("���ݷ� :"+player.getAttackPoint());
		System.out.println("ü�� :"+player.getHP());
		System.out.println();
		return this.player;
	}
	
}
