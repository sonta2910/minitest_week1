package com.example.picture_management1.model;

public class Picture {
    private static Long INDEX = 0L;
    private Long id;
    private String pictureCode;
    private Double length;
    private Double width;
    private String material;
    private Double price;
    private String description;

    public Picture(Long id, String pictureCode, Double length, Double width, String material, Double price, String description) {
        this.id = ++INDEX;
        this.pictureCode = pictureCode;
        this.length = length;
        this.width = width;
        this.material = material;
        this.price = price;
        this.description = description;
    }

    public Picture(String pictureCode, Double length, Double width, String material, Double price, String description) {
        this.id=++INDEX;
        this.pictureCode = pictureCode;
        this.length = length;
        this.width = width;
        this.material = material;
        this.price = price;
        this.description = description;
    }

    public Picture() {
    }

    public static Long getINDEX() {
        return INDEX;
    }

    public static void setINDEX(Long INDEX) {
        Picture.INDEX = INDEX;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPictureCode() {
        return pictureCode;
    }

    public void setPictureCode(String pictureCode) {
        this.pictureCode = pictureCode;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

