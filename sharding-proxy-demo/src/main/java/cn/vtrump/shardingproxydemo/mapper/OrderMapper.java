package cn.vtrump.shardingproxydemo.mapper;

import cn.vtrump.shardingproxydemo.pojo.Order;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface OrderMapper {

    @Results({
            @Result(column = "order_id",jdbcType = JdbcType.BIGINT,property = "order_id"),
            @Result(column = "user_id",jdbcType = JdbcType.BIGINT,property = "user_id")
    })

    @Insert("insert into t_order(order_id, user_id) values(#{order_id}, #{user_id}")
    boolean addOrder(Order student);

    @Select("select * from t_order")
    List<Order> selectAll();
}
