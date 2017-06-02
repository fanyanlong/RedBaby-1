package com.team3.baby.module.fragments_shopping.indent_activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.smarttop.library.bean.City;
import com.smarttop.library.bean.County;
import com.smarttop.library.bean.Province;
import com.smarttop.library.bean.Street;
import com.smarttop.library.db.manager.AddressDictManager;
import com.smarttop.library.utils.LogUtil;
import com.smarttop.library.widget.AddressSelector;
import com.smarttop.library.widget.BottomDialog;
import com.smarttop.library.widget.OnAddressSelectedListener;
import com.team3.baby.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EditAddressActivity extends AppCompatActivity implements OnAddressSelectedListener, AddressSelector.OnDialogCloseListener {

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
    @BindView(R.id.tv_area_edit_address_activity)
    TextView tvAreaEditAddressActivity;
    @BindView(R.id.layout_city_address_activity)
    LinearLayout layoutCityAddressActivity;
    private AddressDictManager addressDictManager;
    private BottomDialog dialog;
    private String provinceCode;
    private String cityCode;
    private String countyCode;
    private String streetCode;
    private SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_address);
        ButterKnife.bind(this);
        tvHeadInclude.setText("新增地址");
        initListener();

        SharedPreferences sharedPreferences = getSharedPreferences("addAddress", MODE_PRIVATE);
        edit = sharedPreferences.edit();

    }

    private void initListener() {
        itemAreaEditAddressActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(EditAddressActivity.this, "address", Toast.LENGTH_SHORT).show();
                initAddress();
                onDialog();
            }
        });
        ivBackHeadInclude.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnSaveAndUseEditAddressActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String etAddress = etAddressEditAddressActivity.getText().toString().trim();
                if (TextUtils.isEmpty(etAddress)) {
                    Toast.makeText(EditAddressActivity.this, "详细地址不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                String etConsignee = etConsigneeEditAddressActivity.getText().toString().trim();
                if (TextUtils.isEmpty(etConsignee)) {
                    Toast.makeText(EditAddressActivity.this, "联系人不能为空", Toast.LENGTH_SHORT).show();

                    return;
                }
                String etPhoneNum = etPhoneNumEditAddressActivity.getText().toString().trim();
                if (TextUtils.isEmpty(etPhoneNum)) {
                    Toast.makeText(EditAddressActivity.this, "联系电话不能为空", Toast.LENGTH_SHORT).show();

                    return;
                }
                String tvArea = tvAreaEditAddressActivity.getText().toString().trim();
                if (tvArea.equals("请点击选择送货区域")) {
                    Toast.makeText(EditAddressActivity.this, "请点击选择送货区域", Toast.LENGTH_SHORT).show();

                    return;
                }
                edit.putString("address", etAddress);
                edit.putString("consignee", etConsignee);
                edit.putString("phoneNum", etPhoneNum);
                edit.putString("area", tvArea);
                edit.commit();
                finish();
            }
        });
    }

    private void initAddress() {
        AddressSelector selector = new AddressSelector(this);
        //获取地址管理数据库
        addressDictManager = selector.getAddressDictManager();

        selector.setTextSize(14);//设置字体的大小
//        selector.setIndicatorBackgroundColor("#00ff00");
        selector.setIndicatorBackgroundColor(android.R.color.holo_orange_light);//设置指示器的颜色
//        selector.setBackgroundColor(android.R.color.holo_red_light);//设置字体的背景

        selector.setTextSelectedColor(android.R.color.holo_orange_light);//设置字体获得焦点的颜色

        selector.setTextUnSelectedColor(android.R.color.holo_blue_light);//设置字体没有获得焦点的颜色

//        //获取数据库管理
//        AddressDictManager addressDictManager = selector.getAddressDictManager();
//        AdressBean.ChangeRecordsBean changeRecordsBean = new AdressBean.ChangeRecordsBean();
//        changeRecordsBean.parentId = 0;
//        changeRecordsBean.name = "测试省";
//        changeRecordsBean.id = 35;
//        addressDictManager.inserddress(changeRecordsBean);//对数据库里增加一个数据
        selector.setOnAddressSelectedListener(new OnAddressSelectedListener() {
            @Override
            public void onAddressSelected(Province province, City city, County county, Street street) {

            }
        });
        View view = selector.getView();
        layoutCityAddressActivity.addView(view);
    }


    public void onDialog() {
        if (dialog != null) {
            dialog.show();
        } else {
            dialog = new BottomDialog(this);
            dialog.setOnAddressSelectedListener(this);
            dialog.setDialogDismisListener(this);
            dialog.setTextSize(14);//设置字体的大小
            dialog.setIndicatorBackgroundColor(android.R.color.holo_orange_light);//设置指示器的颜色
            dialog.setTextSelectedColor(android.R.color.holo_orange_light);//设置字体获得焦点的颜色
            dialog.setTextUnSelectedColor(android.R.color.holo_blue_light);//设置字体没有获得焦点的颜色
            dialog.show();
        }
    }

    @Override
    public void onAddressSelected(Province province, City city, County county, Street street) {
        provinceCode = (province == null ? "" : province.code);
        cityCode = (city == null ? "" : city.code);
        countyCode = (county == null ? "" : county.code);
        streetCode = (street == null ? "" : street.code);
        LogUtil.d("数据", "省份id=" + provinceCode);
        LogUtil.d("数据", "城市id=" + cityCode);
        LogUtil.d("数据", "乡镇id=" + countyCode);
        LogUtil.d("数据", "街道id=" + streetCode);
        String s = (province == null ? "" : province.name) + (city == null ? "" : city.name) + (county == null ? "" : county.name) +
                (street == null ? "" : street.name);
        tvAreaEditAddressActivity.setText(s);
        if (dialog != null) {
            dialog.dismiss();
        }
//        getSelectedArea();
    }

    @Override
    public void dialogclose() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    /**
     * 根据code 来显示选择过的地区
     */
    private void getSelectedArea() {
        String province = addressDictManager.getProvince(provinceCode);
        String city = addressDictManager.getCity(cityCode);
        String county = addressDictManager.getCounty(countyCode);
        String street = addressDictManager.getStreet(streetCode);
        LogUtil.d("数据", "省份=" + province);
        LogUtil.d("数据", "城市=" + city);
        LogUtil.d("数据", "乡镇=" + county);
        LogUtil.d("数据", "街道=" + street);
    }
}
