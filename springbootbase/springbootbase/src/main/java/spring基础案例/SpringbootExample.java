package spring基础案例;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.opensagres.odfdom.converter.core.utils.IOUtils;
import fr.opensagres.poi.xwpf.converter.xhtml.XHTMLConverter;
import fr.opensagres.poi.xwpf.converter.xhtml.XHTMLOptions;
import fr.opensagres.xdocreport.document.json.JSONObject;

@RestController
@EnableAutoConfiguration
public class SpringbootExample {

	@RequestMapping("/")
	String home() {
		System.out.println("jlkl");
		return "Hello World!";
	}
	@RequestMapping("/uploadjsp")
	String uploadjsp() {
		System.out.println("jlkl");
		return "/UploadCommon.jsp";
	}
	@RequestMapping("/gcl")
	String gcl() {
		return "郜成立!";
	}
	@PostMapping("/upload")
	@ResponseBody
	public String upload(HttpServletRequest req) throws UnsupportedEncodingException {
		req.setCharacterEncoding("UTF-8");
//		res.setCharacterEncoding("UTF-8");
//		res.setContentType("application/json");
		String ip = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort();
		String webPath = req.getSession().getServletContext().getRealPath("upload/images/");
//		res.setHeader("Access-Control-Allow-Origin", ip);
//		res.setHeader("Access-Control-Allow-Headers", "X-Request-With,X_Requested_With");
		JSONObject json = new JSONObject();
//		PrintWriter out = res.getWriter();
		DiskFileItemFactory  factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(1024*1024*50);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			@SuppressWarnings("unchecked")
			List<FileItem> items = upload.parseRequest(req);
			items.forEach(item->{
				item.getName();
				try {
					XWPFDocument document = new XWPFDocument(item.getInputStream());
					XHTMLOptions options = XHTMLOptions.create();
					 // 存放图片的文件夹 
					File rootPath = new File(webPath);
					if(!rootPath.exists()) {
						rootPath.mkdirs();
					}
					List<XWPFPictureData> pictures = document.getAllPictures();
//			        options.setExtractor(new FileImageExtractor(rootPath)); 
//			        options.URIResolver(new BasicURIResolver("upload/image")); 
			        XHTMLConverter xhtmlConverter = (XHTMLConverter) XHTMLConverter.getInstance(); 
			        xhtmlConverter.convert(document, baos, options); 
			        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			        String html = IOUtils.toString(bais, "UTF-8");
			        for(XWPFPictureData picture : pictures) {
			        	String uuid = UUID.randomUUID().toString();
			        	System.out.println(picture.getPackagePart());
			        	String oldpicturesrc = "word/media/"+picture.getFileName();
			        	try {
			        		String newpicturesrc = "upload/images/"+uuid+".jpg";
			        		html = html.replace(oldpicturesrc, newpicturesrc);
				        	System.out.println(html);
							FileOutputStream fos = new FileOutputStream(webPath+uuid+".jpg");
							fos.write(picture.getData());
							fos.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
			        }
			        System.out.println(html);
			        json.put("html", html);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		return json.toString();
	}
	
}
