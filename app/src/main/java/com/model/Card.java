package com.model;

import java.io.Serializable;

public class Card implements Serializable {
    private int id;
    private String productName;
    private String imageLink;
    private int sellPrice;
    private int originPrice;
    private String color;
    private int productQuantity;
    private int quantity;
    private int totalPrice;
    private String createDate;

    public Card(int id, String productName, String imageLink, int sellPrice, int originPrice, String color, int productQuantity, int quantity, int totalPrice, String createDate) {
        this.id = id;
        this.productName = productName;
        this.imageLink = imageLink;
        this.sellPrice = sellPrice;
        this.originPrice = originPrice;
        this.color = color;
        this.productQuantity = productQuantity;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int getOriginPrice() {
        return originPrice;
    }

    public void setOriginPrice(int originPrice) {
        this.originPrice = originPrice;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", imageLink='" + imageLink + '\'' +
                ", sellPrice=" + sellPrice +
                ", originPrice=" + originPrice +
                ", color='" + color + '\'' +
                ", productQuantity=" + productQuantity +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", createDate='" + createDate + '\'' +
                '}';
    }
}
