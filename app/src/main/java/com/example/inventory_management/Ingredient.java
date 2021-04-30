package com.example.inventory_management;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Ingredient {
    final static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    List<Date>W_date;
    List<Integer>W_count;
    String name;
    int count,W_index;
    boolean checked;

    Ingredient(String n, int c){
        name=n;
        count=c;
        W_index=0;
        W_date=new ArrayList();
        W_count=new ArrayList();
    }

    public static SimpleDateFormat getFormat() {
        return format;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                ", name='" + name + '\'' +
                ", count=" + count +
                "W_date=" + W_date +
                ", W_count=" + W_count +
                ", W_index=" + W_index +
                ", checked=" + checked +
                '}';
    }
}
