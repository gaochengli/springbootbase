package redis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class RedisJava {

	public static void main(String[] args) {
		
//		Jedis jedis = new Jedis("localhost",6379);
		Jedis jedis = new Jedis("118.31.71.164",6379);
		System.out.println(jedis.ping());
//		jedis.set("gcl", "www.clgao.com");
//		System.out.println(jedis.get("gcl"));
		//redis java list(列表) 实例
		/*jedis.lpush("sitelist", "runoob");
		jedis.lpush("sitelist", "runoob1");
		jedis.lpush("sitelist", "runoob2");
		jedis.lpush("sitelist", "runoob3");
		jedis.lpush("sitelist", "runoob4");
		List<String> list = jedis.lrange("sitelist", 0, 4);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}*/
		//redis java keys 实例
		Set<String> keys = jedis.keys("*");
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(key);
		}
	}

}











































