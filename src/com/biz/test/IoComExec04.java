package com.biz.test;

import java.util.Scanner;

import com.biz.test.service.IoComeService04;
import com.biz.test.vo.IoComeVO;

public class IoComExec04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IoComeService04 icS = new IoComeService04(); 
		
		while(true) {
			IoComeVO vo = ioInsert();
			if(vo != null) {
				if(vo.getStrDate().equals("-1")) {
					System.out.println("종료합니다.");
					break;
				}
				if(vo.getIntDan() < 0 || vo.getIntSu() < 0) {
					System.out.println("단가나 수량 입력 오류");
					continue;
				}
				icS.inOutInsert(vo);
			}
		
		}
		
		icS.sortInOut();
		icS.ioListPrint();
		icS.viewInoutTotal();
	}

	public static IoComeVO ioInsert() {
		
		IoComeVO vo = new IoComeVO();
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("거래일자 (-1:종료)>> ");
		String strdate = scanner.nextLine();
		if(strdate.equals("-1")) {
			vo.setStrDate("-1");
			return vo;
		}
			
		System.out.print("구분 (매입 or 매출)>> ");
		String strInOut = scanner.nextLine();
			
		System.out.print("품목>> ");
		String strPum = scanner.nextLine();
			
		try {
			System.out.print("수량>> ");
			String strSu = scanner.nextLine();
			vo.setIntSu(-1);
			vo.setIntSu(Integer.valueOf(strSu));
			
			System.out.print("단가>> ");
			String strDan = scanner.nextLine();
			vo.setIntDan(-1);
			vo.setIntDan(Integer.valueOf(strDan));

			vo.setStrDate(strdate);
			vo.setStrInOut(strInOut);
			vo.setStrPum(strPum);
			vo.setIntSu(Integer.valueOf(strSu));
			vo.setIntDan(Integer.valueOf(strDan));
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("입력이 잘못되었습니다.");
//			return vo;
			
		}
		
		return vo;
	}
}
