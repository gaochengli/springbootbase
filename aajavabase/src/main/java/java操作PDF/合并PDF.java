package java操作PDF;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.multipdf.PDFMergerUtility;

public class 合并PDF {

	public static void main(String[] args) throws IOException {
		
		//
		PDFMergerUtility m = new PDFMergerUtility();
		//需要合并的pdf所在目录
		String folder = "W:\\专业学习\\主流技术汇总\\pdfbox\\java疯狂讲义pdfs";
		//目标文件
		String dfn = "W:\\专业学习\\主流技术汇总\\pdfbox\\合并后pdf\\多线程.pdf";
		String[] fs = getFiles(folder);
		for(int i=715;i<761;i++) {
			m.addSource(folder+File.separator+fs[i]);
			m.setDestinationFileName(dfn);
			m.mergeDocuments();
			System.out.println("合并成功！");
		}

	}

	private static String[] getFiles(String folder) throws IOException {
        File _folder = new File(folder);
        String[] filesInFolder;

        if (_folder.isDirectory()) {
            filesInFolder = _folder.list();
            return filesInFolder;
        } else {
            throw new IOException("Path is not a directory");
        }
    }

}
