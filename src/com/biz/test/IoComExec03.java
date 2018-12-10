package com.biz.test;

import java.util.ArrayList;

import com.biz.test.service.IoComeService03;
import com.biz.test.vo.IoComeVO;

public class IoComExec03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IoComeService03 icS = new IoComeService03(); 
		
		IoComeVO vo = new IoComeVO();
		vo.setStrDate("2018-12-10");
		vo.setStrInOut("매입");
		vo.setStrPum("새우탕");
		vo.setIntSu(50);
		vo.setIntDan(1350);
		
		icS.inOutInsert(vo);
		
		IoComeVO v1 = new IoComeVO();
		v1.setStrDate("2018-12-10");
		v1.setStrInOut("매출");
		v1.setStrPum("튀김우동");
		v1.setIntSu(70);
		v1.setIntDan(1350);
		
		icS.inOutInsert(v1);
		
		IoComeVO v2 = new IoComeVO();
		v2.setStrDate("2018-12-10");
		v2.setStrInOut("매출");
		v2.setStrPum("새콤달콤");
		v2.setIntSu(120);
		v2.setIntDan(800);
		
		icS.inOutInsert(v2);
		
		IoComeVO v3 = new IoComeVO();
		v3.setStrDate("2018-12-10");
		v3.setStrInOut("매출");
		v3.setStrPum("생생우동");
		v3.setIntSu(10);
		v3.setIntDan(1500);
		
		icS.inOutInsert(v3);
		
		IoComeVO v4 = new IoComeVO();
		v4.setStrDate("2018-12-10");
		v4.setStrInOut("매입");
		v4.setStrPum("아이셔");
		v4.setIntSu(50);
		v4.setIntDan(1000);
		
		icS.inOutInsert(v4);
		
		IoComeVO v5 = new IoComeVO();
		v5.setStrDate("2018-12-10");
		v5.setStrInOut("매출");
		v5.setStrPum("헤이즐럿");
		v5.setIntSu(30);
		v5.setIntDan(1100);
		
		icS.sortInOut();
		
		icS.ioListPrint();
		
		icS.viewInoutTotal();
		
	}

}
