import java.util.*;
public class BestRelayTeam {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.nextLine();

		HashMap<String, Double> start = new HashMap<String, Double>();
		HashMap<String, Double> flying = new HashMap<String, Double>();

		//input data
		for (int i = 0; i < num; i ++){
			String name = sc.next();
			Double first = sc.nextDouble();
			Double other = sc.nextDouble();
			start.put(name, first);
			flying.put(name, other);
		}

		// sort flying by values => list of names sorted by flying time
		Set<Map.Entry<String, Double>> entries = flying.entrySet();

		Comparator<Map.Entry<String, Double>> c = new Comparator<Map.Entry<String, Double>>() {
			@Override
			public int compare(Map.Entry<String, Double> e1, Map.Entry<String,Double> e2) {
				Double v1 = e1.getValue();
				Double v2 = e2.getValue();
				return v1.compareTo(v2);
			}
		};

		List<Map.Entry<String, Double>> list_entries = new ArrayList<Map.Entry<String, Double>>(entries);
		Collections.sort(list_entries,c);
		ArrayList<String> list_name = new ArrayList<String>();

        for(Map.Entry<String, Double> entry : list_entries){
            list_name.add(entry.getKey());
        }


        Double best_time = 100.0; //100 > 20 *4
        ArrayList<String> best_team = null;

        for (String name: list_name) {
        	Double temp = start.get(name);
        	ArrayList<String> team = new ArrayList<String>();
        	team.add(name);
        	for (String name1: list_name) {
        		if (name == name1) continue;
        		team.add(name1);
        		temp += flying.get(name1);
        		if (team.size() == 4) break;
        	}
        	if (temp < best_time) {
        		best_time = temp;
        		best_team = team;
        	}
        }
        System.out.println(best_time);
        for (String name: best_team) {
        	System.out.println(name);
        }
	}
}
