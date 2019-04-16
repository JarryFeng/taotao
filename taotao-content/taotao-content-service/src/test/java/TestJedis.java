import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author fengzheng
 * @date 2019/4/16
 * @describe
 */
public class TestJedis {

    @Test
    public void testJedis(){
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.set("hello", "jedis");
        System.out.println(jedis.get("hello"));

        jedis.close();
    }

    @Test
    public void testJedisPool(){

        //创建数据库连接池(单例)，需要指定服务的ip和端口
        JedisPool jedisPool = new JedisPool("127.0.0.1", 6379);
        //从连接池中获取连接
        Jedis jedis = jedisPool.getResource();
        //使用Jedis操作数据库(方法级别使用)
        String result = jedis.get("hello");
        //要关闭jedis连接，否则无法被数据库连接池回收
        jedis.close();
        //系统关闭前关闭连接池
        jedisPool.close();

    }
}
