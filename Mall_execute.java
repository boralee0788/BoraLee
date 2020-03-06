import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Mall_execute {
	// 메인단
	Scanner scan = new Scanner(System.in);
	ArrayList<Member> m = new ArrayList<Member>();
//	ArrayList<Login> l= new ArrayList<Login>();
	HashMap map = new HashMap();
	ArrayList<Buy> buy_list = new ArrayList<Buy>();
	String current_id = "";

// 관리자 정보------------------------------------------------------------------------
	void manager() {
		m.add(new Member("admin","admin123", "관리자", "02"));
	}
	
	
// 회원가입 ---------------------------------------------------------------------------------------------------	
	void input() {

		Loop1:
		while (true) {
			System.out.println("아이디를 입력하세요.>> (이전화면:99)");
			String id = scan.nextLine();

			if (id.equals("99")) {
				System.out.println("이전 화면으로 돌아갑니다.");
				break;
			}

			if (id.length() < 3) {
				System.out.println("아이디는 3자리 이상으로 입력해주세요.");
				continue;
			}

			for (int i = 0; i < m.size(); i++) {
				Member m1 = (Member) m.get(i);
					if (m1.id.equals(id)) {
						System.out.println("이미 존재하는 아이디입니다. 다시 입력해주세요.");
						continue Loop1;
					}
				}

			System.out.println("비밀번호를 입력하세요.>>");
			String pw = scan.nextLine();
			if (pw.length() < 5) {
				System.out.println("비밀번호는 5자리 이상으로 입력해주세요.");
				continue;
			}

			System.out.println("이름을 입력하세요.>>");
			String name = scan.nextLine();

			System.out.println("전화번호를 입력하세요.>>");
			String tel = scan.nextLine();

			m.add(new Member(id, pw, name, tel));

		}
	}

// 로그인	 ---------------------------------------------------------------------------------------------------
	void login() {

		if (!(map.isEmpty())) {
			System.out.println("이미 로그인이 되어 있습니다.");
			return;
		}

		while (true) {
			String id_check="";
			String pw_check ="";
			System.out.println("아이디를 입력하세요.>> (이전화면: 99)");
			id_check = scan.nextLine();

			if (id_check.equals("99")) {
				System.out.println("이전 화면으로 돌아갑니다.");
				break;
			}

			boolean check1 = false;
			boolean check2 = false;
			for (int i = 0; i < m.size(); i++) {
				Member m1 = (Member) m.get(i);
				if (id_check.equals(m1.id)) {
					check1 = true;
					System.out.println("비밀번호를 입력하세요.>>");
					pw_check = scan.nextLine();
					if (pw_check.equals(m1.pw)) {
						check2 = true;
						System.out.println("로그인이 되었습니다.");
						
					}
				}
			}

			if (check1 == false) {
				System.out.println("일치하는 아이디가 없습니다. 다시 입력해주세요.");
				continue;
			}

			if (check2 == false) {
				System.out.println("pw가 일치하지 않습니다. 다시 입력해주세요.");
				continue;
			}
			map.put(id_check, pw_check);
			current_id = id_check;
			return;
		}
	}


// 로그인 여부 확인 ---------------------------------------------------------------------------------------------------
	boolean login_check() {
		boolean check = true;
		if (map.isEmpty()) {
			check = false;
		}
		return check;
	}
	
	

// 로그아웃 ---------------------------------------------------------------------------------------------------
	void logout() {

		if (map.isEmpty()) {
			System.out.println("로그인이 되어있지 않습니다.");
		} else {
			System.out.println("로그아웃을 하시겠습니까?(y/n)");
			String yn = scan.nextLine();

			if (yn.equalsIgnoreCase("y")) {
				System.out.println("로그아웃 되었습니다.");
				map.clear();
			} else if (yn.equalsIgnoreCase("n")) {
				System.out.println("상위 페이지로 이동합니다.");
				return;
			}
		}

//			Iterator<Login> it = map.entrySet().iterator();
//			
//			while(true){
//				System.out.println("아이디를 입력하세요.>> (이전화면:99)");
//				String id_logout = scan.nextLine();
//				
//				if(id_logout.equals("99")) {
//					System.out.println("이전 화면으로 돌아갑니다.");
//					break;
//				}
//				
//				if(!(map.containsKey(id_logout))) {
//					System.out.println("일치하는 아이디가 없습니다. 로그인을 해주세요.");
//					break;
//				}
//				
//				System.out.println("비밀번호를 입력하세요.>>");
//				String pw_logout = scan.nextLine();
//				
//				if(!(map.containsKey(pw_logout))) {
//					System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
//					continue;
//				} else {
//					System.out.println("로그아웃이 되었습니다.");
//					map.remove(id_logout);
//				}

	}

// 회원 정보 검색	 ---------------------------------------------------------------------------------------------------
	void search() {
		String[] list = { "아이디", "비밀번호", "이름", "전화번호", "보유금액", "보너스포인트" };
		while (true) {
			System.out.println("검색하실 이름을 입력해주세요. 이름의 한 글자만 입력하셔도 됩니다.>> (이전 화면:99)");
			String name_search = scan.nextLine();

			if (name_search.equals("99")) {
				System.out.println("이전 화면으로 돌아갑니다.");
				break;
			}
			
			for (int i = 0; i < list.length; i++) {
				System.out.print(list[i] + "\t");
			}
			System.out.println();

			boolean check = false;
			for (int i = 0; i < m.size(); i++) {
				Member m1 = (Member) m.get(i);
				if (m1.name.contains(name_search)) {
					check = true;
					System.out.println(m1.id + "\t" + m1.pw+"\t"+ m1.name + "\t" + m1.tel + "\t" + m1.money + "\t" + m1.bonusPoint);
				}
			}
			if (check == false) {
				System.out.println("찾으시는 이름이 없습니다. 다시 검색해주세요.");
				continue;
			}
		}
	}

// 회원 정보 출력	 (이름순으로) ---------------------------------------------------------------------------------------------------
	void prit_member() {
		String[] list = { "아이디", "비밀번호", "이름", "전화번호", "보유금액", "보너스포인트" };
		Collections.sort(m, new Comparator<Member>() {

			@Override
			public int compare(Member m1, Member m2) {
				// TODO Auto-generated method stub
				return m1.name.compareTo(m2.name);
			}
		});

		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + "\t");
		}
		System.out.println();

		for (int i = 0; i < m.size(); i++) {
			Member m1 = (Member) m.get(i);
			System.out.println(m1.id + "\t" + m1.pw+"\t"+ m1.name + "\t" + m1.tel + "\t" + m1.money + "\t" + m1.bonusPoint);
		}
	}

	
	
