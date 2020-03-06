import java.util.ArrayList;
import java.util.Scanner;

public class Main_mall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		Mall_execute execute = new Mall_execute();
		execute.manager();
	
		
		while(true) {
			System.out.println("---------------------");
			System.out.println("    [쇼핑몰 프로그램]	");
			System.out.println("---------------------");
			System.out.println("1) 회원가입");
			System.out.println("2) 로그인 ");
			System.out.println("3) 로그아웃 ");
			System.out.println("4) 상품구매 ");
			System.out.println("5) 상품구매 목록보기 ");
			System.out.println("8) 회원정보검색 ");
			System.out.println("9) 회원정보출력 ");
			System.out.println("원하는 번호를 입력하세요.>>");
			int select = scan.nextInt();
						
			switch (select) {
			case 1:
				execute.input();
				break;
				
			case 2:
				execute.login();
				break;
				
			case 3:
				execute.logout();
				break;
				
			case 4:
				boolean check;
				check = execute.login_check();
				if(check==false) {
					System.out.println("로그인이 되어있지 않습니다. 상품을 구매하시려면 로그인을 해주세요.");
					break;
				}
				
				String[] p_list = {"", "LCD TV", "LED TV", "OLED TV", "일반 냉장고", "양문형 냉장고", "통돌이세탁기 ", "드럼세탁기", "드럼건조세탁기"};
			
				while(true) {
									
					System.out.println("---------------------------");
					System.out.println("	[상품목록]	");
					System.out.println("---------------------------");
					System.out.println("1)LCD TV	2)LED TV	3)OLED TV");
					System.out.println("4)일반 냉장고	5)양문형 냉장고");
					System.out.println("6)통돌이세탁기 	7)드럼세탁기	8)드럼건조세탁기");
					System.out.println("구매하고 싶은 제품 번호를 입력하세요.>> (이전화면:99)");
					int p_num = scan.nextInt();
					scan.nextLine();
					
					if (p_num==99) {
						System.out.println("이전 화면으로 돌아갑니다.");
						break;
					}
					
					System.out.println(p_list[p_num]+"을 구매하시겠습니까? (y/n)");
					String yn = scan.nextLine();
					
					if(yn.equalsIgnoreCase("n")) {
						System.out.println("구매하실 상품을 다시 선택해주세요.");
						continue;
					}else if(yn.equalsIgnoreCase("y")) {
					
						switch (p_num) {
						case 1:
							execute.buy_tv(new LCD());
							
							break;
							
						case 2:
							execute.buy_tv(new LED());
							break;
							
						case 3:
							execute.buy_tv(new OLED());
							break;
				
						case 4:
							execute.buy_ref(new Ref1());
							break;
							
						case 5:
							execute.buy_ref(new Ref2());
							break;
							
						case 6:
							execute.buy_wm(new WM1());
							break;

						case 7:
							execute.buy_wm(new WM2());
							break;
							
						case 8:
							execute.buy_wm(new WM3());
							break;
							
						default:
							break;
						}
					}
					break;
				}
						
				break;
//				
			case 5:
				execute.print_buy();
				break;
				
			case 8:
				execute.search();
				break;
				
			case 9:
				execute.prit_member();
				break;

			default:
				break;
			}
			
		}
		
		
		
		
		
		
		
		
	}

}
