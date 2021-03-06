package com.example.inventory_management;

import android.annotation.SuppressLint;
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
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TabItem t1;
    static Button add,close,delete;
    static String str;
    final static String PATH = Environment.getExternalStorageDirectory().getAbsolutePath();
    static String[][] arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("PATH",PATH);
        Log.d("Gravity-lef", ""+Gravity.LEFT);
        Log.d("Gravity-cen", ""+Gravity.CENTER);
        Log.d("Gravity-rig", ""+Gravity.RIGHT);
//        Log.d("getPackageName",getPackageName());
//        Log.d("getPackageCodePath",getPackageCodePath());
//        Log.d("PackageResourcePath",getPackageResourcePath());

        textRead();

        add=findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment_Def.addItem();
            }
        });

        close=findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textWrite();
            }
        });

        delete=findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

//        t1=findViewById(R.id.t_Default);
//        t1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                t1.setBackgroundColor(Color.rgb(20,20,20));
//            }
//        });

//      Create / Set
        ViewPager vp = findViewById(R.id.view_pager);
        VPAdapter ad = new VPAdapter(getSupportFragmentManager(), 0);
        vp.setAdapter(ad);

//        Peristalsis
        TabLayout tab = findViewById(R.id.tab);
        tab.setupWithViewPager(vp);

//        ????????? ??????
//        ???????????? ?????? ????????? ????????? ??????
//        ?????? ?????? ?????? https://developer.android.com/studio/debug/device-file-explorer?hl=ko
//        Log.d("contextPath:", getApplicationContext().toString());
//        Log.d("Write test ...", "go");
//        if (textWrite()) {
//            Log.d("Read test ...", "go");
//            FileInputStream fis = null;
//            try {
//                fis = openFileInput("test.txt");
//                byte[] file = new byte[fis.available()];
//                fis.read(file);
//                fis.close();
//                String str = new String(file,"EUC-KR");
//                Log.d("Read test ...", "comp");
//                Log.d("Read Result ...", str);
//            } catch (Exception e) {
//                Log.d("Read test ...", "fail");
//                e.printStackTrace();
//            }
//        }

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
//        Log.d("PATH - ",PATH);
//        try{
//            File dir=new File(PATH);
//            if(!dir.exists())dir.mkdir();
//            FileOutputStream fs=new FileOutputStream(PATH+FNAME,true);
//            BufferedWriter w=new BufferedWriter(new OutputStreamWriter(fs));
//            w.write("test file write");
//            w.flush();
//            w.close();
//            fs.close();
//            Log.d("Write - ","write comp");
//        }catch (Exception e){
//            Log.d("Write - ","write fail");
//            e.printStackTrace();
//        }
//        Log.d("Text - ","write comp");
//        2-1. fail

        /* ?????? */
////        // 2-2. text Write test | https://github.com/nn98/Diary_Final/blob/master/app/src/main/java/com/example/jkllh/diary_final/MainActivity.java
//        Log.d("contextPath:", getApplicationContext().toString());
//        Log.d("Write test ...", "go");
//        if (textWrite()) {
//            Log.d("Read test ...", "go");
//            FileInputStream fis = null;
//            try {
//                fis = openFileInput("test.txt");
//                byte[] file = new byte[fis.available()];
//                fis.read(file);
//                fis.close();
//                String str = new String(file,"EUC-KR");
//                Log.d("Read test ...", "comp");
//                Log.d("Read Result ...", str);
//            } catch (Exception e) {
//                Log.d("Read test ...", "fail");
//                e.printStackTrace();
//            }
//        }
//        /*
//        D/Write??test??...: go
//        D/Write??test??...: comp
//        D/Read??test??...: go
//        D/Read??test??...: comp
//        D/Read??Result??...: ??????????????????????????????????????????????????????
//        ?????? ??????? ????????? ??????
//         */

//        // 2-3. `` | https://yeolco.tistory.com/32
//        /////////////////////// ?????? ?????? ///////////////////////
//        String str = "Test";
//// ?????? ??????
//        File saveFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/camdata"); // ?????? ??????
//// ?????? ??????
//        if(!saveFile.exists()){ // ?????? ?????? ??????
//            saveFile.mkdir(); // ?????? ??????
//        }
//        Log.d("FileDir",saveFile.toString());
//        try {
//            long now = System.currentTimeMillis(); // ???????????? ????????????
//            Date date = new Date(now); // Date ?????? ??????
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            String nowTime = sdf.format(date);
//
//            BufferedWriter buf = new BufferedWriter(new FileWriter(saveFile+"/CarnumData.txt", true));
//            buf.append(nowTime + " "); // ?????? ??????
//            buf.append(str); // ?????? ??????
//            buf.newLine(); // ??????
//            buf.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        /////////////////////// ?????? ?????? ///////////////////////
//// ?????? ??????
//        String line = null; // ????????? ??????
////        File saveFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/camdata"); // ?????? ??????
//        saveFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/camdata"); // ?????? ??????
//// ?????? ??????
//        if(!saveFile.exists()){ // ?????? ?????? ??????
//            saveFile.mkdir(); // ?????? ??????
//        }
//        try {
//            BufferedReader buf = new BufferedReader(new FileReader(saveFile+"/CarnumData.txt"));
//            while((line=buf.readLine())!=null){
////                tv.append(line);
////                tv.append("\n");
//                Log.d("re",line+"\n");
//            }
//            buf.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
////        ??????????????? ??????

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

//    static void saveText(){
//        textWrite();
//    }

    void textRead(){
        Log.d("contextPath:", getApplicationContext().toString());
        Log.d("Read test ...", "go");
        FileInputStream fis = null;
        try {
//                fis = openFileInput("test.txt");
            File f=new File("/data/data/"+getPackageName()+"/files/stock.txt");
            if(!f.exists()){
                Log.d("File","File not exist");
                @SuppressLint("WrongConstant") FileOutputStream fos =
                        openFileOutput("stock.txt", MODE_NO_LOCALIZED_COLLATORS);
                f.mkdir();
            }else Log.d("File","File exist");
            fis = openFileInput("stock.txt");
            byte[] file = new byte[fis.available()];
            fis.read(file);
            fis.close();
            str = new String(file,"utf-8");
            Log.d("Read Result ...", str);
            Log.d("Read test ...", "comp");
        } catch (Exception e) {
            Log.d("Read test ...", "fail");
            e.printStackTrace();
        }
    }

    @SuppressLint("WrongConstant")
    boolean textWrite() {
        Log.d("Write test ...", "go");
        FileOutputStream fos = null;
        try {
//            fos = openFileOutput("test.txt", MODE_NO_LOCALIZED_COLLATORS);
//            String text = "201732009";
            fos = openFileOutput("stock.txt", MODE_NO_LOCALIZED_COLLATORS);
            StringBuffer f=new StringBuffer();
            for(String s:ReVAdapter1.list){
                f.append(s+"\n");
            }
            Log.d("Write text --",f.toString());
            fos.write(f.toString().getBytes());
            fos.close();
            Log.d("Write test ...", "comp");
            return true;
        } catch (Exception e) {
            Log.d("Write test ...", "fail");
            e.printStackTrace();
            return false;
        }

    }

}