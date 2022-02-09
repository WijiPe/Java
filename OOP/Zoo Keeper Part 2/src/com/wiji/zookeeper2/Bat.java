package com.wiji.zookeeper2;

public class Bat extends Mammal {
	
	public Bat() {
		super();
		super.setEnergyLevel(300);
	}
	
	public void fly() {
		super.setEnergyLevel(super.getEnergyLevel()-10);
		System.out.printf("hssss %d\n", super.getEnergyLevel());
		
	}
	
	public void eatHumans() {
		super.setEnergyLevel(super.getEnergyLevel()+25);
		System.out.printf("So-well, never mind just increase its energy to %d\n", super.getEnergyLevel());
	}
	
	public void attackTown() {
		super.setEnergyLevel(super.getEnergyLevel()-100);
		System.out.printf("Bats attack---help!! Energy lost to %d\n", super.getEnergyLevel());
	}
	
}
