package java疯狂讲义;

import java.io.IOException;
import java.net.InetAddress;

public class InetAddressTest {

	public static void main(String[] args) throws IOException {
		
		//根据主机名来获取对应的InetAddress实例
		InetAddress ip = InetAddress.getByName("www.clgao.com");
		//是否可达
		System.out.println(ip.isReachable(2000));
		System.out.println(ip.getCanonicalHostName());
		System.out.println(ip.getHostAddress());
		System.out.println(ip.getHostName());
	}

}
