package net.ukr.FANT0Mas;

public class Flat {
    private int FlatId;
    private String area;
    private String address;
    private double square;
    private int numRooms;
    private double price;

    public Flat() {
    }

    public Flat(int FlatId, String area, String address, double square, int numRooms, double price) {
        this.FlatId = FlatId;
        this.area = area;
        this.address = address;
        this.square = square;
        this.numRooms = numRooms;
        this.price = price;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public int getNumRooms() {
        return numRooms;
    }

    public void setNumRooms(int numRooms) {
        this.numRooms = numRooms;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getFlatId() {
        return FlatId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setFlatId(int flatId) {
        FlatId = flatId;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "FlatId=" + FlatId +
                ", area='" + area + '\'' +
                ", address='" + address + '\'' +
                ", square=" + square +
                ", numRooms=" + numRooms +
                ", price=" + price +
                '}';
    }
}
