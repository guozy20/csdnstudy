package com.guozy.example.order;

public class OrderServiceImpl implements IOrderService {
    @Override
    public String queryOrderList() {
        return "execute queryOrderList method";
    }

    @Override
    public String queryOrderInfoById(String id) {
        return "execute queryOrderInfoById method";
    }
}
