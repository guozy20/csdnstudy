package com.guozy.example.rpc;

public class OrderSericeImpl implements IOrderService{
    @Override
    public String queryOrderList() {
        return "execute queryOrderList method";
    }

    @Override
    public String queryOrderInfoById(String id) {
        return "execute queryOrderInfoById method";
    }
}
