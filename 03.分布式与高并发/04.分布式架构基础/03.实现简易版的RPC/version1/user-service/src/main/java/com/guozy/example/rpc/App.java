package com.guozy.example.rpc;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        IOrderService orderService = null;
        orderService.queryOrderList();
        System.out.println( "Hello World!" );
    }
}
