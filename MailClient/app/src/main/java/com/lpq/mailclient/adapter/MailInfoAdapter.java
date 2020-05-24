package com.lpq.mailclient.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.lpq.mailclient.R;
import com.lpq.mailclient.entity.MailInfo;

import java.util.List;

/**
 * @author Wei yuyaung
 * @date 2020.05.21 18:04
 */
public class MailInfoAdapter extends BaseAdapter {
    private List<MailInfo> mData;
    private Context mContext;
    /**
     * 有参构造
     *
     * @param context
     * @param data
     */
    public MailInfoAdapter(Context context, List<MailInfo> data) {
        this.mContext = context;
        this.mData = data;
    }

    /**
     * listView的item总数
     */
    @Override
    public int getCount() {
        return mData.size();
    }

    /**
     * 获取每一项数据
     *
     * @param position
     * @return
     */
    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    /**
     * 获取数据ID
     *
     * @param position
     * @return
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 项显示的view
     *
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        MailInfo mailInfo = mData.get(position);

        //convertView用于将加载好的布局进行缓存，先判断是否为空，可优化listView
        if (convertView == null) {
            viewHolder = new ViewHolder();

            //1、引用layout布局
            convertView = LayoutInflater.from(mContext).inflate(R.layout.mail_item, parent, false);
            //2、填充当前项的数据
            viewHolder.subjectView = convertView.findViewById(R.id.mail_detail_subject);
            viewHolder.fromView = convertView.findViewById(R.id.mail_detail_from);

            convertView.setTag(viewHolder); //3、在view上保存所需数据
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //设置数据
        viewHolder.subjectView.setText(mailInfo.getSubject());
        viewHolder.fromView.setText(mailInfo.getFrom());
        return convertView;
    }

    /**
     * ViewHolder通常出现在适配器里，为的是listview滚动的时候快速设置值，而不必每次都重新创建很多对象，从而提升性能
     */
    private static class ViewHolder {
        TextView subjectView;
        TextView fromView;
    }

}
