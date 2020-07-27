package com.example.demo.core;

import com.example.demo.core.constant.SysConstant;
import com.example.demo.core.entity.Position;
import com.example.demo.core.entity.Transaction;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @date: 2020/7/23 22:04
 * @description:
 **/
public class PositionManagement {

    public void handleInput(List<Transaction> transactionList) {
        long startTime = System.currentTimeMillis();
        Map<String, Position> positionMap = new ConcurrentHashMap<>();
//        System.out.println("-----start-----");
//        System.out.println("Input: ");
        transactionList.forEach(transaction -> {
//            System.out.println(transaction);
            Position position = positionMap.get(transaction.getSecurityCode());
            //仅当insert时初始化数据，quantity默认为0
            if (position == null && transaction.getOperation().equals(SysConstant.operation_insert)) {

                position = new Position(transaction.getSecurityCode(), 0);

                if (transaction.getBuyOrSell().equals(SysConstant.action_buy)) {
                    position.setQuantity(position.getQuantity() + transaction.getQuantity());
                }else if (transaction.getBuyOrSell().equals(SysConstant.action_sell)) {
                    position.setQuantity(position.getQuantity() - transaction.getQuantity());
                }
                positionMap.put(transaction.getSecurityCode(), position);
            }
            if (position != null && !position.getClosed()) {
                //buy时添加quantity，sell时减去quantity
                if (transaction.getOperation().equals(SysConstant.operation_update)) {
                    if (transaction.getBuyOrSell().equals(SysConstant.action_buy)) {
                        position.setQuantity(0 + transaction.getQuantity());
                    }else if (transaction.getBuyOrSell().equals(SysConstant.action_sell)) {
                        position.setQuantity(0 - transaction.getQuantity());
                    }
                }else if(transaction.getOperation().equals(SysConstant.operation_insert)){
                    if (transaction.getBuyOrSell().equals(SysConstant.operation_insert)) {
                        position.setQuantity(position.getQuantity() + transaction.getQuantity());
                    }else if (transaction.getBuyOrSell().equals(SysConstant.action_sell)) {
                        position.setQuantity(position.getQuantity() - transaction.getQuantity());
                    }
                }else {
                    //cancel
                    position.setQuantity(0);
                    position.setClosed(Boolean.TRUE);
                }
            }
        });
        System.out.println("Output: ");
        System.out.println(positionMap.values());
//        System.out.println("-----end-----");
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }
}
