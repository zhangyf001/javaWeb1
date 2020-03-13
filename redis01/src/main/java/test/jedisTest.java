package test;

import redis.clients.jedis.Jedis;

public class jedisTest {
	public static void main(String[] args) {
		Jedis jedis=new Jedis("192.168.10.103",6379);
		jedis.auth("123456");
		jedis.set("name", "张三丰");
		String value=jedis.get("name");
		System.out.println(value);
		jedis.close();
	}
}
