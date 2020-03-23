import java.util.*;
public class MissingMembers {
	public static boolean check(int[] arr, int toCheck) {
		boolean flag = false;
		for (int num: arr) {
			if (toCheck == num) {
				flag = true;
				return flag;
			}
		}
		return flag;
	}

	public static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}
	public static int[] merge(int[] input, int[] missing ) {
		int[] temp = new int[input.length+ missing.length]; 
		int left = 0, right = 0, it = 0;

		while (left < input.length && right < missing.length) {
			if (input[left] <= missing[right])
				temp[it++] = input[left++];
			else
				temp[it++] = missing[right++];
		}
		while (left < input.length) temp[it++] = input[left++];
		while (right < missing.length)  temp[it++] = missing[right++];
		return temp;
	}

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
		int numOfMembers,numOfRemaining;
		numOfMembers = sc.nextInt();
		sc.nextLine();
		numOfRemaining = sc.nextInt();
		sc.nextLine();

		int [] missing = new int[numOfMembers - numOfRemaining];
		int [] input = new int[numOfRemaining];

		for (int i = 0; i < numOfRemaining; i++) 
			input[i] = sc.nextInt();
			sc.nextLine();

		int k=0; 
		for (int j = 1; j <= numOfMembers; j++)
			if (check(input,j) == false) {
				missing[k++] = j;

		}
		printArray(merge(input,missing));
	}
}