package com.example.zhpt.mideoandvideo.view.adapter;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.zhpt.mideoandvideo.R;
import com.example.zhpt.mideoandvideo.bean.Audio;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Administrator on 2017/6/16 0016.
 */

public class ListAdapter extends BaseAdapter {
    private Context context;
    private List<Audio> audios;

    public ListAdapter(Context context, List<Audio> audios) {
        this.context = context;
        this.audios = audios;
    }

    @Override
    public int getCount() {
        if (audios != null){
            return audios.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if(audios != null){
            return audios.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHandler viewHandler;
        if (convertView == null){
            viewHandler = new ViewHandler();
            convertView = LayoutInflater.from(context).inflate(R.layout.main_item,null);
            viewHandler.textViewName = (TextView)convertView.findViewById(R.id.textView_name);
            viewHandler.textViewPath = (TextView)convertView.findViewById(R.id.textView_path);
            convertView.setTag(viewHandler);
        }else {
            viewHandler = (ViewHandler)convertView.getTag();
        }
        viewHandler.textViewName.setText(audios.get(position).fileName);
        viewHandler.textViewPath.setText(audios.get(position).fileName);
        return convertView;
    }

    public class ViewHandler{
        TextView textViewName,textViewPath;
    }
}
