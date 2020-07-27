package com.example.demo.core.entity;

import java.text.DecimalFormat;
import java.util.List;

/**
 * @date: 2020/7/27 11:08
 * @description:
 **/
public class ShipNode {

    private DecimalFormat decimalFormat = new DecimalFormat("0.00");

    private int id;
    private double quality;
    private float proportion;
    private int level;
    private ShipNode parentNode;
    private List<ShipNode> childNodes;

    public ShipNode() {
        super();
    }

    public ShipNode(double quality, float percent) {
        super();
        this.quality = quality;
        this.proportion = percent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getQuality() {
        return quality;
    }

    public void setQuality(double quality) {
        this.quality = quality;
    }

    public float getProportion() {
        return proportion;
    }

    public void setProportion(float proportion) {
        this.proportion = proportion;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<ShipNode> getChildNodes() {
        return childNodes;
    }

    public void setChildNodes(List<ShipNode> childNodes) {
        this.childNodes = childNodes;
    }

    public ShipNode getParentNode() {
        return parentNode;
    }

    public void setParentNode(ShipNode parentNode) {
        this.parentNode = parentNode;
    }

    @Override
    public String toString() {
        return "ShipNode{" +
                "id=" + id +
                ", quality=" + decimalFormat.format(quality) +
                ", proportion=" + decimalFormat.format(proportion) +
                ", level=" + level +
                '}';
    }
}
