import dao.Db;
import dto.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

public class TestSession {
    SqlSession sqlSession= Db.getSqlSession();
    @Test
    public void testSe(){
        //断言返回非空
        Assert.assertNotNull(sqlSession);
    }
    @Test
    public void testFindOneById(){
        User user=sqlSession.selectOne("dao.IUserDao.findOneById",1);
        System.out.println(user);
    }
}
