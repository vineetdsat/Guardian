package com.example.guardian;

import android.app.ProgressDialog;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.TextView;
import java.util.List;


public class MyAdapter extends ArrayAdapter<Tutorial> {

    private List<Tutorial> tutorialList;

    private Context mCtx;
    public MyAdapter(List<Tutorial> tutorialList, Context mCtx) {
        super(mCtx, R.layout.list_item, tutorialList);
        this.tutorialList = tutorialList;
        this.mCtx = mCtx;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        convertView = inflater.inflate(R.layout.list_item, null, true);
        holder = new ViewHolder();

        holder.textViewName = convertView.findViewById(R.id.tv_headline);
        holder.textDescription = convertView.findViewById(R.id.tv_link);


        convertView.setTag(holder);

        Tutorial tutorial = tutorialList.get(position);
        String link = tutorial.getLinks();
        String tutorialTitle = tutorial.getHeadlines();

        holder.textViewName.setText(tutorialTitle);
        holder.textDescription.setText(link);

        return convertView;


    }
    static class ViewHolder {
        TextView textViewName;
        TextView textDescription;

    }
}