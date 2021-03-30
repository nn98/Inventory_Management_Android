package com.example.inventory_management;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ReVAdapter1 extends RecyclerView.Adapter<ReVAdapter1.ViewHolder> {
    static class ViewHolder extends RecyclerView.ViewHolder{
        EditText name,count;
        Button plus,minus,confirm;
        public ViewHolder(View view){
            super(view);
            name=view.findViewById(R.id.name);
            count=view.findViewById(R.id.count);
            plus=view.findViewById(R.id.plus);
            minus=view.findViewById(R.id.minus);
            confirm=view.findViewById(R.id.confirm);
        }
    }

    LayoutInflater lI;
    ArrayList<String> list;

    public ReVAdapter1(Context con, ArrayList<String>list){
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
        Log.d("text",list.get(index));
        String[]ingres=list.get(index).split("\\$");
        int i=0;
        vH.name.setText(ingres[i++]);
        vH.count.setText(ingres[i++]);
    }
}
