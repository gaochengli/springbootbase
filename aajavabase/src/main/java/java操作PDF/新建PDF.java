package java操作PDF;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;

public class 新建PDF {

	public static void main(String[] args) throws IOException {
	
		String s = "W:\\专业学习\\主流技术汇总\\pdfbox\\合并后pdf\\多线程.pdf";
		PDDocument d = new PDDocument();
		d.save(new File(s));
		d.close();
	}

}
