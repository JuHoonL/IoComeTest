package com.biz.test;

import java.util.Scanner;

import com.biz.test.service.IoComeService04;
import com.biz.test.vo.IoComeVO;

public class IoComExec05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IoComeService04 icS = new IoComeService04(); 
		
		while(true) {
			IoComeVO vo = ioInsert();
			if(vo == null) break;
			icS.inOutInsert(vo);
		}
	}

	public static IoComeVO ioInsert() {
		
		IoComeVO vo = new IoComeVO();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("=====================================================================================");
		System.out.println("매입 & 매출장부");
		System.out.println("=====================================================================================");
		
		System.out.print("거래일자 (-1:종료)>> ");
		String strdate = scanner.nextLine();
		if(strdate.equals("-1")) {
			vo.setStrDate("-1");
			return null;
		}
			
		System.out.print("구분 (매입 or 매출)>> ");
		String strInOut = scanner.nextLine();
			
		System.out.print("품목>> ");
		String strPum = scanner.nextLine();
			
		System.out.print("수량>> ");
		String strSu = scanner.nextLine();
			
		System.out.print("단가>> ");
		String strDan = scanner.nextLine();

		vo.setStrDate(strdate);
		vo.setStrInOut(strInOut);
		vo.setStrPum(strPum);
		vo.setIntSu(Integer.valueOf(strSu));
		vo.setIntDan(Integer.valueOf(strDan));
		
		return vo;
	}
}
