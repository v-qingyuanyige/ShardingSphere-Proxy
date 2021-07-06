package cn.vtrump.shardingproxydemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
    long order_id;
    long user_id;
}
