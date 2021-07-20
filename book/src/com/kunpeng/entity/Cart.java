package com.kunpeng.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Cart implements Serializable {

    private Integer totalCount;

    private BigDecimal totalPrice;

    /**
     * key 是商品编号
     * value 是商品信息
     */
    private Map<Integer, CartItem> items = new LinkedHashMap<Integer, CartItem>();

    /**
     * 添加商品项
     *
     * @param cartItem
     */
    public void addItem(CartItem cartItem) {
        //查看购物车中是否已经田柾国此商品
        if (items.get(cartItem.getId()) == null)
            items.put(cartItem.getId(), cartItem);
        if (items.get(cartItem.getId()) != null){
         cartItem.setCount(items.get(cartItem.getId()).getCount() +1);
         cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())) *cartItem.getCount());
        }

    }

    /**
     * 删除商品项
     *
     * @param id
     */
    public void deleteItem(Integer id) {

    }

    /**
     * 清空购物车
     */
    public void clear() {

    }

    /**
     * 修改商品数量
     *
     * @param id
     */
    public void updateCount(Integer id, Integer count) {

    }


    public Cart() {
    }

    public Cart(Integer totalCount, BigDecimal totalPrice, List<CartItem> items) {
        this.totalCount = totalCount;
        this.totalPrice = totalPrice;
        this.items = items;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + totalCount +
                ", totalPrice=" + totalPrice +
                ", items=" + items +
                '}';
    }
}
