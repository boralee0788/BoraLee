import java.util.Scanner;

public class Ex0221_01 {

	public static void main(String[] args) {
		
		// 랜덤으로 10개의 1차원 배열을 만들어서
		// 1~45의 배열을 만들어서 값을 넣어보세요. 섞기
		// 10개를 배열에 넣으면 되겠습니다.
		// 단 중복은 허락하지 않음
		
		int[] list = new int[45];
		int[] select = new int[10];
		Scanner scan = new Scanner(System.in);
		int sum =0;
		int s_num = 0;
		
		while(true) {
			s_num = mainprint();
			
			switch (s_num) {
			case 1:
				input(list);
				System.out.println("45개 값 넣기 완료");
				break;

			case 2:
				shuffle(list);
				System.out.println("랜덤섞기 완료");
				break;

			case 3:
				array(list, select);
				System.out.println("10개 값 넣기 완료");
				break;

			case 4:
				printArr(select);
				break;

			case 5:
				sum = sumArr(select);
				System.out.println();
				System.out.println("10개 합: "+sum);
				break;

			case 6:
				int[] change = new int[10];
				array(select, change); // 기존꺼 하나 복사해두는 방법
				ascending(change);
				printArr(select);
				printArr(change);
				
//				printArr(select);
//				ascending(select);
//				printArr(select);
				break;

				
			default:
				break;
			}
			
		}
		
		
		
	} //main
	
	static int mainprint() {
		int s_num = 0;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("------------------------");
		System.out.println("1. 45개의 값 넣기");
		System.out.println("2. 랜덤섞기");
		System.out.println("3. 10개 값 넣기");
		System.out.println("4. 10개 출력");
		System.out.println("5. 10개 합 구하기");
		System.out.println("6. 10개 정렬하기");
		System.out.println("------------------------");
		System.out.println("원하는 번호를 입력하세요.>>");
		s_num = scan.nextInt();
		scan.hasNextLine();
		return s_num;
	}
	
	static void input(int[] list) {
		for(int i=0;i<list.length;i++) {  // 배열인 경우에만 for(int i:lotto){} 처럼 쓸 수 있음
			list[i] = i+1;
		}
	}
	
	static void shuffle(int[] list) {
		int temp=0;
		int index=0;
		for(int i=0;i<300;i++) {
			index = (int)(Math.random()*45);
			temp = list[0];
			list[0] = list[index];
			list[index] = temp;
		}
	}
	
	
	static void array(int[] list, int[] select) {
		for(int i=0;i<select.length;i++) {
			select[i] = list[i];
		}
	}
	
	static void printArr(int[] select) {
		for(int i=0;i<select.length;i++) {
			System.out.print(select[i]+" ");
		}
		System.out.println();
	}
	
	static int sumArr(int[] select) {
		int sum = 0;
		for(int i=0;i<select.length;i++) {
			sum +=select[i];
		}
		return sum;
	}
	
	static void ascending(int[]select) {
		int temp=0;
		for(int i=0;i<select.length-1;i++) {
			boolean check = false;
			for(int j=0;j<select.length-1-i;j++) {
				if(select[j]>select[j+1]) {
					temp = select[j];
					select[j] = select[j+1];
					select[j+1] = temp;
					check = true;
				}
			}
			if(check==false) {
				break;
			}
		}
	}

} //class
