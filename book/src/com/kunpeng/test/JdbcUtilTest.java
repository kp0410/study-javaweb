package com.kunpeng.test;

import com.kunpeng.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

public class JdbcUtilTest {

    @Test
    public void testJdbcUtils() {
        for (int i = 0; i < 100; i++) {
            Connection connection = JdbcUtils.getConnection();
            System.out.println(connection);
            JdbcUtils.close(connection);
        }
    }
}
