package com.team3.baby.module.fragments_shopping.indent_activity;

import android.Manifest;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mylhyl.acp.Acp;
import com.mylhyl.acp.AcpListener;
import com.mylhyl.acp.AcpOptions;
import com.team3.baby.R;

import java.util.List;

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
        initListener();
    }

    private void initListener() {
        itemAreaEditAddressActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Acp.getInstance(EditAddressActivity.this).request(new AcpOptions.Builder()
                                .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE
                                        , Manifest.permission.READ_PHONE_STATE
                                        , Manifest.permission.SEND_SMS)
                /*//以下为自定义提示语、按钮文字
                .setDeniedMessage()
                .setDeniedCloseBtn()
                .setDeniedSettingBtn()
                .setRationalMessage()
                .setRationalBtn()*/
                                .build(),
                        new AcpListener() {
                            @Override
                            public void onGranted() {
                               /* Intent intent = new Intent(EditAddressActivity.this,LocationActivity.class);
                                startActivity(intent);
*/
                            }

                            @Override
                            public void onDenied(List<String> permissions) {
                            }
                        });
            }
        });
    }

}
