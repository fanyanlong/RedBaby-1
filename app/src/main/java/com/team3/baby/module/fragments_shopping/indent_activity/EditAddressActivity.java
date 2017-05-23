package com.team3.baby.module.fragments_shopping.indent_activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.team3.baby.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EditAddressActivity extends AppCompatActivity {

    @BindView(R.id.iv_back_head_include)
    ImageView ivBackHeadInclude;
    @BindView(R.id.tv_head_include)
    TextView tvHeadInclude;
    @BindView(R.id.et_consignee_edit_address_activity)
    EditText etConsigneeEditAddressActivity;
    @BindView(R.id.et_phoneNum_edit_address_activity)
    EditText etPhoneNumEditAddressActivity;
    @BindView(R.id.item_area_edit_address_activity)
    LinearLayout itemAreaEditAddressActivity;
    @BindView(R.id.et_address_edit_address_activity)
    EditText etAddressEditAddressActivity;
    @BindView(R.id.chk_setNormalAddress_edit_address_activity)
    CheckBox chkSetNormalAddressEditAddressActivity;
    @BindView(R.id.btn_saveAndUse_edit_address_activity)
    Button btnSaveAndUseEditAddressActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_address);
        ButterKnife.bind(this);
        tvHeadInclude.setText("新增地址");
    }

}
