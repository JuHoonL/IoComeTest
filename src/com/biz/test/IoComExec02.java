package com.biz.test;

import java.util.Scanner;

import com.biz.test.service.IoComeService02;
import com.biz.test.vo.IoComeVO;

public class IoComExec02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IoComeService02 icS = new IoComeService02();
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			IoComeVO vo = new IoComeVO();
		
			icS.inOutInsert(vo);
		
			System.out.println("입력을 끝내시겠습니까?");
			System.out.print("(네 or 계속하시려면 아무키 입력) >> ");
			String strTheEnd = scanner.nextLine();
			if(strTheEnd.equals("네")) break;
		}
		icS.ioListPrint();
		
		icS.viewInoutTotal();
	}

}
