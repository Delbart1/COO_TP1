package generics;

import java.util.*;

public class VegetableListChoser {

	// methode chose
	// elle est similaire a celle de ListChoser simplement elle ne fonctionne
	// qu'avec des listes d'objets de type Legume (cf. interface Legume)
	// quel changement apporter a la methode de ListChoser ?

	public <Vegetable> Vegetable chose(String s, List<Vegetable> list) {
		if (list.isEmpty()) {
			System.out.println("Liste vide.");
			return null;
		}

		else {

			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);

			int input = -1;
			while (input < 0 || input >= list.size()) {
				System.out.print("Choisi entre (0 et " + (list.size() - 1)
						+ ")");
				try {
					input = scan.nextInt();
				} catch (InputMismatchException e) {
					// consume the input (that is not an integer)
					scan.skip(".*");
				}
			}
			if (input == 0) {
				return null;
			} else {
				return list.get(input - 1);
			}
		}

	}

	public static void main(String[] args) {
		List<Carrot> lCarrots = new ArrayList<Carrot>();
		lCarrots.add(new Carrot(1));
		lCarrots.add(new Carrot(2));
		lCarrots.add(new Carrot(3));

		List<Apple> lApples = new ArrayList<Apple>();
		lApples.add(new Apple(1));
		lApples.add(new Apple(2));
		lApples.add(new Apple(3));

		VegetableListChoser lcl = new VegetableListChoser();

		Carrot chosenCarrot = lcl.chose("which carrot ? ", lCarrots);
		System.out.println("You have chosen : " + chosenCarrot);

		// NE COMPILE PAS
		//Apple chosenApple = lcl.chose("which apple ? ",lApples);

	}
}
