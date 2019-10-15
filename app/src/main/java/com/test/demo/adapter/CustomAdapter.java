package com.test.demo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.demo.R;
import com.test.demo.model.CustomModel;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewLoader> {

    private ArrayList<CustomModel> arrayList;
    private Context context;

    public CustomAdapter(ArrayList<CustomModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewLoader onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.row_getlist,parent,false);
        return new CustomViewLoader(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewLoader holder, int position) {
        holder.text_name.setText(arrayList.get(position).getmName());
        holder.text_email.setText(arrayList.get(position).getmEmail());
        holder.text_phone.setText(arrayList.get(position).getmPhone());
        holder.text_dateofjoin.setText(arrayList.get(position).getmDateOfJoin());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class CustomViewLoader extends RecyclerView.ViewHolder{
        TextView text_name,text_email,text_phone,text_dateofjoin;
        public CustomViewLoader(View itemView) {
            super(itemView);
            text_name=itemView.findViewById(R.id.text_name);
            text_email=itemView.findViewById(R.id.text_email);
            text_phone=itemView.findViewById(R.id.text_phone);
            text_dateofjoin=itemView.findViewById(R.id.text_dateofjoin);
        }
    }
}
