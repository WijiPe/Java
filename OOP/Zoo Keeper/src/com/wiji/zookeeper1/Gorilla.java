package com.wiji.zookeeper1;

public class Gorilla extends Mammal {
	
	public void throwSomething() {
		super.setEnergyLevel(super.getEnergyLevel()-5);
		System.out.printf("Gorilla has thrown something and its energy goes down to %d.\n", super.getEnergyLevel());
	}
	
	public void eatBananas() {
		super.setEnergyLevel(super.getEnergyLevel()+10);
		System.out.printf("Gorilla is happy and its energy goes up to %d. \n", super.getEnergyLevel());
	}
	
	public void climb() {
		super.setEnergyLevel(super.getEnergyLevel()+10);
		System.out.printf("Gorilla has climb the trees and its energy goes up to %d. \n", super.getEnergyLevel());
	}
	
	
}
