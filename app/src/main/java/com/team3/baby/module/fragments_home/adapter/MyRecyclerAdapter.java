package com.team3.baby.module.fragments_home.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.team3.baby.R;
import com.team3.baby.module.fragments_groupBuy.utils.WebViewUtils;
import com.team3.baby.module.fragments_home.activity.WebViewShow;
import com.team3.baby.module.fragments_home.bean.TitleBean;
import com.team3.baby.module.fragments_home.inter_face.MyOnItemClickListener;
import com.team3.baby.module.fragments_home.inter_face.MyOnItemLongClickListener;
import com.team3.baby.module.fragments_home.url.Url;
import com.team3.baby.module.fragments_shopping.ShoppingCarActivity;

import java.util.List;

/**
 * 类用途:
 * 作者:崔涵淞
 * 时间: 2017/5/21 20:26.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<TitleBean.DataBean> list;
    private Context context;
    private MyOnItemClickListener itemClickListener;
    private MyOnItemLongClickListener itemLongClickListener;


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
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_one, parent, false);
                holder = new ViewHolder_One(view);
                break;
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_two, parent, false);
                holder = new ViewHolder_Two(view);
                break;
            case 2:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_three, parent, false);
                holder = new ViewHolder_Three(view);
                break;
            case 3:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_four, parent, false);
                holder = new ViewHolder_Four(view);
                break;
            case 4:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_five, parent, false);
                holder = new ViewHolder_Five(view);
                break;
            case 5:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_six, parent, false);
                holder = new ViewHolder_Six(view);
                break;
            case 6:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_seven, parent, false);
                holder = new ViewHolder_Seven(view);
                break;
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);

        switch (viewType) {
            case 0:
                ViewHolder_One holder_one = (ViewHolder_One) holder;
                Glide.with(context).load(Url.IMAGE + list.get(1).getTag().get(0).getPicUrl()).placeholder(R.mipmap.commodity_hua_validate_lable_two).into(holder_one.item_home_one_image);
                setClickListener(holder_one);
                break;
            case 1:
                ViewHolder_Two holder_two = (ViewHolder_Two) holder;
                holder_two.lotto_text.setText(list.get(2).getTag().get(0).getElementName());
                holder_two.centre_text.setText(list.get(2).getTag().get(1).getElementName());
                holder_two.import_text.setText(list.get(2).getTag().get(2).getElementName());
                holder_two.probation_text.setText(list.get(2).getTag().get(3).getElementName());
                holder_two.pregnant_text.setText(list.get(2).getTag().get(4).getElementName());
                Glide.with(context).load(Url.IMAGE + list.get(2).getTag()
                        .get(0).getPicUrl()).placeholder(R.mipmap.ahahah)
                        .into(holder_two.lotto_image);
                Glide.with(context).load(Url.IMAGE + list.get(2).getTag()
                        .get(1).getPicUrl()).placeholder(R.mipmap.ahahah)
                        .into(holder_two.centre_image);
                Glide.with(context).load(Url.IMAGE + list.get(2).getTag()
                        .get(2).getPicUrl()).placeholder(R.mipmap.ahahah)
                        .into(holder_two.import_image);
                Glide.with(context).load(Url.IMAGE + list.get(2).getTag()
                        .get(3).getPicUrl()).placeholder(R.mipmap.ahahah)
                        .into(holder_two.probation_image);
                Glide.with(context).load(Url.IMAGE + list.get(2).getTag()
                        .get(4).getPicUrl()).placeholder(R.mipmap.ahahah)
                        .into(holder_two.pregnant_image);
                setClickListener(holder_two);
                break;
            case 2:
                ViewHolder_Three holder_three = (ViewHolder_Three) holder;
                Glide.with(context).load(Url.IMAGE + list.get(3).getTag()
                        .get(0).getPicUrl()).placeholder(R.mipmap.ahahah)
                        .into(holder_three.image0);
                Glide.with(context).load(Url.IMAGE + list.get(3).getTag()
                        .get(1).getPicUrl()).placeholder(R.mipmap.ahahah)
                        .into(holder_three.image1);
                Glide.with(context).load(Url.IMAGE + list.get(3).getTag()
                        .get(2).getPicUrl()).placeholder(R.mipmap.ahahah)
                        .into(holder_three.image2);
                Glide.with(context).load(Url.IMAGE + list.get(3).getTag()
                        .get(3).getPicUrl()).placeholder(R.mipmap.ahahah)
                        .into(holder_three.image3);
                Glide.with(context).load(Url.IMAGE + list.get(3).getTag()
                        .get(4).getPicUrl()).placeholder(R.mipmap.ahahah)
                        .into(holder_three.image4);
                Glide.with(context).load(Url.IMAGE + list.get(3).getTag()
                        .get(5).getPicUrl()).placeholder(R.mipmap.ahahah)
                        .into(holder_three.image5);
                Glide.with(context).load(Url.IMAGE + list.get(3).getTag()
                        .get(6).getPicUrl()).placeholder(R.mipmap.ahahah)
                        .into(holder_three.image6);
                Glide.with(context).load(Url.IMAGE + list.get(3).getTag()
                        .get(7).getPicUrl()).placeholder(R.mipmap.ahahah)
                        .into(holder_three.image7);
                Glide.with(context).load(Url.IMAGE + list.get(3).getTag()
                        .get(8).getPicUrl()).placeholder(R.mipmap.ahahah)
                        .into(holder_three.image8);

                setClickListener(holder_three);
                break;

            case 3:
                ViewHolder_Four holder_four = (ViewHolder_Four) holder;
                Glide.with(context).load(Url.IMAGE + list.get(5).getTag()
                        .get(0).getPicUrl()).placeholder(R.mipmap.ahahah)
                        .into(holder_four.item_home_four_activity_image);
                Glide.with(context).load(Url.IMAGE + list.get(6).getTag()
                        .get(0).getPicUrl()).placeholder(R.mipmap.ahahah)
                        .into(holder_four.item_home_four_big_poly_hui_image);
                Glide.with(context).load(Url.IMAGE + list.get(6).getTag()
                        .get(1).getPicUrl()).placeholder(R.mipmap.ahahah)
                        .into(holder_four.item_home_four_tesco_image);
                setClickListener(holder_four);
                break;
            case 4:
                ViewHolder_Five holder_five = (ViewHolder_Five) holder;
                Glide.with(context).load(Url.IMAGE + list.get(8).getTag()
                        .get(0).getPicUrl()).placeholder(R.mipmap.ahahah)
                        .into(holder_five.item_home_five_knowledge_image);
                Glide.with(context).load(Url.IMAGE + list.get(9).getTag()
                        .get(0).getPicUrl()).placeholder(R.mipmap.ahahah)
                        .into(holder_five.item_home_five_newborn_image);
                Glide.with(context).load(Url.IMAGE + list.get(9).getTag()
                        .get(1).getPicUrl()).placeholder(R.mipmap.ahahah)
                        .into(holder_five.item_home_five_infant_image);
                Glide.with(context).load(Url.IMAGE + list.get(10).getTag()
                        .get(0).getPicUrl()).placeholder(R.mipmap.ahahah)
                        .into(holder_five.item_home_five_infant_prefecture_image);
                Glide.with(context).load(Url.IMAGE + list.get(10).getTag()
                        .get(1).getPicUrl()).placeholder(R.mipmap.ahahah)
                        .into(holder_five.item_home_five_preschool_prefecture_image);
                Glide.with(context).load(Url.IMAGE + list.get(11).getTag()
                        .get(0).getPicUrl()).placeholder(R.mipmap.ahahah)
                        .into(holder_five.item_home_five_ready_prefecture_image);
                Glide.with(context).load(Url.IMAGE + list.get(11).getTag()
                        .get(1).getPicUrl()).placeholder(R.mipmap.ahahah)
                        .into(holder_five.item_home_five_gestation_prefecture_image);
                setClickListener(holder_five);
                break;
            case 5:
                ViewHolder_Six holder_Six = (ViewHolder_Six) holder;
                Glide.with(context).load(Url.IMAGE + list.get(13).getTag()
                        .get(0).getPicUrl()).placeholder(R.mipmap.ahahah)
                        .into(holder_Six.item_home_six_trademark_image);
                Glide.with(context).load(Url.IMAGE + list.get(14).getTag()
                        .get(0).getPicUrl()).placeholder(R.mipmap.ahahah)
                        .into(holder_Six.item_home_six_trademark_hui_image);
                Glide.with(context).load(Url.IMAGE + list.get(15).getTag()
                        .get(1).getPicUrl()).placeholder(R.mipmap.ahahah)
                        .into(holder_Six.item_home_six_image1);
                Glide.with(context).load(Url.IMAGE + list.get(15).getTag()
                        .get(2).getPicUrl()).placeholder(R.mipmap.ahahah)
                        .into(holder_Six.item_home_six_image2);
                Glide.with(context).load(Url.IMAGE + list.get(15).getTag()
                        .get(3).getPicUrl()).placeholder(R.mipmap.ahahah)
                        .into(holder_Six.item_home_six_image3);
                Glide.with(context).load(Url.IMAGE + list.get(15).getTag()
                        .get(4).getPicUrl()).placeholder(R.mipmap.ahahah)
                        .into(holder_Six.item_home_six_image4);
                Glide.with(context).load(Url.IMAGE + list.get(15).getTag()
                        .get(5).getPicUrl()).placeholder(R.mipmap.ahahah)
                        .into(holder_Six.item_home_six_image5);
                Glide.with(context).load(Url.IMAGE + list.get(15).getTag()
                        .get(6).getPicUrl()).placeholder(R.mipmap.ahahah)
                        .into(holder_Six.item_home_six_image6);
                Glide.with(context).load(Url.IMAGE + list.get(15).getTag()
                        .get(0).getPicUrl()).placeholder(R.mipmap.ahahah)
                        .into(holder_Six.item_home_six_image7);
                holder_Six.item_home_six_name1.setText(list.get(15).getTag().get(1).getElementName());
                holder_Six.item_home_six_name2.setText(list.get(15).getTag().get(2).getElementName());
                holder_Six.item_home_six_name3.setText(list.get(15).getTag().get(3).getElementName());
                holder_Six.item_home_six_name4.setText(list.get(15).getTag().get(4).getElementName());
                holder_Six.item_home_six_name5.setText(list.get(15).getTag().get(5).getElementName());
                holder_Six.item_home_six_name6.setText(list.get(15).getTag().get(6).getElementName());
                //holder_Six.item_home_six_name7.setText(list.get(15).getTag().get(0).getElementName());
                setClickListener(holder_Six);
                break;
            case 6:
                ViewHolder_Seven holder_seven = (ViewHolder_Seven) holder;
                Glide.with(context).load(Url.IMAGE + list.get(16).getTag()
                        .get(0).getPicUrl()).placeholder(R.mipmap.ahahah)
                        .into(holder_seven.item_home_seven_good_method_image);
                Glide.with(context).load(Url.IMAGE + list.get(17).getTag()
                        .get(1).getPicUrl()).placeholder(R.mipmap.ahahah)
                        .into(holder_seven.item_home_seven_image1);
                Glide.with(context).load(Url.IMAGE + list.get(17).getTag()
                        .get(2).getPicUrl()).placeholder(R.mipmap.ahahah)
                        .into(holder_seven.item_home_seven_image2);
                Glide.with(context).load(Url.IMAGE + list.get(17).getTag()
                        .get(3).getPicUrl()).placeholder(R.mipmap.ahahah)
                        .into(holder_seven.item_home_seven_image3);
                Glide.with(context).load(Url.IMAGE + list.get(17).getTag()
                        .get(4).getPicUrl()).placeholder(R.mipmap.ahahah)
                        .into(holder_seven.item_home_seven_image4);
                Glide.with(context).load(Url.IMAGE + list.get(17).getTag()
                        .get(5).getPicUrl()).placeholder(R.mipmap.ahahah)
                        .into(holder_seven.item_home_seven_image5);
                Glide.with(context).load(Url.IMAGE + list.get(17).getTag()
                        .get(6).getPicUrl()).placeholder(R.mipmap.ahahah)
                        .into(holder_seven.item_home_seven_image6);
                Glide.with(context).load(Url.IMAGE + list.get(17).getTag()
                        .get(0).getPicUrl()).placeholder(R.mipmap.ahahah)
                        .into(holder_seven.item_home_seven_image7);
                holder_seven.item_home_seven_name1.setText(list.get(17).getTag().get(1).getElementName());
                holder_seven.item_home_seven_name2.setText(list.get(17).getTag().get(2).getElementName());
                holder_seven.item_home_seven_name3.setText(list.get(17).getTag().get(3).getElementName());
                holder_seven.item_home_seven_name4.setText(list.get(17).getTag().get(4).getElementName());
                holder_seven.item_home_seven_name5.setText(list.get(17).getTag().get(5).getElementName());
                holder_seven.item_home_seven_name6.setText(list.get(17).getTag().get(6).getElementName());
                break;
        }
        holder.itemView.setTag(position);
    }

    public void setClickListener(final RecyclerView.ViewHolder holder) {
        if (itemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemClickListener.OnItemClickListener(holder.itemView, holder.getLayoutPosition());
                }
            });
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

    public void setOnItemClickListener(MyOnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void setOnItemLongClickListener(MyOnItemLongClickListener itemLongClickListener) {
        this.itemLongClickListener = itemLongClickListener;
    }

    public class ViewHolder_One extends RecyclerView.ViewHolder {
        ImageView item_home_one_image;

        public ViewHolder_One(View itemView) {
            super(itemView);
            item_home_one_image = (ImageView) itemView.findViewById(R.id.item_home_one_image);

            item_home_one_image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, WebViewShow.class);
                    intent.putExtra("url", list.get(1).getTag().get(0).getLinkUrl());
                    context.startActivity(intent);
                }
            });
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

            lotto_image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, WebViewShow.class);
                    intent.putExtra("url", list.get(2).getTag().get(0).getLinkUrl());
                    context.startActivity(intent);
                }
            });
            centre_image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, WebViewShow.class);
                    intent.putExtra("url", list.get(2).getTag().get(1).getLinkUrl());
                    context.startActivity(intent);
                }
            });
            import_image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, WebViewShow.class);
                    intent.putExtra("url", list.get(2).getTag().get(2).getLinkUrl());
                    context.startActivity(intent);
                }
            });
            probation_image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, WebViewShow.class);
                    intent.putExtra("url", list.get(2).getTag().get(3).getLinkUrl());
                    context.startActivity(intent);
                }
            });
            pregnant_image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, WebViewShow.class);
                    intent.putExtra("url", list.get(2).getTag().get(4).getLinkUrl());
                    context.startActivity(intent);
                }
            });

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
        TextView item_home_three_text1;
        TextView item_home_three_text2;
        TextView item_home_three_text3;
        TextView item_home_three_text4;
        TextView item_home_three_text5;
        TextView item_home_three_text6;
        TextView item_home_three_text7;


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
            item_home_three_text1 = (TextView) itemView.findViewById(R.id.item_home_three_text1);
            item_home_three_text2 = (TextView) itemView.findViewById(R.id.item_home_three_text2);
            item_home_three_text3 = (TextView) itemView.findViewById(R.id.item_home_three_text3);
            item_home_three_text4 = (TextView) itemView.findViewById(R.id.item_home_three_text4);
            item_home_three_text5 = (TextView) itemView.findViewById(R.id.item_home_three_text5);
            item_home_three_text6 = (TextView) itemView.findViewById(R.id.item_home_three_text6);
            item_home_three_text7 = (TextView) itemView.findViewById(R.id.item_home_three_text7);
            item_home_three_text1.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            item_home_three_text2.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            item_home_three_text3.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            item_home_three_text4.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            item_home_three_text5.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            item_home_three_text6.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            item_home_three_text7.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);


            image1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ShoppingCarActivity.class);
                    intent.putExtra("position", Url.IMAGE + list.get(3).getTag().get(1).getPicUrl());
                    //Log.e("==================",Url.IMAGE+list.get(3).getTag().get(1).getLinkUrl());
                    intent.putExtra("shopName", list.get(3).getTag().get(1).getElementName());
                    intent.putExtra("shopPrice", "¥169.0");
                    context.startActivity(intent);
                }
            });

            image2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ShoppingCarActivity.class);
                    intent.putExtra("position", Url.IMAGE + list.get(3).getTag().get(2).getPicUrl());
                    intent.putExtra("shopName", list.get(3).getTag().get(2).getElementName());
                    intent.putExtra("shopPrice", "¥29.0");
                    context.startActivity(intent);
                }
            });
            image3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ShoppingCarActivity.class);
                    intent.putExtra("position", Url.IMAGE + list.get(3).getTag().get(3).getPicUrl());
                    intent.putExtra("shopName", list.get(3).getTag().get(3).getElementName());
                    intent.putExtra("shopPrice", "¥35.90");
                    context.startActivity(intent);
                }
            });
            image4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ShoppingCarActivity.class);
                    intent.putExtra("position", Url.IMAGE + list.get(3).getTag().get(4).getPicUrl());
                    intent.putExtra("shopName", list.get(3).getTag().get(4).getElementName());
                    intent.putExtra("shopPrice", "¥33.0");
                    context.startActivity(intent);
                }
            });
            image5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ShoppingCarActivity.class);
                    intent.putExtra("position", Url.IMAGE + list.get(3).getTag().get(5).getPicUrl());
                    intent.putExtra("shopName", list.get(3).getTag().get(6).getElementName());
                    intent.putExtra("shopPrice", "¥79.0");
                    context.startActivity(intent);
                }
            });
            image6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ShoppingCarActivity.class);
                    intent.putExtra("position", Url.IMAGE + list.get(3).getTag().get(6).getPicUrl());
                    intent.putExtra("shopName", list.get(3).getTag().get(6).getElementName());
                    intent.putExtra("shopPrice", "¥145.0");
                    context.startActivity(intent);
                }
            });
            image7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ShoppingCarActivity.class);
                    intent.putExtra("position", Url.IMAGE + list.get(3).getTag().get(7).getPicUrl());
                    intent.putExtra("shopName", list.get(3).getTag().get(7).getElementName());
                    intent.putExtra("shopPrice", "¥89.0");
                    context.startActivity(intent);
                }
            });
            image8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ShoppingCarActivity.class);
                    intent.putExtra("position", Url.IMAGE + list.get(3).getTag().get(8).getPicUrl());
                    intent.putExtra("shopName", list.get(3).getTag().get(8).getElementName());
                    intent.putExtra("shopPrice", "¥0.0");
                    context.startActivity(intent);
                }
            });

        }
    }

    public class ViewHolder_Four extends RecyclerView.ViewHolder {
        ImageView item_home_four_activity_image;
        ImageView item_home_four_big_poly_hui_image;
        ImageView item_home_four_tesco_image;

        public ViewHolder_Four(View itemView) {
            super(itemView);
            item_home_four_activity_image = (ImageView) itemView.findViewById(R.id.item_home_four_activity_image);
            item_home_four_big_poly_hui_image = (ImageView) itemView.findViewById(R.id.item_home_four_big_poly_hui_image);
            item_home_four_tesco_image = (ImageView) itemView.findViewById(R.id.item_home_four_tesco_image);
            item_home_four_big_poly_hui_image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, WebViewShow.class);
                    intent.putExtra("url", list.get(6).getTag().get(0).getLinkUrl());
                    context.startActivity(intent);
                }
            });
            item_home_four_tesco_image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, WebViewShow.class);
                    intent.putExtra("url", list.get(6).getTag().get(1).getLinkUrl());
                    context.startActivity(intent);
                }
            });
        }
    }

    public class ViewHolder_Five extends RecyclerView.ViewHolder {
        ImageView item_home_five_knowledge_image;
        ImageView item_home_five_newborn_image;
        ImageView item_home_five_infant_image;
        ImageView item_home_five_infant_prefecture_image;
        ImageView item_home_five_preschool_prefecture_image;
        ImageView item_home_five_ready_prefecture_image;
        ImageView item_home_five_gestation_prefecture_image;


        public ViewHolder_Five(View itemView) {
            super(itemView);
            item_home_five_knowledge_image = (ImageView) itemView.findViewById(R.id.item_home_five_knowledge_image);
            item_home_five_newborn_image = (ImageView) itemView.findViewById(R.id.item_home_five_newborn_image);
            item_home_five_infant_image = (ImageView) itemView.findViewById(R.id.item_home_five_infant_image);
            item_home_five_infant_prefecture_image = (ImageView) itemView.findViewById(R.id.item_home_five_infant_prefecture_image);
            item_home_five_preschool_prefecture_image = (ImageView) itemView.findViewById(R.id.item_home_five_preschool_prefecture_image);
            item_home_five_ready_prefecture_image = (ImageView) itemView.findViewById(R.id.item_home_five_ready_prefecture_image);
            item_home_five_gestation_prefecture_image = (ImageView) itemView.findViewById(R.id.item_home_five_gestation_prefecture_image);

        }
    }

    public class ViewHolder_Six extends RecyclerView.ViewHolder {
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

        public ViewHolder_Six(View itemView) {
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

            item_home_six_image1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ShoppingCarActivity.class);
                    intent.putExtra("position", Url.IMAGE + list.get(15).getTag()
                            .get(1).getPicUrl());

                    intent.putExtra("shopName", list.get(15).getTag()
                            .get(1).getElementName());
                    intent.putExtra("shopPrice", "¥151.2");
                    context.startActivity(intent);
                }
            });

            item_home_six_image2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ShoppingCarActivity.class);
                    intent.putExtra("position", Url.IMAGE + list.get(15).getTag()
                            .get(2).getPicUrl());
                    intent.putExtra("shopName", list.get(15).getTag()
                            .get(2).getElementName());
                    intent.putExtra("shopPrice", "¥149.0");
                    context.startActivity(intent);
                }
            });
            item_home_six_image3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ShoppingCarActivity.class);
                    intent.putExtra("position", Url.IMAGE + list.get(15).getTag()
                            .get(3).getPicUrl());
                    intent.putExtra("shopName", list.get(15).getTag()
                            .get(3).getElementName());
                    intent.putExtra("shopPrice", "¥69.0");
                    context.startActivity(intent);
                }
            });
            item_home_six_image4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ShoppingCarActivity.class);
                    intent.putExtra("position", Url.IMAGE + list.get(3).getTag().get(4).getPicUrl());
                    intent.putExtra("shopName", list.get(15).getTag()
                            .get(4).getElementName());
                    intent.putExtra("shopPrice", "¥49.0");
                    context.startActivity(intent);
                }
            });
            item_home_six_image5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ShoppingCarActivity.class);
                    intent.putExtra("position", Url.IMAGE + list.get(15).getTag()
                            .get(5).getPicUrl());
                    intent.putExtra("shopName", list.get(15).getTag()
                            .get(5).getElementName());
                    intent.putExtra("shopPrice", "¥79.0");
                    context.startActivity(intent);
                }
            });
            item_home_six_image6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ShoppingCarActivity.class);
                    intent.putExtra("position", Url.IMAGE + list.get(15).getTag()
                            .get(6).getPicUrl());
                    intent.putExtra("shopName", list.get(15).getTag()
                            .get(6).getElementName());
                    intent.putExtra("shopPrice", "¥28.8");
                    context.startActivity(intent);
                }
            });


        }
    }

    public class ViewHolder_Seven extends RecyclerView.ViewHolder {
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


        public ViewHolder_Seven(View itemView) {
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

            item_home_seven_image1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ShoppingCarActivity.class);
                    intent.putExtra("position", Url.IMAGE + list.get(17).getTag()
                            .get(1).getPicUrl());

                    intent.putExtra("shopName", list.get(17).getTag()
                            .get(1).getElementName());
                    intent.putExtra("shopPrice", "¥151.2");
                    context.startActivity(intent);
                }
            });

            item_home_seven_image2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ShoppingCarActivity.class);
                    intent.putExtra("position", Url.IMAGE + list.get(17).getTag()
                            .get(2).getPicUrl());
                    intent.putExtra("shopName", list.get(17).getTag()
                            .get(2).getElementName());
                    intent.putExtra("shopPrice", "¥9.9");
                    context.startActivity(intent);
                }
            });
            item_home_seven_image3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ShoppingCarActivity.class);
                    intent.putExtra("position", Url.IMAGE + list.get(17).getTag()
                            .get(3).getPicUrl());
                    intent.putExtra("shopName", list.get(17).getTag()
                            .get(3).getElementName());
                    intent.putExtra("shopPrice", "¥9.9");
                    context.startActivity(intent);
                }
            });
            item_home_seven_image4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ShoppingCarActivity.class);
                    intent.putExtra("position", Url.IMAGE + list.get(17).getTag()
                            .get(4).getPicUrl());
                    intent.putExtra("shopName", list.get(17).getTag()
                            .get(4).getElementName());
                    intent.putExtra("shopPrice", "¥9.9");
                    context.startActivity(intent);
                }
            });
            item_home_seven_image5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ShoppingCarActivity.class);
                    intent.putExtra("position", Url.IMAGE + list.get(17).getTag()
                            .get(5).getPicUrl());
                    intent.putExtra("shopName", list.get(17).getTag()
                            .get(5).getElementName());
                    intent.putExtra("shopPrice", "¥9.9");
                    context.startActivity(intent);
                }
            });
            item_home_seven_image6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ShoppingCarActivity.class);
                    intent.putExtra("position", Url.IMAGE + list.get(17).getTag()
                            .get(6).getPicUrl());
                    intent.putExtra("shopName", list.get(17).getTag()
                            .get(6).getElementName());
                    intent.putExtra("shopPrice", "¥9.9");
                    context.startActivity(intent);
                }
            });
        }
    }

}
