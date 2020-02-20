
public class Ex0220_hw {

	public static void main(String[] args) {
		// 1~100까지 숫자를 랜덤으로 10개 배열에 넣어서 작은 숫자로 정렬해서 출력하세요. 
		
		int[] num = new int[100];
		int[] select = new int[10];
		
		shuffle(num);
		random(num, select);
		System.out.println();
		array(select);
		printArr(select);
		

	}

	static void shuffle(int[] num) {
		for (int i = 0; i < num.length; i++) {
			num[i] = i + 1;
		}

		int temp = 0;
		int index = 0;
		for (int i = 0; i < 200; i++) {
			index = (int) (Math.random() * 100);
			temp = num[0];
			num[0] = num[index];
			num[index] = temp;
		}
	}


	static void random(int[] num, int[] select) {
		System.out.print("기존 램던 숫자: ");
		for (int i = 0; i < select.length; i++) {
			select[i] = num[i];
			System.out.print(select[i]+" ");
		}
	}
	
	static void array(int[] select) {
		int temp = 0;
		
		for(int i=0; i<select.length-1;i++) {
			boolean check = false;
			for(int j=0; j<select.length-1-i;j++) {
				if(select[j]>select[j+1]) {
					temp = select[j];
					select[j] = select[j+1];
					select[j+1] = temp;
				}
			}
		}
	}
	
	static void printArr(int[] select) {
		System.out.print("오름차순 정렬: ");
		for (int i = 0; i < select.length; i++) {
			System.out.print(select[i]+" ");
		}
	}
}
