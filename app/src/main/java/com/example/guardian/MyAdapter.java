package com.example.guardian;


import androidx.annotation.NonNull;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private List<List_Data> newss;

    public MyAdapter(Context ctx, List<List_Data> news){
        this.inflater = LayoutInflater.from(ctx);
        this.newss = news;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.data_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.newsHead.setText(newss.get(position).getHeadline());
        holder.newsLink.setText(newss.get(position).getLink());

    }

    @Override
    public int getItemCount() {

        return newss.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView newsHead, newsLink;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            newsHead = itemView.findViewById(R.id.text_head);
            newsLink = itemView.findViewById(R.id.text_link);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String url = newsLink.toString();
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    Toast.makeText(v.getContext(), "Opening", Toast.LENGTH_SHORT).show();
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
