/**
 * 
 */
package 深入浅出mybatis.第1章MyBatis简介;

import org.apache.ibatis.session.SqlSession;

import entity.Role;
import mapper.RoleMapper;

/**
 * @author clgao
 *
 */
public class MyBatisExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			Role role = roleMapper.getRole(1L);
			System.out.println("role_name:" + role.getRoleName());
		} finally {
			sqlSession.close();
		}
	}

}
