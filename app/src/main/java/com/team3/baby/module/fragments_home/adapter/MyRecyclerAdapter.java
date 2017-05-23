package com.team3.baby.module.fragments_home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.team3.baby.R;
import com.team3.baby.module.fragments_home.bean.TitleBean;
import com.team3.baby.module.fragments_home.url.Url;

import java.util.List;

/**
 * 类用途:
 * 作者:崔涵淞
 * 时间: 2017/5/21 20:26.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<TitleBean.DataBean> list;
    private Context context;

    public MyRecyclerAdapter(Context context, List<TitleBean.DataBean> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        View view = null;
        switch (viewType) {
            case 0:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_one, parent,false);
                holder = new ViewHolder_One(view);
                break;
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_two, parent,false);
                holder = new ViewHolder_Two(view);
                break;
            case 2:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_three, parent,false);
                holder = new ViewHolder_Three(view);
                break;
        }
        return holder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);

        switch (viewType) {
            case 0:
                ViewHolder_One holder_one = (ViewHolder_One)holder;
                Glide.with(context).load(Url.IMAGE+list.get(1).getTag().get(0).getPicUrl()).placeholder(R.mipmap.ic_launcher).into(holder_one.item_home_one_image);
                break;
            case 1:
                ViewHolder_Two holder_two = (ViewHolder_Two) holder;
                holder_two.lotto_text.setText(list.get(2).getTag().get(0).getElementName());
                holder_two.centre_text.setText(list.get(2).getTag().get(1).getElementName());
                holder_two.import_text.setText(list.get(2).getTag().get(2).getElementName());
                holder_two.probation_text.setText(list.get(2).getTag().get(3).getElementName());
                holder_two.pregnant_text.setText(list.get(2).getTag().get(4).getElementName());
                Glide.with(context).load(Url.IMAGE+list.get(2).getTag()
                        .get(0).getPicUrl()).placeholder(R.mipmap.ic_launcher)
                        .into(holder_two.lotto_image);
                Glide.with(context).load(Url.IMAGE+list.get(2).getTag()
                        .get(1).getPicUrl()).placeholder(R.mipmap.ic_launcher)
                        .into(holder_two.centre_image);
                Glide.with(context).load(Url.IMAGE+list.get(2).getTag()
                        .get(2).getPicUrl()).placeholder(R.mipmap.ic_launcher)
                        .into(holder_two.import_image);
                Glide.with(context).load(Url.IMAGE+list.get(2).getTag()
                        .get(3).getPicUrl()).placeholder(R.mipmap.ic_launcher)
                        .into(holder_two.probation_image);
                Glide.with(context).load(Url.IMAGE+list.get(2).getTag()
                        .get(4).getPicUrl()).placeholder(R.mipmap.ic_launcher)
                        .into(holder_two.pregnant_image);

                break;
            case 2:
                ViewHolder_Three holder_three = (ViewHolder_Three) holder;
                Glide.with(context).load(Url.IMAGE+list.get(3).getTag()
                        .get(0).getPicUrl()).placeholder(R.mipmap.ic_launcher)
                        .into(holder_three.image0);
                Glide.with(context).load(Url.IMAGE+list.get(3).getTag()
                        .get(1).getPicUrl()).placeholder(R.mipmap.ic_launcher)
                        .into(holder_three.image1);
                Glide.with(context).load(Url.IMAGE+list.get(3).getTag()
                        .get(2).getPicUrl()).placeholder(R.mipmap.ic_launcher)
                        .into(holder_three.image2);
                Glide.with(context).load(Url.IMAGE+list.get(3).getTag()
                        .get(3).getPicUrl()).placeholder(R.mipmap.ic_launcher)
                        .into(holder_three.image3);
                Glide.with(context).load(Url.IMAGE+list.get(3).getTag()
                        .get(4).getPicUrl()).placeholder(R.mipmap.ic_launcher)
                        .into(holder_three.image4);
                Glide.with(context).load(Url.IMAGE+list.get(3).getTag()
                        .get(5).getPicUrl()).placeholder(R.mipmap.ic_launcher)
                        .into(holder_three.image5);
                Glide.with(context).load(Url.IMAGE+list.get(3).getTag()
                        .get(6).getPicUrl()).placeholder(R.mipmap.ic_launcher)
                        .into(holder_three.image6);
                Glide.with(context).load(Url.IMAGE+list.get(3).getTag()
                        .get(7).getPicUrl()).placeholder(R.mipmap.ic_launcher)
                        .into(holder_three.image7);
                Glide.with(context).load(Url.IMAGE+list.get(3).getTag()
                        .get(8).getPicUrl()).placeholder(R.mipmap.ic_launcher)
                        .into(holder_three.image8);
               /* Glide.with(context).load(Url.IMAGE+list.get(3).getTag()
                        .get(9).getPicUrl()).placeholder(R.mipmap.ic_launcher)
                        .into(holder_three.image1);*/


                break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        int i = position%3;
        switch (i){
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
        }
        return 0;

    }

    public class ViewHolder_One extends RecyclerView.ViewHolder {
        ImageView item_home_one_image;

        public ViewHolder_One(View itemView) {
            super(itemView);
            item_home_one_image = (ImageView) itemView.findViewById(R.id.item_home_one_image);
        }
    }

    public class ViewHolder_Two extends RecyclerView.ViewHolder {
        TextView lotto_text;
        TextView centre_text;
        TextView import_text;
        TextView probation_text;
        TextView pregnant_text;
        ImageView lotto_image;
        ImageView centre_image;
        ImageView import_image;
        ImageView probation_image;
        ImageView pregnant_image;


        public ViewHolder_Two(View itemView) {
            super(itemView);
            lotto_text = (TextView) itemView.findViewById(R.id.item_home_two_lotto_text);
            centre_text = (TextView) itemView.findViewById(R.id.item_home_two_centre_text);
            import_text = (TextView) itemView.findViewById(R.id.item_home_two_import_text);
            probation_text = (TextView) itemView.findViewById(R.id.item_home_two_probation_text);
            pregnant_text = (TextView) itemView.findViewById(R.id.item_home_two_pregnant_text);
            lotto_image = (ImageView) itemView.findViewById(R.id.item_home_two_lotto_image);
            centre_image = (ImageView) itemView.findViewById(R.id.item_home_two_centre_image);
            import_image = (ImageView) itemView.findViewById(R.id.item_home_two_import_image);
            probation_image = (ImageView) itemView.findViewById(R.id.item_home_two_probation_image);
            pregnant_image = (ImageView) itemView.findViewById(R.id.item_home_two_pregnant_image);
        }
    }

    public class ViewHolder_Three extends RecyclerView.ViewHolder {
        ImageView image0;
        ImageView image1;
        ImageView image2;
        ImageView image3;
        ImageView image4;
        ImageView image5;
        ImageView image6;
        ImageView image7;
        ImageView image8;

        public ViewHolder_Three(View itemView) {
            super(itemView);
            image0 = (ImageView) itemView.findViewById(R.id.item_home_three_headline_image);
            image1 = (ImageView) itemView.findViewById(R.id.item_home_three_image1);
            image2 = (ImageView) itemView.findViewById(R.id.item_home_three_image2);
            image3 = (ImageView) itemView.findViewById(R.id.item_home_three_image3);
            image4 = (ImageView) itemView.findViewById(R.id.item_home_three_image4);
            image5 = (ImageView) itemView.findViewById(R.id.item_home_three_image5);
            image6 = (ImageView) itemView.findViewById(R.id.item_home_three_image6);
            image7 = (ImageView) itemView.findViewById(R.id.item_home_three_image7);
            image8 = (ImageView) itemView.findViewById(R.id.item_home_three_image8);

            ;
        }
    }

}
