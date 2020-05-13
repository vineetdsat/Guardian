package com.example.guardian;


import androidx.annotation.NonNull;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<List_Data>list_data;

    MyAdapter(List<List_Data> list_data) {
        this.list_data = list_data;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.data_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        List_Data listData=list_data.get(position);


        holder.img.setText(listData.getImage_url());

        holder.txtname.setText(listData.getName());

    }

    @Override
    public int getItemCount() {
        return list_data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView img;
        private TextView txtname;
        ViewHolder(View itemView) {
            super(itemView);
            img= itemView.findViewById(R.id.image_view);
            txtname= itemView.findViewById(R.id.text_name);
        }
    }
}
