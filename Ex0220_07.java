
public class Ex0220_07 {

	public static void main(String[] args) {
		// 1~25까지 수 중 랜덤으로 5개 숫자를 배열에 넣고 그 가운데 최대값을 구하시오.

		int[] num = new int[25];
		int[] select = new int[5];

		shuffle(num);
		array(num, select);
		max(select);

	}

	static void shuffle(int[] num) {
		for (int i = 0; i < num.length; i++) {
			num[i] = i + 1;
		}

		int temp = 0;
		int index = 0;
		for (int i = 0; i < 200; i++) {
			index = (int) (Math.random() * 25);
			temp = num[0];
			num[0] = num[index];
			num[index] = temp;
		}
	}

	static void array(int[] num, int[] select) {
		for (int i = 0; i < select.length; i++) {
			select[i] = num[i];
		}
	}

	static void max(int[] select) {
		int max1 = 0;
		for (int i = 0; i < select.length - 1; i++) {
			max1 = Math.max(select[i], select[i + 1]);
		}

		for (int i = 0; i < select.length; i++) {
			System.out.print(select[i] + " ");
		}
		System.out.println(max1);
	}

}
