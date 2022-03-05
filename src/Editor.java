import java.util.Scanner;
import java.util.ArrayList;
public class Editor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList undoList = new ArrayList(10);
		ArrayList redoList = new ArrayList(10);
		String msg = "안녕하세요. 점심 식사는 하셨나요?";
		//undoList.add(msg);
		while (true) {
			try {
				System.out.println(">출력: "+msg);
				System.out.print(">입력: ");
				String input = sc.nextLine();
				String[] strs = input.split("[(,)]");
				String cmd = strs[0];
				// (앞 스트링
				if (cmd.equals("edit")) {
					int start = Integer.parseInt(strs[1]);
					// 시작 인덱스
					int end = Integer.parseInt(strs[2]);
					// 끝 인덱스
					String[] str3 = strs[3].split("[\"]");
					String str = "";
					if (str3.length>=2) str = str3[1];
					String s1 = msg.substring(0, start);
					String s2 = str;
					String s3 = msg.substring(end);
					undoList.add(msg);
					msg = s1+s2+s3;					
				}
				else if (cmd.equals("undo")) {
					if (undoList.size()>0) {
						redoList.add(msg);
						msg = (String)undoList.remove(undoList.size()-1);
					}
					else {
						System.out.println(">경고: 더 이상 실행취소를 할 수 없습니다.");
					}
				}
				else if (cmd.equals("redo")) {
					if (undoList.size()>0) {
						undoList.add(msg);
						msg = (String)redoList.remove(redoList.size()-1);
					}
					else {
						System.out.println(">경고: 더 이상 다시실행을 할 수 없습니다.");
					}
				}
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
	}
}