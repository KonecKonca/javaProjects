import java.util.Random;
public class Lab7 {
	public static void main(String[] args) {
		int m = 8;
		int n = 8;
		int[][] table = createTable(m,n);
		System.out.println("Исходный массив размером m="+m+" и n="+n);
		out(table);
		int min = 5;
		int max = 50;
		int[][] result = interval(table, min, max);
		System.out.println("\nУсловия поиска:\nнижняя граница = "+min+"\nверхняя граница = "+max);
		System.out.println("\nРезультат поиска: ");
		out(result);
		System.out.println("Количество подходящих элементов: к="+ result.length);
	}
	
	public static int[][] createTable(int m, int n) {
		int[][] array = new int[m][n];
		System.out.print("Сгенерированные числа: ");
		for(int i = 0; i < m; i++) {
			Random random = new Random();
			int randomNumber = random.nextInt((int) Math.pow(2, n-1)-1);
			System.out.print(randomNumber+"  ");
			int[] binaryNumber = toBinary(randomNumber, n);
			if (n >= 0) System.arraycopy(binaryNumber, 0, array[i], 0, n);
		}
		System.out.println();
		return array;
	}
	
	public static int[] toBinary(int number, int n){
		int[] result = new int[n];
		if(number < 0) {
			result[0]=1;
			number*=-1;
		}
		int count=n - 1;
		while(count > 0) {
			result[count--]=number%2;
			number/=2;
		}
		return result;
	}
	
	public static void out(int[][] array) {
		for (int[] anArray : array) {
			for (int j = 0; j < array[0].length; j++) {
				System.out.print(anArray[j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] interval(int[][] array, int min, int max){
		int m = array.length;
		int n = array[0].length;
		int[][] result = new int[m][n];
		int[] binaryMin = toBinary(min, n);
		int[] binaryMax = toBinary(max, n);
		int size = 0;
		for(int j = 0; j < m; j++) {
			boolean g1 = false, l1 = false;
			boolean g2 = false, l2 = false;
			for(int i = 0; i < n; i++) {
				g1 = g1 || (!toBoolean(binaryMin[i]) && toBoolean(array[j][i])  && !l1);
				g2 = g2 || (!toBoolean(binaryMax[i]) && toBoolean(array[j][i])  && !l2);
				l1 = l1 || (toBoolean(binaryMin[i])  && !toBoolean(array[j][i]) && !g1);
				l2 = l2 || (toBoolean(binaryMax[i])  && !toBoolean(array[j][i]) && !g2);
			}
			if( ( (g1 == false && l1 == false) || (g2 == false && l1 == false)) ||
				( (g1 == true  && l1 == false) && (g2 == false && l1 == true)) ) {
				save(result, size, array, j);
				size++;
			}
		}
		result = cut(result, size);
		return result;
	}
	
	public static boolean toBoolean(int number) {
		return number != 0;
	}
	
	public static void save(int[][] result, int size, int[][] array, int index) {
		System.arraycopy(array[index], 0, result[size], 0, result[0].length);
	}

	public static int[][] cut(int[][] array, int index) {
		int length = array[0].length;
		int[][] result = new int[index][length];
		for(int i = 0; i < index; i++) {
			System.arraycopy(array[i], 0, result[i], 0, length);
		}
		return result;
	}
	
}
