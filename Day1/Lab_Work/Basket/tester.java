package com.tester;

import com.app.*;
import java.util.Scanner;

public class tester {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter basket size");
		fruits[] basket = new fruits[sc.nextInt()];

		System.out.println("1. Add Mango \n2. Add Apple \n3. Add Orange");
		System.out.println("4. Show fresh fruits in basket");
		System.out.println("5. Show fresh fruits with it's taste in basket");
		System.out.println("6. Mark stale");
		System.out.println("7. Mark all sour fruits stale");
		System.out.println("8. Invoke spcl function");
		int ch = 0;
		int index = 0;
		do {
			System.out.println("Enter your choice:");
			ch = sc.nextInt();

			switch (ch) {

			case 1: // adding mango
				if (index < basket.length) {
					System.out.println("Mango: Enter name color weight:");
					basket[index] = new Mango(sc.next(), sc.next(), sc.nextDouble());
					index++;
					System.out.println("Mango added!!!!");
				} else
					System.out.println("Basket is Full");
				break;

			case 2: // adding apple

				if (index < basket.length) {
					System.out.println("Apple: Enter name color weight:");
					basket[index] = new Apple(sc.next(), sc.next(), sc.nextDouble());
					index++;
					System.out.println("Apple added!!!!");
				} else
					System.out.println("Basket is Full");
				break;

			case 3:// add orange

				if (index < basket.length) {
					System.out.println("Orange: Enter name color weight:");
					basket[index] = new Orange(sc.next(), sc.next(), sc.nextDouble());
					index++;
					System.out.println("Orange added!!!!");
				} else
					System.out.println("Basket is Full");
				break;

			case 4: // display all fresh fruits in basket

				if (basket != null)
				{
					for (fruits f : basket) {
						if(f!=null && f.getIsFresh())
						System.out.println(f.getName());
					}
					
				} else
					System.out.println("Basket is empty!!");
				break;

			case 5: // tostring + taste
				
					for (fruits f : basket) {
						if (f != null && f.getIsFresh())
						System.out.println(f);
					}
				break;

			case 6:// Take index value and mark it stale || Invalid index: O/P Error!

				System.out.println("Enter the index:");
				int id = sc.nextInt();

				if (id >= 0 && id < index) {

					basket[id].setFresh(false);
					System.out.println(basket[id].getName()+" Marked stale ");
					
					
				} else
					System.out.println("Invalid index input");
				break;

			case 7: // Mark all sour fruits stale
				int k=0;
				if (basket != null) {
					for (fruits f : basket) {

						if ( f!=null && f.taste().equals("Sour")) {
							f.setFresh(false);
							k++;
							
					}

					} // for
					if(k==0)
						System.out.println("No sour fruits in basket!!");
					if(k>0)
						System.out.println("Sour fruits marked stale!!!");

				} else
					System.out.println("Basket is Empty");
				break;

			case 8: // Take index as a I/P and print that objects spcl method.

				System.out.println("ENter the index:");
				int id1 = sc.nextInt();

				if (id1 >= 0 && id1 < index) {
					if (basket[id1] instanceof Apple)
						((Apple) basket[id1]).jam();
					else if (basket[id1] instanceof Mango)
						((Mango) basket[id1]).pulp();
					else
						((Orange) basket[id1]).juice();

				} else
					System.out.println("Invalid index input");
				break;

			case 9:
				System.out.println("Exiting the code.........");
				break;

			default:
				System.out.println("Invalid Input!!!!!");
				break;
			}// switch

		} while (ch != 9);

		sc.close();
	}// end

}
