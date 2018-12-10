package com.biz.test.service;

import java.util.ArrayList;
import java.util.List;

import com.biz.test.vo.IoComeVO;

public class IoComeService03 {

	List<IoComeVO> ioList ;
	List<IoComeVO> inList;
	List<IoComeVO> outList;
	List<IoComeVO> insertList;
	
	public IoComeService03() {
		//TODO 서비스클래스 생성자
		ioList = new ArrayList();
		inList = new ArrayList();
		outList = new ArrayList();
		insertList = new ArrayList();
	}
	
	public void inOutInsert(IoComeVO vo) {
		//TODO 토탈 추가 부분
		int intSu = vo.getIntSu();
		int intDan = vo.getIntDan();
		
		int intTotal = intSu * intDan ;
		vo.setIntTotal(intTotal);
		ioList.add(vo);
	}
		
	public void sortInOut() {
		int intLen = ioList.size();
		for(int i = 0 ; i < intLen ; i ++) {
			if(ioList.get(i).getStrInOut().equals("매입")) {
				IoComeVO icv = ioList.get(i);
				inList.add(icv);
			} else {
				IoComeVO ocv = ioList.get(i);
				outList.add(ocv);
			}
		}
	}
	
	public void ioListPrint() {
		//TODO 매입or매출 나눠서 프린트 부분
		System.out.println();
		System.out.println("매입리스트");
		System.out.println("=====================================================================================");
		System.out.printf("%10s\t%2s\t%s\t%s\t%s\t%s\n", "거래일자", "구분", "품목", "수량", "단가", "합계");
		System.out.println("-------------------------------------------------------------------------------------");
		for(IoComeVO is : inList) {
			System.out.printf("%10s\t%2s\t%s\t%d\t%d\t%d\n",
					is.getStrDate(),
					is.getStrInOut(),
					is.getStrPum(),
					is.getIntSu(),
					is.getIntDan(),
					is.getIntTotal()
			);
		}
		System.out.println();
		
		System.out.println("매출리스트");
		System.out.println("=====================================================================================");
		System.out.printf("%10s\t%2s\t%s\t%s\t%s\t%s\n", "거래일자", "구분", "품목", "수량", "단가", "합계");
		System.out.println("-------------------------------------------------------------------------------------");
		for(IoComeVO os : outList) {
			System.out.printf("%10s\t%2s\t%s\t%d\t%d\t%d\n",
					os.getStrDate(),
					os.getStrInOut(),
					os.getStrPum(),
					os.getIntSu(),
					os.getIntDan(),
					os.getIntTotal()
			);
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
