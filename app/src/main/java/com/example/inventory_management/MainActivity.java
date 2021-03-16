package com.example.inventory_management;

import android.graphics.Color;
import android.graphics.Path;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.TabHost;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TabItem t1;
    final static String PATH= Environment.getExternalStorageDirectory().getAbsolutePath()+"/Test/",FNAME="test.txt";
    static String[][]arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        t1=findViewById(R.id.t_Default);
//        t1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                t1.setBackgroundColor(Color.rgb(20,20,20));
//            }
//        });

//      Create / Set
        ViewPager vp=findViewById(R.id.view_pager);
        VPAdapter ad=new VPAdapter(getSupportFragmentManager(),0);
        vp.setAdapter(ad);

//        Peristalsis
        TabLayout tab=findViewById(R.id.tab);
        tab.setupWithViewPager(vp);

//        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
//        ViewPager viewPager = findViewById(R.id.view_pager);
//        viewPager.setAdapter(sectionsPagerAdapter);
//        TabLayout tabs = findViewById(R.id.tabs);
//        tabs.setupWithViewPager(viewPager);
//        FloatingActionButton fab = findViewById(R.id.fab);
//
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        // 2-1. text Write test
        Log.d("PATH - ",PATH);
        try{
            File dir=new File(PATH);
            if(!dir.exists())dir.mkdir();
            FileOutputStream fs=new FileOutputStream(PATH+FNAME,true);
            BufferedWriter w=new BufferedWriter(new OutputStreamWriter(fs));
            w.write("test file write");
            w.flush();
            w.close();
            fs.close();
            Log.d("Write - ","write comp");
        }catch (Exception e){
            Log.d("Write - ","write fail");
            e.printStackTrace();
        }
        Log.d("Text - ","write comp");

//        StringBuffer f=new StringBuffer();
//        try{
//            InputStream is=new FileInputStream(PATH);
//            BufferedReader r=new BufferedReader(new InputStreamReader(is));
//            String l="";
//            while((l=r.readLine())!=null)f.append(l+"\n");
//            r.close();
//            is.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        Log.d("Read Text - ",f.toString());

    }

}