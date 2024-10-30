import java.util.HashMap;
import java.util.Scanner;

public class Main {

	static HashMap<Character, int[]> dic = new HashMap<>();
	
	public static void main(String[] args) {
		
		buildMap();
		
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		int[] lastLoc = {0,0};
		
		int steps = 0;
		
		for (int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			int[] loc = dic.get(c);
			steps += Math.abs(loc[0]-lastLoc[0])+Math.abs(loc[1]-lastLoc[1]);
			lastLoc = loc;
		}
		steps += Math.abs(4-lastLoc[0])+Math.abs(5-lastLoc[1]);
		System.out.println(steps);
	}

	private static void buildMap() {
		/*dic.put('A', new int[] {0,0});
		dic.put('B', new int[] {0,1});*/
		
		for (int i=0;i<26;i++) {
			char c = (char)('A'+i);
			int x = i/6;
			int y = i % 6;
			int[] coordinate = new int[]{x,y};
			dic.put(c, coordinate);
		}
		
		dic.put(' ', new int[] {4,2});
		dic.put('-', new int[] {4,3});
		dic.put('.', new int[] {4,4});
		
	}

}
