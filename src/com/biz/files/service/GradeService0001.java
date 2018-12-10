package com.biz.files.service;

import java.io.*;
import java.util.*;

import com.biz.files.vo.*;

public class GradeService0001 {
	List<GradeVO> gradeList;
	List<String> strNumList;
	String strFileName;


	public GradeService0001(String strFileName) {
		this.strFileName = strFileName;
		gradeList = new ArrayList();
		strNumList = new ArrayList();
	}
	
	public void makeScore() {
		GradeVO vo = new GradeVO();
		vo.setIntKor((int)(Math.random()*(100-50+1))+1);
		vo.setIntEng((int)(Math.random()*(100-50+1))+1);
		vo.setIntMath((int)(Math.random()*(100-50+1))+1);
		vo.setIntSum(vo.getIntKor()+vo.getIntEng()+vo.getIntMath());
		int intSum = vo.getIntKor()+vo.getIntEng()+vo.getIntMath();
		float floatAvg = (float)intSum / 3;
		
	}
	
	
	public void view() {
//		GradeVO vo = new GradeVO();
		System.out.println("==========================");
		System.out.println("학번\t 이름\t 국어\t 영어\t 수학\t 총점\t 평균\t");
		System.out.println("--------------------------");
		for(GradeVO vo : gradeList) {
		System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%f\n", vo.getStrNum(),vo.getStrName(),
				vo.getIntKor(),vo.getIntEng(),vo.getIntMath(),vo.getIntSum(),vo.getFloatAvg());
		
			
		
		}
		
	}
	
	public void addNum() {
		for (int i = 0; i < gradeList.size(); i++) {
			GradeVO vo = gradeList.get(i);
			String strnum = strNumList.get(i);
			vo.setStrNum(strnum);
			
					
			//			gradeList.get(i).setStrNum(strNumList.get(i));
		}
	}

	public void makeNum() {
		int siz = gradeList.size();
		for (int i = 0; i < siz; i++) {
			int intnum = i+1;
			strNumList.add(String.valueOf(intnum));
		}

	}

	public void readFile() {
		FileReader fr;
		BufferedReader buffer;
		try {
			
			fr = new FileReader(this.strFileName);
			buffer = new BufferedReader(fr);

			while (true) {

				String line = buffer.readLine();
				if (line == null)
					break;

				String[] lines = line.split(":");
				GradeVO vo = new GradeVO();

				vo.setStrName(lines[0]);
				gradeList.add(vo);

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}