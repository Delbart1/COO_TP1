package generics;

import scanner.*;
import java.util.*;

public class ClonableVegetableListChoser {

	// methode "chose"
	// elle est similaire a celles de ListChoser et ListChoserLegume
	// simplement elle ne fonctionne qu'avec des listes d'objets de type Legume
	// qui de plus sont clonables (donc implémentent l'interface
	// java.lang.Clonable).
	// quel(s) changement(s) apporter à la méthode de ListChoser ?

	public <T extends Vegetable & Cloneable> T chose(String s, List<T> list) {
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

		List<Cauliflower> lCauliflowers = new LinkedList<Cauliflower>();
		lCauliflowers.add(new Cauliflower(1));
		lCauliflowers.add(new Cauliflower(2));
		lCauliflowers.add(new Cauliflower(3));

		ClonableVegetableListChoser lclc = new ClonableVegetableListChoser();

		Carrot chosenCarrot = lclc.chose("which carrot ? ", lCarrots);
		System.out.println("you have chosen : " + chosenCarrot);

		Cauliflower chosenCauliflower = lclc.chose("which cauliflower ? ",
				lCauliflowers);
		System.out.println("you have chosen : " + chosenCauliflower);

		List<Rutabaga> lRutabagas = new ArrayList<Rutabaga>();
		lRutabagas.add(new Rutabaga(1));
		lRutabagas.add(new Rutabaga(2));
		lRutabagas.add(new Rutabaga(3));
		// NE COMPILE PAS :
		//Rutabaga chosenRutabaga = lclc.chose("which rutabaga ? ",lRutabagas);

		List<Apple> lApples = new ArrayList<Apple>();
		lApples.add(new Apple(1));
		// NE COMPILE PAS :
		// Apple chosenApple = lclc.chose("which apple ? ",lApples);

	}
}