package com.biz.test;

import java.util.Scanner;

import com.biz.test.service.IoComeService01;
import com.biz.test.vo.IoComeVO;

public class IoComExec01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IoComeService01 icS = new IoComeService01();
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			
			IoComeVO vo = new IoComeVO();
		
			System.out.println("거래일자 (XXXX-XX-XX형식)");
			System.out.print(">> ");
			String strdate = scanner.nextLine();
			vo.setStrDate(strdate);
			
			System.out.println("구분 (매입 or 매출)");
			System.out.print(">> ");
			String strInOut = scanner.nextLine();
			vo.setStrInOut(strInOut);
			
			System.out.println("품목");
			System.out.print(">> ");
			String strPum = scanner.nextLine();
			vo.setStrPum(strPum);
			
			System.out.println("수량");
			System.out.print(">> ");
			String strSu = scanner.nextLine();
			vo.setIntSu(Integer.valueOf(strSu));
			
			System.out.println("단가");
			System.out.print(">> ");
			String strDan = scanner.nextLine();
			vo.setIntDan(Integer.valueOf(strDan));
			
			icS.inOutInsert(vo);
			
			System.out.println("입력을 끝내시겠습니까?");
			System.out.print("(네 or 계속하시려면 아무키 입력) >> ");
			String strTheEnd = scanner.nextLine();
			if(strTheEnd.equals("네")) break;
			
		}
		
		icS.sortInOut();
		
		icS.ioListPrint();
		
		icS.viewInoutTotal();
	}

}
