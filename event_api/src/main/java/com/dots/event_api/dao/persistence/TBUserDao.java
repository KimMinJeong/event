package com.dots.event_api.dao.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TBUserDao {
    @Autowired
    private SqlSession sqlSession;

    public String selectOne(){
        return sqlSession.selectOne("com.dots.event_api.selectName");
    }
}
