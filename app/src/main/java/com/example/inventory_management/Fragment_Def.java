package com.example.inventory_management;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_Def#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Def extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment_Def() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_Def.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_Def newInstance(String param1, String param2) {
        Fragment_Def fragment = new Fragment_Def();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

//    TextView tv0_0;
//    EditText eT0;
//    Button btn0_0,btn0_1,btn0_2;
//    int n0=0,n1=0,n2=0,n3=0;

    static ReVAdapter1 rVA1;
    static ArrayList<String>list;
    static RecyclerView rV;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

//        View v=inflater.inflate(R.layout.fragment__def, container, false);
        ViewGroup v=(ViewGroup)inflater.inflate(R.layout.fragment__def,container,false);
        List<String> l=Arrays.asList(MainActivity.str.split("\n"));
        list=new ArrayList<String>();
        list.addAll(l);
//        list.add("면$29");
//        list.add("면추$5");

        rVA1=new ReVAdapter1(getActivity(),list);
        rV=v.findViewById(R.id.list);
        rV.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        rV.setLayoutManager(new LinearLayoutManager(getActivity()));
        rV.setItemAnimator(new DefaultItemAnimator());
        rV.setAdapter(rVA1);

//        tv0_0=v.findViewById(R.id.noodleC);
//        eT0=v.findViewById(R.id.noodleN);
//        btn0_0=v.findViewById(R.id.noodleP);
//        btn0_0.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String x=eT0.getText().toString();
//                if(!x.equals(""))
//                    n1=Integer.parseInt(x);
//                else
//                    n1=0;
//                n1++;
//                eT0.setText(""+n1);
//                tv0_0.setText(""+n1);
//            }
//        });
//        btn0_1=v.findViewById(R.id.noodleM);
//        btn0_1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String x=eT0.getText().toString();
//                if(!x.equals(""))
//                    n1=Integer.parseInt(x);
//                else
//                    n1=0;
//                n1--;
//                eT0.setText(""+n1);
//                tv0_0.setText(""+n1);
//            }
//        });
//        btn0_2=v.findViewById(R.id.noodleCon);
//        btn0_2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String x=eT0.getText().toString();
//                if(!x.equals(""))
//                    n1=Integer.parseInt(x);
//                else
//                    n1=0;
//                eT0.setText(""+n1);
//                tv0_0.setText(""+n1);
////                AlertDialog.Builder b=new AlertDialog.Builder(getActivity());
////                b.setTitle("변경");
////                b.show();
//                Toast.makeText(getActivity(),"변경 완료",Toast.LENGTH_SHORT).show();
//            }
//        });
        return v;
    }

    protected static void addItem(){
        list.add("$");
        Log.d("AddItem",list.toString());
        rVA1.notifyDataSetChanged();
        rV.setAdapter(rVA1);
    }
}
