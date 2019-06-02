/**
 * 
 */
package 深入浅出mybatis.第1章MyBatis简介;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import entity.Role;
import mapper.RoleMapper;

/**
 * 通过普通java代码的形式获取sqlsession,xml类型的参考MyBatisJavaUtil
 * @author clgao
 *
 */
public class MyBatisJavaUtil {

	private static SqlSessionFactory sqlSessionFactory;
	
	public static SqlSessionFactory getSqlSessionFactory() {
		
		//构建数据库连接池
		PooledDataSource dataSource = new PooledDataSource();
		dataSource.setDriver("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/test");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		//构建数据库事务方式
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		//创建了数据库运行环境
		Environment environment = new Environment("development", transactionFactory, dataSource);
		//构建Configuration
		Configuration configuration = new Configuration(environment);
		//注册一个MyBatis上下文别名
		configuration.getTypeAliasRegistry().registerAlias("role", Role.class);
//		设置sql语句相关。
//		configuration.addm
		//加入一个映射器
		configuration.addMapper(RoleMapper.class);
		//使用SqlSessionFactoryBuilder构建SqlSessionFactory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		return sqlSessionFactory;
	}
	
}
