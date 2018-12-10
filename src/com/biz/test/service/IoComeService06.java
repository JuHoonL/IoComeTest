package com.biz.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.biz.test.vo.IoComeVO;

public class IoComeService06 {

	List<IoComeVO> ioList ;
	List<IoComeVO> inList;
	List<IoComeVO> outList;
	
	public IoComeService06() {
		//TODO 서비스클래스 생성자
		ioList = new ArrayList();
		inList = new ArrayList();
		outList = new ArrayList();
	}
	
	public void inOutInsert(IoComeVO vo) {
		//TODO 토탈 추가 부분
		Scanner scanner = new Scanner(System.in);
		IoComeVO insertVO = vo;
		
		while(true) {
			insertVO = new IoComeVO();
			System.out.println("거래일자 (XXXX-XX-XX형식)");
			System.out.print(">> ");
			String strdate = scanner.nextLine();
			insertVO.setStrDate(strdate);
				
			System.out.println("구분 (매입 or 매출)");
			System.out.print(">> ");
			String strInOut = scanner.nextLine();
			insertVO.setStrInOut(strInOut);
				
			System.out.println("품목");
			System.out.print(">> ");
			String strPum = scanner.nextLine();
			insertVO.setStrPum(strPum);
				
			System.out.println("수량");
			System.out.print(">> ");
			String strSu = scanner.nextLine();
			insertVO.setIntSu(Integer.valueOf(strSu));
				
			System.out.println("단가");
			System.out.print(">> ");
			String strDan = scanner.nextLine();
			insertVO.setIntDan(Integer.valueOf(strDan));
				
			int intSu = insertVO.getIntSu();
			int intDan = insertVO.getIntDan();
			int intTotal = intSu * intDan ;
			insertVO.setIntTotal(intTotal);
			
			ioList.add(insertVO);
			
			System.out.println("입력을 끝내시겠습니까?");
			System.out.print("(네 or 계속하시려면 아무키 입력) >> ");
			String strTheEnd = scanner.nextLine();
			if(strTheEnd.equals("네")) break;
		}
	}
	
	public void ioListPrint() {
		//TODO 매입or매출 나눠서 프린트 부분
		int intLen = ioList.size();
		for(int i = 0 ; i < intLen ; i ++) {
			if(ioList.get(i).getStrInOut().equals("매입")) {
				inList.add(ioList.get(i));
			} else {
				outList.add(ioList.get(i));
			}
		}
		System.out.println("매입리스트");
		System.out.println("=====================================================================================");
		System.out.print("거래일자 \t\t구분 \t품목 \t수량 \t단가 \t합계 \n");
		System.out.println("-------------------------------------------------------------------------------------");
		for(IoComeVO is : inList) {
			System.out.print(is.getStrDate() + "\t");
			System.out.print(is.getStrInOut() + "\t");
			System.out.print(is.getStrPum() + "\t");
			System.out.print(is.getIntSu() + "\t");
			System.out.print(is.getIntDan() + "\t");
			System.out.println(is.getIntTotal());
		}
		System.out.println();
		
		System.out.println("매출리스트");
		System.out.println("=====================================================================================");
		System.out.print("거래일자 \t\t구분 \t품목 \t수량 \t단가 \t합계 \n");
		System.out.println("-------------------------------------------------------------------------------------");
		for(IoComeVO os : outList) {
			System.out.print(os.getStrDate() + "\t");
			System.out.print(os.getStrInOut() + "\t");
			System.out.print(os.getStrPum() + "\t");
			System.out.print(os.getIntSu() + "\t");
			System.out.print(os.getIntDan() + "\t");
			System.out.println(os.getIntTotal());
		}
	}
	
	public void view() {
		for(IoComeVO v : ioList) {
			System.out.print(v.getStrDate() + "\t");
			System.out.print(v.getStrInOut() + "\t");
			System.out.print(v.getStrPum() + "\t");
			System.out.print(v.getIntSu() + "\t");
			System.out.print(v.getIntDan() + "\t");
			System.out.println(v.getIntTotal());
		}
	}
	
	public void viewInoutTotal() {
		int intinSum = 0;
		int intoutSum = 0;
		
		for(IoComeVO is : inList) {
			intinSum += is.getIntTotal();
		}
		
		for(IoComeVO os : outList) {
			intoutSum += os.getIntTotal();
		}
		System.out.println();
		System.out.println("=====================================================================================");
		System.out.println("총 매입 합계 : " + intinSum + "원");
		System.out.println("총 매출 합계 : " + intoutSum + "원");
		System.out.println("이익금 : " + (intoutSum - intinSum) + "원");
		System.out.println("=====================================================================================");
	}
}
