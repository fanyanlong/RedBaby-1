package com.team3.baby.module.fragments_myebuy.activity_myebuy;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.mylhyl.acp.Acp;
import com.mylhyl.acp.AcpListener;
import com.mylhyl.acp.AcpOptions;
import com.team3.baby.R;
import com.team3.baby.module.fragments_myebuy.ShowItem;
import com.team3.baby.module.fragments_myebuy.bean_myebuy.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

/**
 * @类的用途:
 * @author:jiajianhai
 * @date:2017/5/19
 */

public class MyDiTu extends Activity {
    MapView mMapView = null;
    private BaiduMap baiduMap;
    private boolean isFirstLoc = true;
    private LocationClient mLocationClient;
    public BDLocationListener myListener = new MyLocationListener();
    private MapView mapView;
    private TextView tv;
    private Button que;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        //注意该方法要再setContentView方法之前实现
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.ditu);
        tv = (TextView) findViewById(R.id.dizhi);
        que = (Button) findViewById(R.id.bt_qurendizhi_mebuy);
        que.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyDiTu.this, ShowItem.class);
                intent.putExtra("dizhi", tv.getText().toString());
                startActivity(intent);
                finish();
            }
        });

        Acp.getInstance(this).request(new AcpOptions.Builder()
                        .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE
                                , Manifest.permission.READ_PHONE_STATE
                                , Manifest.permission.SEND_SMS
                                , Manifest.permission.ACCESS_COARSE_LOCATION
                                , Manifest.permission.LOCATION_HARDWARE
                                , Manifest.permission.ACCESS_FINE_LOCATION
                        )
                /*以下为自定义提示语、按钮文字
                .setDeniedMessage()
                .setDeniedCloseBtn()
                .setDeniedSettingBtn()
                .setRationalMessage()
                .setRationalBtn()*/
                        .build(),
                new AcpListener() {
                    @Override
                    public void onGranted() {
                        mMapView = (MapView) findViewById(R.id.bmapView);
                        //获取地图
                        baiduMap = mMapView.getMap();
                        //开启定位图层
                        baiduMap.setMyLocationEnabled(true);

                        //初始化定位对象  声明LocationClient类
                        mLocationClient = new LocationClient(getApplicationContext());
                        //注册监听函数
                        mLocationClient.registerLocationListener(myListener);

                        initLocation();
                        mLocationClient.start();
                        //普通地图
                        //  mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
                        //卫星地图
                        //  mBaiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
                        //开启交通图
                        baiduMap.setTrafficEnabled(true);
                        //开启热力图
                        // mBaiduMap.setBaiduHeatMapEnabled(true);

                        //地图标注
                        //定义Maker坐标点
                        LatLng latLng = new LatLng(39.963175, 116.400244);
                        //构建Marker图标
                        BitmapDescriptor bitmap = BitmapDescriptorFactory
                                .fromResource(R.mipmap.a);

                        //-------------------------------------------------------------------------------------------

                        //第一种方式直接显示地图标注 构建MarkerOption，用于在地图上添加Marker
                        OverlayOptions option = new MarkerOptions()
                                .position(latLng)
                                .icon(bitmap).draggable(true);  //设置手势拖拽;
                        //在地图上添加Marker，并显示
                        baiduMap.addOverlay(option);
//-------------------------------------------------------------------------------------------
                        LatLng latLngA = new LatLng(39.963175, 116.300244);
                        BitmapDescriptor bdAgrop = BitmapDescriptorFactory
                                .fromResource(R.mipmap.a);
                        //第二种方式添加掉下动画效果
                        final MarkerOptions ooA = new MarkerOptions().position(latLngA).icon(bdAgrop)
                                .zIndex(9).draggable(true);

                        // 掉下动画
                        // ooA.animateType(MarkerOptions.MarkerAnimateType.drop);
                        ooA.animateType(MarkerOptions.MarkerAnimateType.grow);
                        //在地图上添加Marker，并显示
                        // mBaiduMap.addOverlay(ooA);
                        final Marker mMarkerA = (Marker) (baiduMap.addOverlay(ooA));
//-------------------------------------------------------------------------------------------

                        //帖动画效果
                        // 通过marker的icons设置一组图片，再通过period设置多少帧刷新一次图片资源
       /* ArrayList<BitmapDescriptor> giflist = new ArrayList<BitmapDescriptor>();
        giflist.add(bdA);
        giflist.add(bdB);
        giflist.add(bdC);*/
                        //定义Maker坐标点
   /*     LatLng latLngD = new LatLng(39.763175, 116.400244);
        final OverlayOptions ooD = new MarkerOptions().position(latLngD).icons(giflist)
                .zIndex(0).period(10);
        baiduMap.addOverlay(ooD);*/
                        // Marker   mMarkerD = (Marker) (mBaiduMap.addOverlay(ooD));

                        //实现Marker的点击
        /*baiduMap.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                //判断对应Marker
                if (mMarkerA == marker) {
                    Intent intent = new Intent(MainActivity.this, LocationActivity.class);
                    startActivity(intent);
                }

                return true;
            }
        });*/
                    }

                    @Override
                    public void onDenied(List<String> permissions) {

                        Toast.makeText(getApplication(), permissions.toString() + "权限拒绝", Toast.LENGTH_SHORT).show();
                    }
                });


    }


    private void initLocation() {
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        //可选，默认高精度，设置定位模式，高精度，低功耗，仅设备

        option.setCoorType("bd09ll");
        //可选，默认gcj02，设置返回的定位结果坐标系

        int span = 1000;
        option.setScanSpan(span);
        //可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的

        option.setIsNeedAddress(true);
        //可选，设置是否需要地址信息，默认不需要

        option.setOpenGps(true);
        //可选，默认false,设置是否使用gps

        option.setLocationNotify(true);
        //可选，默认false，设置是否当GPS有效时按照1S/1次频率输出GPS结果

        option.setIsNeedLocationDescribe(true);
        //可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”

        option.setIsNeedLocationPoiList(true);
        //可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到

        option.setIgnoreKillProcess(false);
        //可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死

        option.SetIgnoreCacheException(false);
        //可选，默认false，设置是否收集CRASH信息，默认收集

        option.setEnableSimulateGps(false);
        //可选，默认false，设置是否需要过滤GPS仿真结果，默认需要

        mLocationClient.setLocOption(option);


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
    }

  /*  @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }*/


    public class MyLocationListener implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation location) {

            //获取定位结果
            StringBuffer sb = new StringBuffer(256);

            sb.append("time : ");
            sb.append(location.getTime());    //获取定位时间

            sb.append("\nerror code : ");
            sb.append(location.getLocType());    //获取类型类型

            sb.append("\nlatitude : ");
            sb.append(location.getLatitude());    //获取纬度信息

            sb.append("\nlontitude : ");
            sb.append(location.getLongitude());    //获取经度信息

            sb.append("\nradius : ");
            sb.append(location.getRadius());    //获取定位精准度
//---------------------将地图跟定位关联起来----------------------------------------
            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(location.getRadius())//这个是精准度设置
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(100).latitude(location.getLatitude())
                    .longitude(location.getLongitude()).build();
            // 设置定位数据
            baiduMap.setMyLocationData(locData);

            if (isFirstLoc) {
                isFirstLoc = false;
                //经纬度信息
                LatLng ll = new LatLng(location.getLatitude(),
                        location.getLongitude());
                //地图状态
                MapStatus.Builder builder = new MapStatus.Builder();

                builder.target(ll)
                        .zoom(18.0f);//放大
                baiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
            }
//---------------------将地图跟定位关联起来----------------------------------------

            if (location.getLocType() == BDLocation.TypeGpsLocation) {

                // GPS定位结果
                sb.append("\nspeed : ");
                sb.append(location.getSpeed());    // 单位：公里每小时

                sb.append("\nsatellite : ");
                sb.append(location.getSatelliteNumber());    //获取卫星数

                sb.append("\nheight : ");
                sb.append(location.getAltitude());    //获取海拔高度信息，单位米

                sb.append("\ndirection : ");
                sb.append(location.getDirection());    //获取方向信息，单位度

                sb.append("\naddr : ");
                sb.append(location.getAddrStr());    //获取地址信息

                sb.append("\ndescribe : ");
                sb.append("gps定位成功");

            } else if (location.getLocType() == BDLocation.TypeNetWorkLocation) {

                // 网络定位结果
                sb.append("\naddr : ");
                sb.append(location.getAddrStr());    //获取地址信息

                sb.append("\noperationers : ");
                sb.append(location.getOperators());    //获取运营商信息

                sb.append("\ndescribe : ");
                sb.append("网络定位成功");

            } else if (location.getLocType() == BDLocation.TypeOffLineLocation) {

                // 离线定位结果
                sb.append("\ndescribe : ");
                sb.append("离线定位成功，离线定位结果也是有效的");

            } else if (location.getLocType() == BDLocation.TypeServerError) {

                sb.append("\ndescribe : ");
                sb.append("服务端网络定位失败，可以反馈IMEI号和大体定位时间到loc-bugs@baidu.com，会有人追查原因");

            } else if (location.getLocType() == BDLocation.TypeNetWorkException) {

                sb.append("\ndescribe : ");
                sb.append("网络不同导致定位失败，请检查网络是否通畅");

            } else if (location.getLocType() == BDLocation.TypeCriteriaException) {

                sb.append("\ndescribe : ");
                sb.append("无法获取有效定位依据导致定位失败，一般是由于手机的原因，处于飞行模式下一般会造成这种结果，可以试着重启手机");

            }

            sb.append("\nlocationdescribe : ");
            sb.append(location.getLocationDescribe());    //位置语义化信息

            final List<Poi> list = location.getPoiList();    // POI数据
            if (list != null) {
                sb.append("\npoilist size = : ");
                sb.append(list.size());
                for (Poi p : list) {
                    sb.append("\npoi= : ");
                    sb.append(p.getId() + " " + p.getName() + " " + p.getRank());
                }

            }
            //此方法运行在子线程
           /* runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(MainActivity.this, "当前位置为"+list.get(0).getName(), Toast.LENGTH_SHORT).show();
                   // tv_location.setText(list.get(2).getName());
                }
            });*/
            Log.i("BaiduLocationApiDem", sb.toString() + ",目前位置：" + list.get(2).getName());
            final String[] items = new String[list.size() + 1];
            for (int i = 0; i < list.size(); i++) {
                items[i] = list.get(i).getName();
            }
            items[list.size()] = "自己定义地址";


            final AlertDialog.Builder builder = new AlertDialog.Builder(MyDiTu.this);
            builder.setTitle("请选择您的收货地址：");
            builder.setItems(items, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (i == list.size()) {
                        Intent intent = new Intent(MyDiTu.this, ShowItem.class);
                        intent.putExtra("dizhi", "自定义...");
                        startActivity(intent);
                        finish();

                    } else {
                        EventBus.getDefault().post(new MessageEvent(items[i]));

                    }

                }
            });
            builder.create().show();
        }


        @Override
        public void onConnectHotSpotMessage(String s, int i) {

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
        finish();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessage(MessageEvent message) {
        tv.setText(message.getMessage());
    }


}
