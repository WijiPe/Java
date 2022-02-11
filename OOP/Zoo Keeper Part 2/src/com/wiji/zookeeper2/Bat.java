package com.wiji.zookeeper2;

public class Bat extends Mammal {
	
	public Bat() {
		super();
		super.energyLevel =300;
//		super.setEnergyLevel(300);
	}
	
	public void fly() {
//		super.setEnergyLevel(super.getEnergyLevel()-10);
		super.energyLevel -= 10;
		System.out.printf("hssss %d\n", super.energyLevel);
		
	}
	
	public void eatHumans() {
//		super.setEnergyLevel(super.getEnergyLevel()+25);
		super.energyLevel += 25;
		System.out.printf("So-well, never mind just increase its energy to %d\n", super.energyLevel);
	}
	
	public void attackTown() {
//		super.setEnergyLevel(super.getEnergyLevel()-100);
		super.energyLevel -= 100;
		System.out.printf("Bats attack---help!! Energy lost to %d\n", super.energyLevel);
	}
	
}
