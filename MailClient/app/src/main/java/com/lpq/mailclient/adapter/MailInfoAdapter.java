package com.lpq.mailclient.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.lpq.mailclient.R;
import com.lpq.mailclient.entity.MailInfo;

import java.util.List;

/**
 * @author Wei yuyaung
 * @date 2020.05.21 18:04
 */
public class MailInfoAdapter extends ArrayAdapter {
    private final int resourceId;


    public MailInfoAdapter(Context context, int textViewResourceId, List<MailInfo> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MailInfo info = (MailInfo) getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);//实例化一个对象
        //ImageView fruitImage = (ImageView) view.findViewById(R.id.fruit_image);//获取该布局内的图片视图
        TextView subjectView = view.findViewById(R.id.mail_detail_subject);
        TextView contentView = view.findViewById(R.id.mail_detail_content);
        //TextView fruitName = (TextView) view.findViewById(R.id.fruit_name);//获取该布局内的文本视图
        //fruitImage.setImageResource(fruit.getImageId());//为图片视图设置图片资源
        //fruitName.setText(fruit.getName());//为文本视图设置文本内容
        subjectView.setText(info.getSubject());
        contentView.setText(info.getFrom());
        return view;
    }
}
