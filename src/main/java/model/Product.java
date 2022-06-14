package model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class Product {
    private int id;
    private String name;
    private String image;
    private BigDecimal price;
    private String title;
    private int statusId;
    private int categoryId;
    private int size;
    private int quantity;
    private boolean deleted;
    private String description;
    public Product(){

    }

    public Product(int id, String name, String image, BigDecimal price, String title, int statusId, int categoryId, int size, int quantity, boolean deleted, String description) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.title = title;
        this.statusId = statusId;
        this.categoryId = categoryId;
        this.size = size;
        this.quantity = quantity;
        this.deleted = deleted;
        this.description = description;
    }

    public Product(int id, String name, String image, BigDecimal price, String title, int statusId, int categoryId, int size, int quantity, boolean deleted) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.title = title;
        this.statusId = statusId;
        this.categoryId = categoryId;
        this.size = size;
        this.quantity = quantity;
        this.deleted = deleted;
    }

    public Product(int id, String name, String image, BigDecimal price, String title, int statusId, int categoryId, int size, int quantity) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.title = title;
        this.statusId = statusId;
        this.categoryId = categoryId;
        this.size = size;
        this.quantity = quantity;
    }

    public Product(String name, String image, BigDecimal price, String title, int statusId, int categoryId, int size, int quantity) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.title = title;
        this.statusId = statusId;
        this.categoryId = categoryId;
        this.size = size;
        this.quantity = quantity;
    }

    public Product(String name, String image, BigDecimal price, String title, int statusId, int categoryId, int size, int quantity, boolean deleted, String description) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.title = title;
        this.statusId = statusId;
        this.categoryId = categoryId;
        this.size = size;
        this.quantity = quantity;
        this.deleted = deleted;
        this.description = description;
    }

    public Product(String name, String image, BigDecimal price, String title, int statusId, int categoryId, int size, int quantity, String description) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.title = title;
        this.statusId = statusId;
        this.categoryId = categoryId;
        this.size = size;
        this.quantity = quantity;
        this.description = description;
    }

    public Product(int id, String name, String image, BigDecimal price, String title, int statusId, int categoryId, int size, int quantity, String description) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.title = title;
        this.statusId = statusId;
        this.categoryId = categoryId;
        this.size = size;
        this.quantity = quantity;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Length(min= 0 , max= 20, message = "Product name can not small than 0, Name product is to long (higher than 20 world")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull(message = "Link Image can not be empty please")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Min(value = 0,message = "Price must be bigger than 0")
    @Max(value = 10000, message = "Price is to high")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @NotEmpty(message = "Title can not empty")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @NotNull
    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }
    @NotNull
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @NotNull(message = "Size must be not empty")
    @Min(value = 0, message = "Size must bigger than 0")
    @Max(value = 60, message = "Size must small than 60")
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


    @Min(value = 0,message = "Quantity must be bigger than 0")
    @Max(value = 200, message = "Quantity can not bigger than 200")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @NotNull(message = "Product description must not be null please")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
