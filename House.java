package com.hspedu.houserent.domain;

public class House {
    private int id;
    private String name;//姓名
    private String phone;//电话号码
    private String address;//地址
    private int rent;//月租
    private String state;//出租状态(未出租/已出租)

    public House(int id, String name, String phone, String address, int rent, String state) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.rent = rent;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public House() {
        super();
    }

    @Override
    public String toString() {
        return  id +
                "\t\t" + name  +
                "\t" + phone +
                "\t\t" + address +
                "\t" + rent +
                "\t" + state  ;
    }
}
