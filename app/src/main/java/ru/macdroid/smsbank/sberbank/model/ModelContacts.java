package ru.macdroid.smsbank.sberbank.model;

import android.content.Context;

import java.util.ArrayList;

public class ModelContacts {

    String name, number;

    public ModelContacts(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }
}
