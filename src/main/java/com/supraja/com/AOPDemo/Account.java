package com.supraja.com.AOPDemo;

public class Account {
    private String name;
    public String level;

    public Account() {
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", level='" + level + '\'' +
                '}';
    }

    public Account(String name, String level) {
        this.name = name;
        this.level = level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
