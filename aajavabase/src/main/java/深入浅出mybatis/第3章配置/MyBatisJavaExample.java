/**
 * 
 */
package 深入浅出mybatis.第3章配置;

import org.apache.ibatis.session.SqlSession;

import entity.Role;
import mapper.RoleMapper;

/**
 * @author clgao
 * 通过java进行sqlSession的创建
 */
public class MyBatisJavaExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		SqlSession sqlSession = null;
		
		try {
			sqlSession = SqlSessionFactoryUtil.openSqlSession();
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			Role role = roleMapper.getRole(1L);
			System.out.println("role_name:" + role.getRoleName());
		} finally {
			sqlSession.close();
		}

	}

}
