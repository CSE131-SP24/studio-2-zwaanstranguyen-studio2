package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("What is the amount of money you will start with?");
		double startAmount = in.nextDouble();
		
		System.out.print("what is the probability you win a single play?");
		double winChance = in.nextDouble();
		
		System.out.print("What is the amount of money you need to win to call it a successful day?");
		double winLimit = in.nextDouble();
		
		System.out.print("How many days do you want to simulate?");
		int totalSimulations = in.nextInt();
		
		int countDay=0;
		int winCount = 0;
		int lossCount = 0;
		
	while (countDay <= totalSimulations) {
		
		int count = 0;
		double rstartAmount = startAmount;
		
		while  ( rstartAmount > 0 && rstartAmount < winLimit)
		{
			double a = Math.random();
			if (a <= winChance)
			{rstartAmount++;
			count++;
			//System.out.println("Trial " + count + ": win. (Total remaining is: $" + startAmount + ").");
			}
			else
			{rstartAmount--;
			count++;
			//System.out.println("Trial " + count + ": loss. (Total remaining is: $" + startAmount + ").");
			}
		}
		countDay++;
		
		if (rstartAmount == 0)
			{
			lossCount++;
			System.out.println("Simulation " + countDay + ": " + count + "LOSE");
			}
		else if (rstartAmount == winLimit)
			{
			winCount++;
			System.out.println("Simulation " + countDay + ": " + count + "WIN");
			}

	}
	
	double dlossCount = lossCount;
	double dtotalSimulations = totalSimulations;
	
	double actualRuinRate = (dlossCount/dtotalSimulations);
	
	double alpha = (1-winChance)/winChance;
	double expectedRuinRate = null;
	
	if (winChance == 0.5)
		{
		double expectedRuinRate = 1 - (startAmount/winLimit);
		}
	else
		{
		double expectedRuinRate = (Math.pow(alpha,startAmount)-Math.pow(alpha,winLimit))/(1-Math.pow(alpha,winLimit));
		}
	
	
	System.out.println("Losses: " + lossCount + " Simulations: " + totalSimulations);
	
	System.out.println("Ruin rate from Simulation: "+ actualRuinRate + " Expected ruin rate: " + expectedRuinRate);
	
	}}
