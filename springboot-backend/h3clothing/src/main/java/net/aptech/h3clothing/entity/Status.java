package net.aptech.h3clothing.entity;

public enum Status {
    PENDING("Pending"), COMFIRMED("Comfirmed"), DELIVERING("Delivering"),DELIVERED("Delivered");
    private String value;
    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
