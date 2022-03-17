package com.Dinithm.ICBT.PRODUCT;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table
public class Product {

    @Id
    @SequenceGenerator(name="product_sequence",sequenceName = "product_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "product_sequence")

    private long product_id;
    private String name,discription,photopath,catagory;
    private float price;
    private byte[] quantitybranchcode=new byte[0x80];

    public Product(){};

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getPhotopath() {
        return photopath;
    }

    public void setPhotopath(String photopath) {
        this.photopath = photopath;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public byte[] getQuantitybranchcode() {
        return quantitybranchcode;
    }

    public void setQuantitybranchcode(byte[] quantitybranchcode) {
        this.quantitybranchcode = quantitybranchcode;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", name='" + name + '\'' +
                ", discription='" + discription + '\'' +
                ", photopath='" + photopath + '\'' +
                ", catagory='" + catagory + '\'' +
                ", price=" + price +
                ", quantitybranchcode=" + Arrays.toString(quantitybranchcode) +
                '}';
    }
}
