package net.aptech.h3clothing.entity;

public enum Status {
    PENDING("Pending"), COMFIRMED("Comfirmed"), DELIVERING("Delivering"),DELIVERED("Delivered");
    private String value;
    Status(String pending) {
        this.value = pending;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
