package com.example.inventory_management;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.inventory_management.Fragment_Def;
import com.example.inventory_management.Fragment_Fre;
import com.example.inventory_management.Fragment_Sau;

import java.util.ArrayList;

public class VPAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> items;
    private ArrayList<String> itexts=new ArrayList<>();
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return itexts.get(position);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return items.get(position);
    }


    public VPAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        items=new ArrayList<>();
        items.add(new Fragment_Def());
        items.add(new Fragment_Fre());
        items.add(new Fragment_Sau());

        itexts.add("기본재료");
        itexts.add("신선식품");
        itexts.add("소스류");
    }

    @Override
    public int getCount() {
        return items.size();
    }
}
