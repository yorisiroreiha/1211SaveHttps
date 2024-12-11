package model;

import java.io.Serializable;

public class Card implements Serializable {
    private String storr;
    private String number;

    public Card() {}
    public Card(String storr, String number) {
        this.storr = storr;
        this.number = number;
    }

    public String getStorr() {
        return storr;
    }

    public void setStorr(String storr) {
        this.storr = storr;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return storr + number;
    }
}
