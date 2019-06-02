package java操作PDF;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;

public class 分割PDF {

	public static void main(String[] args) throws IOException {
		
		File file = new File("W:\\专业学习\\文档类资料\\《疯狂Java讲义(第3版)》.pdf");
		PDDocument document = PDDocument.load(file);
		//创建一个分割器
		Splitter splitter = new Splitter();
		//一个Page的List获取每一页
		List<PDDocument> pages = splitter.split(document);
		Iterator<PDDocument> it = pages.listIterator();
		int i = -27;
		while(it.hasNext()) {
			PDDocument pd = it.next();
			System.out.println(pd.toString());
			pd.save("W:\\专业学习\\主流技术汇总\\pdfbox\\java疯狂讲义pdfs\\java疯狂讲义"+i+".pdf");
			i++;
		}
		

	}

}
