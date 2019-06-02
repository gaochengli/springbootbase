package 日志;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Java原生日志 {
	static Logger log = Logger.getLogger("javasoft");
	static LogManager logManager = LogManager.getLogManager();
	public static void main(String[] args) throws IOException, InterruptedException {
		InputStream is = ClassLoader.getSystemResourceAsStream("gcllog.properties");
		logManager.readConfiguration(is);
		logManager.addLogger(log);
//		log.
		log.warning("红色的日志！！");
		Thread.sleep(1000);
		log.severe("红色的日志！！");
		Thread.sleep(1000);
		log.config("红色的日志！！");
		Thread.sleep(1000);
		log.info("红色的日志！！");
		Thread.sleep(1000);
		log.fine("红色的日志！！");
		Thread.sleep(1000);
		log.finer("红色的日志！！");
		Thread.sleep(1000);
		log.finest("红色的日志！！");
	}

}
