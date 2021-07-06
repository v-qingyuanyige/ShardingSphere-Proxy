package cn.vtrump.shardingproxydemo;

import cn.vtrump.shardingproxydemo.mapper.OrderMapper;
import cn.vtrump.shardingproxydemo.pojo.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@SpringBootTest
class ShardingProxyDemoApplicationTests {

    @Autowired
    OrderMapper orderMapper;

    @Test
    @Transactional(rollbackFor = Exception.class)
    public void insert() throws SQLException {
        for(long i = 0; i < 10; i++){
            Order order = new Order(i, i);
            orderMapper.addOrder(order);
        }
        throw new SQLException("SQL Exception Occur");
    }

//    @Test
//    void select(){
//        orderMapper.selectAll();
//    }
}
