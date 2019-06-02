/**
 * 
 */
package 深入浅出mybatis.第1章MyBatis简介;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @author clgao
 *
 */
public class MyBatisUtil {

	private static SqlSessionFactory sqlSessionFactory = null;
	
	public static SqlSessionFactory getSqlSessionFactory() {
		InputStream inputStream = null;
		if(sqlSessionFactory == null) {
			String source = "mybatis_config.xml";
			try {
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(source));
				return sqlSessionFactory;
			} catch (IOException e) {
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
		}
		return sqlSessionFactory;
	}
	
}
