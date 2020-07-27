package com.example.demo.core;

import com.example.demo.core.entity.ShipNode;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @date: 2020/7/27 11:11
 * @description:
 **/
public class ShipmentManament {

    private DecimalFormat decimalFormat = new DecimalFormat("0.00");
    private static int id = 1;
    private static ShipNode rootNode = null;

    public ShipmentManament() {
        super();
        rootNode = new ShipNode(100, 1F);
        rootNode.setLevel(1);
        rootNode.setId(id++);
    }

    /**
     * 节点拆分
     * @param node          要拆分的节点
     * @param proportions   拆分的比例
     */
    public void splitNode(ShipNode node, float...proportions) {
        //总值校验，比如：不允许将1.0拆分成0.5+0.6
        float total = 0F;
        List<ShipNode> nodes = new ArrayList<>();
        for (int i=0; i<proportions.length; i++) {
            float proportion = proportions[i];
            total += proportion;
            ShipNode childNode = new ShipNode(node.getQuality()*proportion, proportion);
            childNode.setId(id++);
            childNode.setLevel(node.getLevel() + 1);
            childNode.setParentNode(node);
            nodes.add(childNode);
        }
        total = Float.parseFloat(decimalFormat.format(total));
        if (total != node.getProportion()) {
            System.out.println("拆分后的比例" + total + "与要拆分节点的比例" + node.getProportion() + "不相等, 不允许操作！");
        }else {
            node.setChildNodes(nodes);
        }
    }

    /**
     * 合并任意多个节点为一个子节点
     * @param nodes
     */
    public void mergeNode(ShipNode...nodes) {
        if (nodes.length==1 && nodes[0].getLevel()==1) {
            System.out.println("不允许拆分根节点！");
            return;
        }
        float proportion = 0F;
        double quality = 0D;
        int maxLevel = 2;
        ShipNode mergedNode = new ShipNode();
        List<ShipNode> children = new ArrayList<>();
        children.add(mergedNode);
        for (int i=0; i<nodes.length; i++) {
            ShipNode node = nodes[i];
            maxLevel = node.getLevel() > maxLevel ? node.getLevel():maxLevel;
            proportion += node.getProportion();
            quality += node.getQuality();
            node.setChildNodes(children);
        }
        mergedNode.setId(id++);
        mergedNode.setLevel(maxLevel+1);
        mergedNode.setProportion(Float.parseFloat(decimalFormat.format(proportion)));
        mergedNode.setQuality(quality);
    }

    /**
     * 打印输出各个节点
     * @param node      要打印的节点
     * @param showChild 是否打印子节点
     */
    public void printNode(ShipNode node, boolean showChild) {
        System.out.println(node);
        if (showChild && node.getChildNodes() != null && node.getChildNodes().size() > 0) {
            node.getChildNodes().forEach(shipNode -> {
                printNode(shipNode, showChild);
            });
        }
    }

    /**
     * 增加或减少根节点的数量
     * @param rootNode
     * @param quality
     */
    public void updateRootNodeQuality(ShipNode rootNode, double quality) {
        rootNode.setQuality(Float.parseFloat(decimalFormat.format(rootNode.getProportion() * quality)));
        if (rootNode.getChildNodes()!=null && rootNode.getChildNodes().size() > 0) {
            rootNode.getChildNodes().forEach(shipNode -> {
                updateRootNodeQuality(shipNode, quality);
            });
        }
    }


    public ShipNode getRootNode() {
        return rootNode;
    }
}
