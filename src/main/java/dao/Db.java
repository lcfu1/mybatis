package dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//数据库连接公共类
public class Db {
    // 类成员变量
    private static SqlSession sqlSession;

    //私有构造
    private Db() {
    }

    //静态代码块
    static {
        String res = "config/mybatis.xml";
        try {
            //以文件流方式读取配置信息
            InputStream inputStream = Resources.getResourceAsStream(res);
            //用SessionFactoryBuilder方式构建SqlSessionFactory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //从工厂中获取会话连接
            sqlSession = sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //返回连接
    public static SqlSession getSqlSession() {
        return sqlSession;
    }

}