package generics;

import java.util.*;

public class ListChoser {

	// Definir la methode chose, qui prend en premier parametre
	// un message sous forme de chaene de caracteres et en second une liste.
	// Cette liste est typee mais sans restriction sur les types admis.
	// Cette methode propose de choisir un element de la liste en saisissant
	// sa position dans la liste.
	// L'element choisi est retourne par la methode, null si le choix 0 est
	// fait.
	//
	// ...methode chose...
	//
	
	
	
	
	//public Object chose(String s, List list){
	
	public <T> T chose(String s, List<T> list){
		if(list.isEmpty()){
			System.out.println("Liste vide.");
			return null;
		}
		
		else{

			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			
			int input = -1;
			while (input < 0 || input >= list.size()) {
				System.out.print("Choisi entre (0 et "  + (list.size()-1) + ")");
				try {
					input = scan.nextInt();
				} catch (InputMismatchException	 e){
					// consume the input (that is not an integer)
					scan.skip(".*");
				}
		}
			if(input == 0){
				return null;
			}
			else{
				return list.get(input-1);
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		// JEU DE TEST

		List<Carrot> lCarrots = new ArrayList<Carrot>();
		lCarrots.add(new Carrot(1));
		lCarrots.add(new Carrot(2));
		lCarrots.add(new Carrot(3));

		List<Apple> lApples = new ArrayList<Apple>();
		lApples.add(new Apple(1));
		lApples.add(new Apple(2));
		lApples.add(new Apple(3));

		ListChoser lc = new ListChoser();

		Carrot chosenCarrot =  lc.chose("which carrot ? ", lCarrots);
		System.out.println("Tu as choisi : " + chosenCarrot);

		Apple chosenApple =  lc.chose("which appel? ", lApples);
		System.out.println("Tu as choisi : " + chosenApple);
	}
}
