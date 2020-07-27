package com.example.demo.core;

import com.example.demo.core.entity.ShipNode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** 
* ShipmentManament Tester. 
* 
* @since <pre>七月 27, 2020</pre>
* @version 1.0 
*/ 

public class ShipmentManamentTest { 

    @Before
    public void before() throws Exception { 
    } 

    @After
    public void after() throws Exception { 
    } 

    @Test
    public void testShipNode() {
        System.out.println("ShipmentManamentTest start...");

        ShipmentManament shipment = new ShipmentManament();
        ShipNode rootNode = shipment.getRootNode();
        System.out.println("Init:");
        System.out.println(rootNode);
        //拆分
        //shipment.splitNode(rootNode, 0.1F, 0.3F, 0.3F);

        shipment.splitNode(rootNode, 0.1F, 0.3F, 0.3F, 0.3F);
        System.out.println("拆分(split)后的节点：");
        shipment.printNode(rootNode, true);

        shipment.mergeNode(rootNode.getChildNodes().get(0), rootNode.getChildNodes().get(1), rootNode.getChildNodes().get(2));
        System.out.println("合并(merge)后的节点：");
        shipment.printNode(rootNode, true);

        shipment.updateRootNodeQuality(rootNode, 300);
        System.out.println("增加数目后的节点：");
        shipment.printNode(rootNode, true);

        shipment.updateRootNodeQuality(rootNode, 50);
        System.out.println("减少数目后的节点：");
        shipment.printNode(rootNode, true);

        System.out.println("ShipmentManamentTest end...");
    }
}
