package com.biz.test;

import java.util.Scanner;

import com.biz.test.service.IoComeService06;
import com.biz.test.vo.IoComeVO;

public class IoComExec06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IoComeService06 icS = new IoComeService06();
		Scanner scanner = new Scanner(System.in);
		
		
		IoComeVO vo = new IoComeVO();
		
		icS.inOutInsert(vo);
			
		icS.ioListPrint();
		
		icS.viewInoutTotal();
	}

}
