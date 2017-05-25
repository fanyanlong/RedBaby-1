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
import com.team3.baby.module.fragments_home.bean.HomeJsonBean;
import com.team3.baby.module.fragments_home.url.Url;

import java.util.List;

/**
 * 类用途: 这是适配器类
 * 作者:崔涵淞
 * 时间: 2017/5/21 20:26.
 */

public class MyRecyclerTitleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<HomeJsonBean.DataBean> list;
    private Context context;

    public MyRecyclerTitleAdapter(Context context, List<HomeJsonBean.DataBean> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        View view = null;
        switch (viewType) {
            case 0:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_one, parent, false);
                holder = new ViewHolder1(view);
                break;
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_three, parent, false);
                holder = new ViewHolder2(view);
                break;
            case 2:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_nine, parent, false);
                holder = new ViewHolder3(view);
                break;
            case 3:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_six, parent, false);
                holder = new ViewHolder4(view);
                break;
            case 4:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_seven, parent, false);
                holder = new ViewHolder5(view);
                break;
            case 5:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_seven, parent, false);
                holder = new ViewHolder6(view);
                break;
            case 6:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_seven, parent, false);
                holder = new ViewHolder7(view);
                break;
            case 7:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_seven, parent, false);
                holder = new ViewHolder7(view);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        switch (viewType) {
            case 0:
                ViewHolder1 holder1 = (ViewHolder1) holder;
                Glide.with(context).load(Url.IMAGE + list.get(0)
                        .get_$88001().getTag().get(0).getPicUrl())
                        .placeholder(R.mipmap.ic_launcher)
                        .into(holder1.item_home_one_image);
                break;

            case 1:
                ViewHolder2 holder2 = (ViewHolder2) holder;
                Glide.with(context).load(Url.IMAGE + list.get(1)
                        .get_$88003().getTag().get(0).getPicUrl())
                        .placeholder(R.mipmap.ic_launcher)
                        .into(holder2.image0);
                Glide.with(context).load(Url.IMAGE + list.get(1)
                        .get_$88003().getTag().get(1).getPicUrl())
                        .placeholder(R.mipmap.ic_launcher)
                        .into(holder2.image1);
                Glide.with(context).load(Url.IMAGE + list.get(1)
                        .get_$88003().getTag().get(2).getPicUrl()).
                        placeholder(R.mipmap.ic_launcher)
                        .into(holder2.image2);
                Glide.with(context).load(Url.IMAGE + list.get(1)
                        .get_$88003().getTag().get(3).getPicUrl())
                        .placeholder(R.mipmap.ic_launcher)
                        .into(holder2.image3);
                Glide.with(context).load(Url.IMAGE + list.get(1)
                        .get_$88003().getTag().get(4).getPicUrl())
                        .placeholder(R.mipmap.ic_launcher)
                        .into(holder2.image4);
                Glide.with(context).load(Url.IMAGE + list.get(1)
                        .get_$88003().getTag().get(5).getPicUrl())
                        .placeholder(R.mipmap.ic_launcher)
                        .into(holder2.image5);
                Glide.with(context).load(Url.IMAGE + list.get(1)
                        .get_$88003().getTag().get(6).getPicUrl()
                ).placeholder(R.mipmap.ic_launcher)
                        .into(holder2.image6);
                Glide.with(context).load(Url.IMAGE + list.get(1)
                        .get_$88003().getTag().get(7).getPicUrl())
                        .placeholder(R.mipmap.ic_launcher)
                        .into(holder2.image7);
                Glide.with(context).load(Url.IMAGE + list.get(1)
                        .get_$88003().getTag().get(8).getPicUrl())
                        .placeholder(R.mipmap.ic_launcher)
                        .into(holder2.image8);
                break;
            case 2:
                ViewHolder3 holder3 = (ViewHolder3) holder;
                Glide.with(context).load(Url.IMAGE + list.get(3).get_$88005().getTag()
                        .get(0).getPicUrl()).placeholder(R.mipmap.ic_launcher)
                        .into(holder3.item_home_nine_headline_image);
                Glide.with(context).load(Url.IMAGE + list.get(4).get_$88015().getTag()
                        .get(0).getPicUrl()).placeholder(R.mipmap.ic_launcher)
                        .into(holder3.item_home_nine_bigpicture_image);
                Glide.with(context).load(Url.IMAGE + list.get(6).get_$88015().getTag()
                        .get(0).getPicUrl()).placeholder(R.mipmap.ic_launcher)
                        .into(holder3.item_home_nine_bigpicture1_image);
                holder3.item_home_nine_name_text.setText(list.get(4).get_$88015().getTag().get(0).getElementName());
                holder3.item_home_nine_desc_text.setText(list.get(4).get_$88015().getTag().get(0).getElementDesc());
                holder3.item_home_nine_price_text.setText(list.get(4).get_$88015().getTag().get(0).getItemPrice());
                holder3.item_home_nine_name1_text.setText(list.get(6).get_$88015().getTag().get(0).getElementName());
                holder3.item_home_nine_desc1_text.setText(list.get(6).get_$88015().getTag().get(0).getElementDesc());
                holder3.item_home_nine_price1_text.setText(list.get(6).get_$88015().getTag().get(0).getItemPrice());
                break;
            case 3:
               ViewHolder4 holder4 = (ViewHolder4) holder;
                Glide.with(context).load(Url.IMAGE + list.get(9).get_$88005().getTag()
                        .get(0).getPicUrl()).placeholder(R.mipmap.commodity_hua_validate_lable_two)
                        .into(holder4.item_home_six_trademark_image);
                Glide.with(context).load(Url.IMAGE + list.get(10).get_$88010().getTag()
                        .get(0).getPicUrl()).placeholder(R.mipmap.commodity_hua_validate_lable_two)
                        .into(holder4.item_home_six_trademark_hui_image);
                Glide.with(context).load(Url.IMAGE + list.get(11).get_$88011().getTag()
                        .get(1).getPicUrl()).placeholder(R.mipmap.commodity_hua_validate_lable_two)
                        .into(holder4.item_home_six_image1);
                Glide.with(context).load(Url.IMAGE + list.get(11).get_$88011().getTag()
                        .get(2).getPicUrl()).placeholder(R.mipmap.commodity_hua_validate_lable_two)
                        .into(holder4.item_home_six_image2);
                Glide.with(context).load(Url.IMAGE + list.get(11).get_$88011().getTag()
                        .get(3).getPicUrl()).placeholder(R.mipmap.commodity_hua_validate_lable_two)
                        .into(holder4.item_home_six_image3);
                Glide.with(context).load(Url.IMAGE + list.get(11).get_$88011().getTag()
                        .get(4).getPicUrl()).placeholder(R.mipmap.commodity_hua_validate_lable_two)
                        .into(holder4.item_home_six_image4);
                Glide.with(context).load(Url.IMAGE + list.get(11).get_$88011().getTag()
                        .get(5).getPicUrl()).placeholder(R.mipmap.commodity_hua_validate_lable_two)
                        .into(holder4.item_home_six_image5);
                Glide.with(context).load(Url.IMAGE + list.get(11).get_$88011().getTag()
                        .get(6).getPicUrl()).placeholder(R.mipmap.commodity_hua_validate_lable_two)
                        .into(holder4.item_home_six_image6);
                Glide.with(context).load(Url.IMAGE + list.get(11).get_$88011().getTag()
                        .get(0).getPicUrl()).placeholder(R.mipmap.commodity_hua_validate_lable_two)
                        .into(holder4.item_home_six_image7);
                holder4.item_home_six_name1.setText(list.get(11).get_$88011().getTag().get(1).getElementName());
                holder4.item_home_six_name2.setText(list.get(11).get_$88011().getTag().get(2).getElementName());
                holder4.item_home_six_name3.setText(list.get(11).get_$88011().getTag().get(3).getElementName());
                holder4.item_home_six_name4.setText(list.get(11).get_$88011().getTag().get(4).getElementName());
                holder4.item_home_six_name5.setText(list.get(11).get_$88011().getTag().get(5).getElementName());
                holder4.item_home_six_name6.setText(list.get(11).get_$88011().getTag().get(6).getElementName());


                break;
            case 4:
                ViewHolder5 holder5 = (ViewHolder5) holder;
                Glide.with(context).load(Url.IMAGE + list.get(12).get_$88010().getTag()
                        .get(0).getPicUrl()).placeholder(R.mipmap.commodity_hua_validate_lable_two)
                        .into(holder5.item_home_seven_good_method_image);
                Glide.with(context).load(Url.IMAGE + list.get(13).get_$88011().getTag()
                        .get(1).getPicUrl()).placeholder(R.mipmap.commodity_hua_validate_lable_two)
                        .into(holder5.item_home_seven_image1);
                Glide.with(context).load(Url.IMAGE + list.get(13).get_$88011().getTag()
                        .get(2).getPicUrl()).placeholder(R.mipmap.commodity_hua_validate_lable_two)
                        .into(holder5.item_home_seven_image2);
                Glide.with(context).load(Url.IMAGE + list.get(13).get_$88011().getTag()
                        .get(3).getPicUrl()).placeholder(R.mipmap.commodity_hua_validate_lable_two)
                        .into(holder5.item_home_seven_image3);
                Glide.with(context).load(Url.IMAGE + list.get(13).get_$88011().getTag()
                        .get(4).getPicUrl()).placeholder(R.mipmap.commodity_hua_validate_lable_two)
                        .into(holder5.item_home_seven_image4);
                Glide.with(context).load(Url.IMAGE + list.get(13).get_$88011().getTag()
                        .get(5).getPicUrl()).placeholder(R.mipmap.commodity_hua_validate_lable_two)
                        .into(holder5.item_home_seven_image5);
                Glide.with(context).load(Url.IMAGE + list.get(13).get_$88011().getTag()
                        .get(6).getPicUrl()).placeholder(R.mipmap.commodity_hua_validate_lable_two)
                        .into(holder5.item_home_seven_image6);
                Glide.with(context).load(Url.IMAGE + list.get(13).get_$88011().getTag()
                        .get(0).getPicUrl()).placeholder(R.mipmap.commodity_hua_validate_lable_two)
                        .into(holder5.item_home_seven_image7);
                holder5.item_home_seven_name1.setText(list.get(13).get_$88011().getTag().get(1).getElementName());
                holder5.item_home_seven_name2.setText(list.get(13).get_$88011().getTag().get(2).getElementName());
                holder5.item_home_seven_name3.setText(list.get(13).get_$88011().getTag().get(3).getElementName());
                holder5.item_home_seven_name4.setText(list.get(13).get_$88011().getTag().get(4).getElementName());
                holder5.item_home_seven_name5.setText(list.get(13).get_$88011().getTag().get(5).getElementName());
                holder5.item_home_seven_name6.setText(list.get(13).get_$88011().getTag().get(6).getElementName());
                break;

            case 5:
                ViewHolder6 holder6 = (ViewHolder6) holder;
                Glide.with(context).load(Url.IMAGE + list.get(14).get_$88010().getTag()
                        .get(0).getPicUrl()).placeholder(R.mipmap.commodity_hua_validate_lable_two)
                        .into(holder6.item_home_seven_good_method_image);
                Glide.with(context).load(Url.IMAGE + list.get(15).get_$88011().getTag()
                        .get(1).getPicUrl()).placeholder(R.mipmap.commodity_hua_validate_lable_two)
                        .into(holder6.item_home_seven_image1);
                Glide.with(context).load(Url.IMAGE + list.get(15).get_$88011().getTag()
                        .get(2).getPicUrl()).placeholder(R.mipmap.commodity_hua_validate_lable_two)
                        .into(holder6.item_home_seven_image2);
                Glide.with(context).load(Url.IMAGE + list.get(15).get_$88011().getTag()
                        .get(3).getPicUrl()).placeholder(R.mipmap.commodity_hua_validate_lable_two)
                        .into(holder6.item_home_seven_image3);
                Glide.with(context).load(Url.IMAGE + list.get(15).get_$88011().getTag()
                        .get(4).getPicUrl()).placeholder(R.mipmap.commodity_hua_validate_lable_two)
                        .into(holder6.item_home_seven_image4);
                Glide.with(context).load(Url.IMAGE + list.get(15).get_$88011().getTag()
                        .get(5).getPicUrl()).placeholder(R.mipmap.commodity_hua_validate_lable_two)
                        .into(holder6.item_home_seven_image5);
                Glide.with(context).load(Url.IMAGE + list.get(15).get_$88011().getTag()
                        .get(6).getPicUrl()).placeholder(R.mipmap.commodity_hua_validate_lable_two)
                        .into(holder6.item_home_seven_image6);
                Glide.with(context).load(Url.IMAGE + list.get(15).get_$88011().getTag()
                        .get(0).getPicUrl()).placeholder(R.mipmap.commodity_hua_validate_lable_two)
                        .into(holder6.item_home_seven_image7);
                holder6.item_home_seven_name1.setText(list.get(15).get_$88011().getTag().get(1).getElementName());
                holder6.item_home_seven_name2.setText(list.get(15).get_$88011().getTag().get(2).getElementName());
                holder6.item_home_seven_name3.setText(list.get(15).get_$88011().getTag().get(3).getElementName());
                holder6.item_home_seven_name4.setText(list.get(15).get_$88011().getTag().get(4).getElementName());
                holder6.item_home_seven_name5.setText(list.get(15).get_$88011().getTag().get(5).getElementName());
                holder6.item_home_seven_name6.setText(list.get(15).get_$88011().getTag().get(6).getElementName());
                break;
            case 6:
                ViewHolder7 holder7 = (ViewHolder7) holder;
                Glide.with(context).load(Url.IMAGE + list.get(16).get_$88010().getTag()
                        .get(0).getPicUrl()).placeholder(R.mipmap.commodity_hua_validate_lable_two)
                        .into(holder7.item_home_seven_good_method_image);
                Glide.with(context).load(Url.IMAGE + list.get(17).get_$88011().getTag()
                        .get(1).getPicUrl()).placeholder(R.mipmap.commodity_hua_validate_lable_two)
                        .into(holder7.item_home_seven_image1);
                Glide.with(context).load(Url.IMAGE + list.get(17).get_$88011().getTag()
                        .get(2).getPicUrl()).placeholder(R.mipmap.commodity_hua_validate_lable_two)
                        .into(holder7.item_home_seven_image2);
                Glide.with(context).load(Url.IMAGE + list.get(17).get_$88011().getTag()
                        .get(3).getPicUrl()).placeholder(R.mipmap.commodity_hua_validate_lable_two)
                        .into(holder7.item_home_seven_image3);
                Glide.with(context).load(Url.IMAGE + list.get(17).get_$88011().getTag()
                        .get(4).getPicUrl()).placeholder(R.mipmap.commodity_hua_validate_lable_two)
                        .into(holder7.item_home_seven_image4);
                Glide.with(context).load(Url.IMAGE + list.get(17).get_$88011().getTag()
                        .get(5).getPicUrl()).placeholder(R.mipmap.commodity_hua_validate_lable_two)
                        .into(holder7.item_home_seven_image5);
                Glide.with(context).load(Url.IMAGE + list.get(17).get_$88011().getTag()
                        .get(6).getPicUrl()).placeholder(R.mipmap.commodity_hua_validate_lable_two)
                        .into(holder7.item_home_seven_image6);
                Glide.with(context).load(Url.IMAGE + list.get(17).get_$88011().getTag()
                        .get(0).getPicUrl()).placeholder(R.mipmap.commodity_hua_validate_lable_two)
                        .into(holder7.item_home_seven_image7);
                holder7.item_home_seven_name1.setText(list.get(17).get_$88011().getTag().get(1).getElementName());
                holder7.item_home_seven_name2.setText(list.get(17).get_$88011().getTag().get(2).getElementName());
                holder7.item_home_seven_name3.setText(list.get(17).get_$88011().getTag().get(3).getElementName());
                holder7.item_home_seven_name4.setText(list.get(17).get_$88011().getTag().get(4).getElementName());
                holder7.item_home_seven_name5.setText(list.get(17).get_$88011().getTag().get(5).getElementName());
                holder7.item_home_seven_name6.setText(list.get(17).get_$88011().getTag().get(6).getElementName());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 7;
    }

    @Override
    public int getItemViewType(int position) {
        int i = position % 7;
        switch (i) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;

        }
        return 0;

    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {
        ImageView item_home_one_image;

        public ViewHolder1(View itemView) {
            super(itemView);
            item_home_one_image = (ImageView) itemView.findViewById(R.id.item_home_one_image);
        }
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder {
        ImageView image0;
        ImageView image1;
        ImageView image2;
        ImageView image3;
        ImageView image4;
        ImageView image5;
        ImageView image6;
        ImageView image7;
        ImageView image8;

        public ViewHolder2(View itemView) {
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
        }
    }

    public class ViewHolder3 extends RecyclerView.ViewHolder {
        ImageView item_home_nine_headline_image;
        ImageView item_home_nine_bigpicture_image;
        TextView item_home_nine_name_text;
        TextView item_home_nine_desc_text;
        TextView item_home_nine_price_text;
        ImageView item_home_nine_bigpicture1_image;
        TextView item_home_nine_name1_text;
        TextView item_home_nine_desc1_text;
        TextView item_home_nine_price1_text;

        public ViewHolder3(View itemView) {
            super(itemView);
            item_home_nine_headline_image = (ImageView) itemView.findViewById(R.id.item_home_nine_headline_image);
            item_home_nine_bigpicture_image = (ImageView) itemView.findViewById(R.id.item_home_nine_bigpicture_image);
            item_home_nine_bigpicture1_image = (ImageView) itemView.findViewById(R.id.item_home_nine_bigpicture1_image);
            item_home_nine_name_text = (TextView) itemView.findViewById(R.id.item_home_nine_name_text);
            item_home_nine_desc_text = (TextView) itemView.findViewById(R.id.item_home_nine_desc_text);
            item_home_nine_price_text = (TextView) itemView.findViewById(R.id.item_home_nine_price_text);
            item_home_nine_name1_text = (TextView) itemView.findViewById(R.id.item_home_nine_name1_text);
            item_home_nine_desc1_text = (TextView) itemView.findViewById(R.id.item_home_nine_desc1_text);
            item_home_nine_price1_text = (TextView) itemView.findViewById(R.id.item_home_nine_price1_text);


        }
    }

    public class ViewHolder4 extends RecyclerView.ViewHolder {
        ImageView item_home_six_trademark_image;
        ImageView item_home_six_trademark_hui_image;
        ImageView item_home_six_image1;
        ImageView item_home_six_image2;
        ImageView item_home_six_image3;
        ImageView item_home_six_image4;
        ImageView item_home_six_image5;
        ImageView item_home_six_image6;
        ImageView item_home_six_image7;
        TextView item_home_six_name1;
        TextView item_home_six_name2;
        TextView item_home_six_name3;
        TextView item_home_six_name4;
        TextView item_home_six_name5;
        TextView item_home_six_name6;


        public ViewHolder4(View itemView) {
            super(itemView);
            item_home_six_trademark_image = (ImageView) itemView.findViewById(R.id.item_home_six_trademark_image);
            item_home_six_trademark_hui_image = (ImageView) itemView.findViewById(R.id.item_home_six_trademark_hui_image);
            item_home_six_image1 = (ImageView) itemView.findViewById(R.id.item_home_six_image1);
            item_home_six_image2 = (ImageView) itemView.findViewById(R.id.item_home_six_image2);
            item_home_six_image3 = (ImageView) itemView.findViewById(R.id.item_home_six_image3);
            item_home_six_image4 = (ImageView) itemView.findViewById(R.id.item_home_six_image4);
            item_home_six_image5 = (ImageView) itemView.findViewById(R.id.item_home_six_image5);
            item_home_six_image6 = (ImageView) itemView.findViewById(R.id.item_home_six_image6);
            item_home_six_image7 = (ImageView) itemView.findViewById(R.id.item_home_six_image7);
            item_home_six_name1 = (TextView) itemView.findViewById(R.id.item_home_six_name1);
            item_home_six_name2 = (TextView) itemView.findViewById(R.id.item_home_six_name2);
            item_home_six_name3 = (TextView) itemView.findViewById(R.id.item_home_six_name3);
            item_home_six_name4 = (TextView) itemView.findViewById(R.id.item_home_six_name4);
            item_home_six_name5 = (TextView) itemView.findViewById(R.id.item_home_six_name5);
            item_home_six_name6 = (TextView) itemView.findViewById(R.id.item_home_six_name6);

        }
    }

    public class ViewHolder5 extends RecyclerView.ViewHolder {
        ImageView item_home_seven_good_method_image;
        ImageView item_home_seven_image1;
        ImageView item_home_seven_image2;
        ImageView item_home_seven_image3;
        ImageView item_home_seven_image4;
        ImageView item_home_seven_image5;
        ImageView item_home_seven_image6;
        ImageView item_home_seven_image7;
        TextView item_home_seven_name1;
        TextView item_home_seven_name2;
        TextView item_home_seven_name3;
        TextView item_home_seven_name4;
        TextView item_home_seven_name5;
        TextView item_home_seven_name6;


        public ViewHolder5(View itemView) {
            super(itemView);
            item_home_seven_good_method_image = (ImageView) itemView.findViewById(R.id.item_home_seven_good_method_image);
            item_home_seven_image1 = (ImageView) itemView.findViewById(R.id.item_home_seven_image1);
            item_home_seven_image2 = (ImageView) itemView.findViewById(R.id.item_home_seven_image2);
            item_home_seven_image3 = (ImageView) itemView.findViewById(R.id.item_home_seven_image3);
            item_home_seven_image4 = (ImageView) itemView.findViewById(R.id.item_home_seven_image4);
            item_home_seven_image5 = (ImageView) itemView.findViewById(R.id.item_home_seven_image5);
            item_home_seven_image6 = (ImageView) itemView.findViewById(R.id.item_home_seven_image6);
            item_home_seven_image7 = (ImageView) itemView.findViewById(R.id.item_home_seven_image7);
            item_home_seven_name1 = (TextView) itemView.findViewById(R.id.item_home_seven_name1);
            item_home_seven_name2 = (TextView) itemView.findViewById(R.id.item_home_seven_name2);
            item_home_seven_name3 = (TextView) itemView.findViewById(R.id.item_home_seven_name3);
            item_home_seven_name4 = (TextView) itemView.findViewById(R.id.item_home_seven_name4);
            item_home_seven_name5 = (TextView) itemView.findViewById(R.id.item_home_seven_name5);
            item_home_seven_name6 = (TextView) itemView.findViewById(R.id.item_home_seven_name6);

        }
    }

    public class ViewHolder6 extends RecyclerView.ViewHolder {
        ImageView item_home_seven_good_method_image;
        ImageView item_home_seven_image1;
        ImageView item_home_seven_image2;
        ImageView item_home_seven_image3;
        ImageView item_home_seven_image4;
        ImageView item_home_seven_image5;
        ImageView item_home_seven_image6;
        ImageView item_home_seven_image7;
        TextView item_home_seven_name1;
        TextView item_home_seven_name2;
        TextView item_home_seven_name3;
        TextView item_home_seven_name4;
        TextView item_home_seven_name5;
        TextView item_home_seven_name6;

        public ViewHolder6(View itemView) {
            super(itemView);
            item_home_seven_good_method_image = (ImageView) itemView.findViewById(R.id.item_home_seven_good_method_image);
            item_home_seven_image1 = (ImageView) itemView.findViewById(R.id.item_home_seven_image1);
            item_home_seven_image2 = (ImageView) itemView.findViewById(R.id.item_home_seven_image2);
            item_home_seven_image3 = (ImageView) itemView.findViewById(R.id.item_home_seven_image3);
            item_home_seven_image4 = (ImageView) itemView.findViewById(R.id.item_home_seven_image4);
            item_home_seven_image5 = (ImageView) itemView.findViewById(R.id.item_home_seven_image5);
            item_home_seven_image6 = (ImageView) itemView.findViewById(R.id.item_home_seven_image6);
            item_home_seven_image7 = (ImageView) itemView.findViewById(R.id.item_home_seven_image7);
            item_home_seven_name1 = (TextView) itemView.findViewById(R.id.item_home_seven_name1);
            item_home_seven_name2 = (TextView) itemView.findViewById(R.id.item_home_seven_name2);
            item_home_seven_name3 = (TextView) itemView.findViewById(R.id.item_home_seven_name3);
            item_home_seven_name4 = (TextView) itemView.findViewById(R.id.item_home_seven_name4);
            item_home_seven_name5 = (TextView) itemView.findViewById(R.id.item_home_seven_name5);
            item_home_seven_name6 = (TextView) itemView.findViewById(R.id.item_home_seven_name6);

        }
    }

    public class ViewHolder7 extends RecyclerView.ViewHolder {
        ImageView item_home_seven_good_method_image;
        ImageView item_home_seven_image1;
        ImageView item_home_seven_image2;
        ImageView item_home_seven_image3;
        ImageView item_home_seven_image4;
        ImageView item_home_seven_image5;
        ImageView item_home_seven_image6;
        ImageView item_home_seven_image7;
        TextView item_home_seven_name1;
        TextView item_home_seven_name2;
        TextView item_home_seven_name3;
        TextView item_home_seven_name4;
        TextView item_home_seven_name5;
        TextView item_home_seven_name6;

        public ViewHolder7(View itemView) {
            super(itemView);
            item_home_seven_good_method_image = (ImageView) itemView.findViewById(R.id.item_home_seven_good_method_image);
            item_home_seven_image1 = (ImageView) itemView.findViewById(R.id.item_home_seven_image1);
            item_home_seven_image2 = (ImageView) itemView.findViewById(R.id.item_home_seven_image2);
            item_home_seven_image3 = (ImageView) itemView.findViewById(R.id.item_home_seven_image3);
            item_home_seven_image4 = (ImageView) itemView.findViewById(R.id.item_home_seven_image4);
            item_home_seven_image5 = (ImageView) itemView.findViewById(R.id.item_home_seven_image5);
            item_home_seven_image6 = (ImageView) itemView.findViewById(R.id.item_home_seven_image6);
            item_home_seven_image7 = (ImageView) itemView.findViewById(R.id.item_home_seven_image7);
            item_home_seven_name1 = (TextView) itemView.findViewById(R.id.item_home_seven_name1);
            item_home_seven_name2 = (TextView) itemView.findViewById(R.id.item_home_seven_name2);
            item_home_seven_name3 = (TextView) itemView.findViewById(R.id.item_home_seven_name3);
            item_home_seven_name4 = (TextView) itemView.findViewById(R.id.item_home_seven_name4);
            item_home_seven_name5 = (TextView) itemView.findViewById(R.id.item_home_seven_name5);
            item_home_seven_name6 = (TextView) itemView.findViewById(R.id.item_home_seven_name6);

        }
    }
}
