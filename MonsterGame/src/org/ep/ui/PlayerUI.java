package org.ep.ui;

import java.util.Scanner;

import org.ep.domain.Player;
import org.ep.domain.PlayerImpl;

public class PlayerUI {
	
	private Scanner sc;
	private Player player;
	
	
	
	public PlayerUI(Scanner sc) {
		super();
		this.sc = sc;
	}
	
	// �÷��̾� �̸� �� ���ݷ� ����
	public Player createPlayer() {
		System.out.println("����� �̸��� �Է����ּ���.");
		String name = sc.nextLine();
		System.out.println("����� ���ݷ��� �Է����ּ���.");
		int attackPoint = Integer.parseInt(sc.nextLine());
		this.player = new PlayerImpl(name, attackPoint); // player ��ü ����
		
		System.out.println("�̸� :"+player.getName());
		System.out.println("���ݷ� :"+player.getAttackPoint());
		System.out.println("ü�� :"+player.getHP());
		System.out.println();
		return this.player;
	}
	
}
