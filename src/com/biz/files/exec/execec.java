package com.biz.files.exec;

import java.io.*;

import com.biz.files.service.*;

public class execec {
	
public static void main(String[] args) {
	String readFile = "src/com/biz/files/service/우리말이름.txt";
	GradeService0001 g = new GradeService0001(readFile);
	g.readFile();
	g.makeNum();
	g.addNum();
	g.view();
	
}


}
