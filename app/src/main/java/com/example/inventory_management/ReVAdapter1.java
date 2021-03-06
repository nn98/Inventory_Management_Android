package com.example.inventory_management;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ReVAdapter1 extends RecyclerView.Adapter<ReVAdapter1.ViewHolder> {
    static class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
        EditText name,count;
        Button plus,minus,confirm;
        CheckBox check;
        public ViewHolder(View view){
            super(view);
            name=view.findViewById(R.id.name);
            name.setHint("재료명");
            name.setHintTextColor(Color.parseColor("#888888"));
            name.setGravity(Gravity.CENTER);
            count=view.findViewById(R.id.count);
            count.setHint("개수");
            count.setHintTextColor(Color.parseColor("#888888"));
            count.setGravity(Gravity.CENTER);
            plus=view.findViewById(R.id.plus);
            minus=view.findViewById(R.id.minus);
            confirm=view.findViewById(R.id.confirm);
            check=view.findViewById(R.id.check);
        }

        @Override
        public void onClick(View v){

        }

        @Override
        public void onCheckedChanged(CompoundButton bv,boolean isC){
            list.get(super.getAdapterPosition()).setChecked(isC);
        }
    }

    LayoutInflater lI;
//    static ArrayList<String> list;
    static List<Ingredient> list;
    static String result;

    public ReVAdapter1(Context con, ArrayList<Ingredient>list){
        this.lI=LayoutInflater.from(con);
        this.list=list;
    }

    @Override
    public int getItemCount(){
        return list.size();
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup,int viewType){
        View v=lI.inflate(R.layout.ingre1,viewGroup,false);
        return new ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(final ViewHolder vH,final int index){
//        Log.d("text",list.get(index));
//        String[]ingres=list.get(index).split("\\$");
//        int i=0;
//        if(ingres.length>1) {
//            vH.name.setText(ingres[i++]);
//            vH.count.setText(ingres[i++]);
//        }
        vH.name.setText(list.get(index).getName());
        vH.count.setText(list.get(index).getCount());
        vH.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                int c=vH.count.getText().toString().equals("")?0:Integer.parseInt(vH.count.getText().toString())+1;
//                vH.count.setText(""+c);
//                vH.confirm.performClick();
                list.get(index).setCount(list.get(index).getCount()+1);
            }
        });
        vH.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                int c=vH.count.getText().toString().equals("")?0:Integer.parseInt(vH.count.getText().toString())-1;
//                vH.count.setText(""+c);
//                vH.confirm.performClick();
                list.get(index).setCount(list.get(index).getCount()-1);
            }
        });
        vH.confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.d("List_",list.toString());
//                StringBuffer f=new StringBuffer();
//                String name=vH.name.getText().toString().trim(),
//                        count=vH.count.getText().toString().trim();
//                f.append(name+"$");
//                vH.name.setText(name);
//                f.append(count);
//                vH.count.setText(count);
//                list.set(vH.getAdapterPosition(),f.toString());
//                Log.d("List_",list.toString());
                list.get(index).setName(vH.name.getText().toString());
                list.get(index).setCount(Integer.parseInt(vH.count.getText().toString()));
                MainActivity.close.performClick();
            }
        });
//        vH.check.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Log.d("delete","checked");
////                vH.check.setChecked(false);
////                Log.d("list before",list.toString());
////                list.remove(index);
////                Log.d("list after",list.toString());
////                notifyDataSetChanged();
//                list.get(index).setChecked(true);
//            }
//        });
    }
}
