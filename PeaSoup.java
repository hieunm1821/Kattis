//Name: Nguyen Minh Hieu
//https://open.kattis.com/problems/peasoup
import java.util.*;
public class PeaSoup {
	
	public static String restaurantToEat(String [][] list) {
		boolean hasPan = false,hasPea = false; 
	    for (int i = 0; i < list.length; i++ ) {
	    	for (int j = 1; j <= list[i].length-1; j++) {
				if (list[i][j].equals("pea soup")) hasPea = true;
				if (list[i][j].equals("pancakes")) hasPan = true;
			}
			if (hasPea && hasPan) return(list[i][0]);
	    }
	    return "Anywhere is fine I guess";
	}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int no_of_restaurants,no_of_items;

        no_of_restaurants = sc.nextInt();
        sc.nextLine();

        String [][] list = new String [no_of_restaurants][11]; //[[name,item1,item2],[]]
        

        for (int i = 0; i < no_of_restaurants; i++) { 
            no_of_items = sc.nextInt();
            sc.nextLine();
            list[i][0] = sc.nextLine(); // name of restaurant
            for (int j = 1; j <= no_of_items; j++) {
                list[i][j] = sc.nextLine();
            }
            for (int k = no_of_items + 1; k < 11; k++) {
                list[i][k] = ""; // replace null
            }
        }
        System.out.println(restaurantToEat(list));  
    }
}
