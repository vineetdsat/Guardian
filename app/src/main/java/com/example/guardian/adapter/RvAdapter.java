package com.example.guardian.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.guardian.R;
import com.example.guardian.model.Updates;

import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder> {
    private Context mContext;
    private List<Updates> mData;


    public RvAdapter(Context mContext, List<Updates> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.data_list, parent, false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_headline.setText(mData.get(position).getHeadline());
        holder.tv_link.setText(mData.get(position).getLink());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public  static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_headline;
        TextView tv_link;

        public MyViewHolder(View itemView){
            super(itemView);
            tv_headline = itemView.findViewById(R.id.text_head);
            tv_link = itemView.findViewById(R.id.text_link);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String url = tv_link.getText().toString();
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    Toast.makeText(v.getContext(),"Opening", Toast.LENGTH_SHORT).show();
                    v.getContext().startActivity(intent);

                }
            });




        }

    }


}
