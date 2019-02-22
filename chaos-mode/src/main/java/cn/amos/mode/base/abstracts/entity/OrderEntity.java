package cn.amos.mode.base.abstracts.entity;

import java.math.BigDecimal;

/**
 * PROJECT: chaos
 * DESCRIPTION: 订单
 *
 * @author Daoyuan
 * @date 2019/2/21
 */
public class OrderEntity extends BaseEntity {

    /**
     * 用户id
     */
    private String userId;
    /**
     * 商品编码
     */
    private String commodityCode;
    /**
     * 数量
     */
    private Integer count;
    /**
     * 价格
     */
    private BigDecimal price;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