// TV 구매 ---------------------------------------------------------------------------------------------------	

	void buy_tv(TV t) {

		System.out.println("제품명: " + t.name);
		System.out.println("가격: " + t.price);
		System.out.println("스크린: " + t.screen);
		System.out.println("인치: " + t.inch);

		for (int i = 0; i < m.size(); i++) {
			Member m3 = (Member) m.get(i);
			if (m3.id.equals(current_id)) {
				if (m3.money < t.price) {
					System.out.println("금액이 부족합니다. 충전해주세요.");
					return;
				}
				m3.money -= t.price;
				m3.bonusPoint += t.bonusPoint;
				buy_list.add(new Buy(current_id,t.name, t.price, t.bonusPoint));
				System.out.println(t.name + " 1대를 구매했습니다.");
			}
		}
	}

// Ref 구매 ---------------------------------------------------------------------------------------------------

	void buy_ref(Ref r) {

		System.out.println("제품명: " + r.name);
		System.out.println("가격: " + r.price);
		System.out.println("용량: " + r.liter);
		System.out.println("문 개수: " + r.door);

		int money = 0;

		for (int i = 0; i < m.size(); i++) {
			Member m3 = (Member) m.get(i);
			if (m3.id.equals(current_id)) {
				if (m3.money < r.price) {
					System.out.println("금액이 부족합니다. 충전해주세요.");
					return;
				}
				m3.money -= r.price;
				m3.bonusPoint += r.bonusPoint;
				buy_list.add(new Buy(current_id, r.name, r.price, r.bonusPoint));
				System.out.println(r.name + " 1대를 구매했습니다.");;
			}
		}

	}
	
	
// WM 구매 ---------------------------------------------------------------------------------------------------

	void buy_wm(WM w) {

		System.out.println("제품명: " + w.name);
		System.out.println("가격: " + w.price);
		System.out.println("사이즈: " + w.size);
		System.out.println("모양: " + w.shape);

		for (int i = 0; i < m.size(); i++) {
			Member m3 = (Member) m.get(i);
			if (m3.id.equals(current_id)) {

				if (m3.money < w.price) {
					System.out.println("금액이 부족합니다. 충전해주세요.");
					return;
				} else {
					m3.money -= w.price;
					m3.bonusPoint += w.bonusPoint;
					buy_list.add(new Buy(current_id, w.name, w.price, w.bonusPoint));
					System.out.println(w.name + " 1대를 구매했습니다.");
				}
				
			}
		}
	}
	

// 구매목록 출력 ---------------------------------------------------------------------------------------------------

	void print_buy() {
		
		String[] subject = {"아이디", "상품명", "가격", "포인트", "구매일자"};
		String[] subject2 = {"아이디", "총 구매금액","총 구매개수"};
		
		if (map.isEmpty()) {
			System.out.println("로그인이 되어있지 않습니다. 로그인을 먼저해주세요.");
			return;
		}
		
		int sum = 0;
		int count = 0;
		if(current_id.equals("admin")) {
			for(int i=0;i<subject.length;i++) {
				System.out.print(subject[i]+"\t");
			}
			System.out.println();
				
			for(int j=0; j<buy_list.size();j++) {
				Buy b1 = (Buy)buy_list.get(j);
				System.out.println(b1.id+"\t"+b1.name+"\t"+b1.price+"\t"+b1.bonusPoint+"\t"+b1.date);
				sum +=b1.price;
				count++;
			}
			
			System.out.println();
			System.out.println("-----------------------------------------------------------------------");

			System.out.println("총 구매금액: "+sum);
			System.out.println("총 구매개수: "+count);
		} else {
			for(int i=0;i<subject.length;i++) {
				System.out.print(subject[i]+"\t");
			}
			System.out.println();
			
			
			for(int j=0; j<buy_list.size();j++) {
				Buy b2 = (Buy)buy_list.get(j);
				if(b2.id.equals(current_id)) {
					System.out.println(b2.id+"\t"+b2.name+"\t"+b2.price+"\t"+b2.bonusPoint+"\t"+b2.date);
					sum +=b2.price;
					count++;
				}
			}
			System.out.println();
			System.out.println("-----------------------------------------------------------------------");
			
			System.out.println("총 구매금액: "+sum);
			System.out.println("총 구매개수: "+count);
		}
	}
			
}
