package com.e.demo_baidumap;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.e.demo_baidumap.bean.AddressInfo;
import com.e.demo_baidumap.bean.AddressInfoLab;
import com.e.demo_baidumap.view.AddressView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String       TAG                 = "MainActivity";
    public static        List<String> sNeedReqPermissions = new ArrayList<>();

    static {
        sNeedReqPermissions.add(Manifest.permission.READ_PHONE_STATE);
        sNeedReqPermissions.add(Manifest.permission.ACCESS_COARSE_LOCATION);
        sNeedReqPermissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
        sNeedReqPermissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }

    private             PermissionUtils  mPermissionUtils;
    public static final int              PERMISSION_RQUEST_CODE = 100;
    public static final int              ITEM_ID_NORMAL_MAP     = 101;
    public static final int              ITEM_ID_SATELITE_MAP   = 102;
    public static final int              ITEM_LOCATIO           = 103;
    public static final int              ITEM_SHOW_SHOPS        = 104;
    private             MapView          mMapView;
    private             BaiduMap         mMap;
    private             LocationInstance locationInstance;
    private             BDLocation       mCurrentlocationInstance;
    private             SensorInstance   mSensorInstance;
    private             boolean          mIsFirstLocation       = true;
    private             AddressView      mAddressView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //'首先判断当前的权限问题
        mPermissionUtils = new PermissionUtils(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mPermissionUtils.request(sNeedReqPermissions, PERMISSION_RQUEST_CODE, new PermissionUtils.CallBack() {
                @Override
                public void grantAll() {
                    Toast.makeText(MainActivity.this, "获取了全部权限", Toast.LENGTH_SHORT).show();
                    //finish();
                }

                @Override
                public void denied() {
                    finish();
                    Toast.makeText(MainActivity.this, "有权限未获取", Toast.LENGTH_SHORT).show();
                }
            });
        }

        //获取地图控件引用
        mMapView = (MapView) findViewById(R.id.bmapView);
        mMap = mMapView.getMap();
        mMap.setMapStatus(MapStatusUpdateFactory.zoomTo(15f));
        mSensorInstance = new SensorInstance(this);
        init();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        mPermissionUtils.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void init() {
        mAddressView = findViewById(R.id.id_address_view);
        initLocatiionDetect();
        initSensorDetect();
        initEvent();
    }

    private void initEvent() {

        mMap.setOnMapClickListener(new BaiduMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                mAddressView.setVisibility(View.GONE);
            }

            @Override
            public void onMapPoiClick(MapPoi mapPoi) {
            }
        });

        mMap.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {

            @Override
            public boolean onMarkerClick(Marker marker) {

                Bundle extraInfo = marker.getExtraInfo();
                AddressInfo addressInfo = (AddressInfo) extraInfo.getSerializable(KEY_SHOP_INFO);
               //   Log.d("imooc_map", addressInfo.getName());
                Toast.makeText(MainActivity.this, addressInfo.getName(), Toast.LENGTH_SHORT).show();
                // show view
                mAddressView.setAddressInfo(addressInfo);
                return false;
            }
        });

    }

    private void initSensorDetect() {
        // 开启定位图层
        mMap.setMyLocationEnabled(true);
        mSensorInstance = new SensorInstance(getApplicationContext());
        mSensorInstance.setOnOrientationChangedListener(
                new SensorInstance.OnOrientationChangedListener() {
                    @Override
                    public void onOrientation(float x) {
                        // 设置定位图标；
                        if (mCurrentlocationInstance == null) {
                            return;
                        }

                        // 构造定位数据
                        MyLocationData locData = new MyLocationData.Builder()
                                .accuracy(mCurrentlocationInstance.getRadius())
                                // 此处设置开发者获取到的方向信息，顺时针0-360
                                .direction(x).latitude(mCurrentlocationInstance.getLatitude())
                                .longitude(mCurrentlocationInstance.getLongitude()).build();

                        // 设置定位数据
                        mMap.setMyLocationData(locData);

                        // 设置定位图层的配置（定位模式，是否允许方向信息，用户自定义定位图标）
                        //                                        BitmapDescriptor mCurrentMarker = BitmapDescriptorFactory
                        //                                                .fromResource(R.mipmap.navi_map_gps_locked);
                        MyLocationConfiguration config = new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL,
                                true, null);
                        mMap.setMyLocationConfiguration(config);


                        if (mIsFirstLocation) {
                            mIsFirstLocation = false;
                            LatLng point = new LatLng(mCurrentlocationInstance.getLatitude(), mCurrentlocationInstance.getLongitude());
                            mMap.animateMapStatus(MapStatusUpdateFactory.newLatLng(point));
                        }
                        // 当不需要定位图层时关闭定位图层
                        //                mMap.setMyLocationEnabled(false);
                    }
                });
    }

    private void initLocatiionDetect() {

        locationInstance = new LocationInstance(this, new LocationInstance.MyLocationListener() {
            @Override
            public void onReceiveLocation(BDLocation location) {
                mCurrentlocationInstance = location;
                Log.d(TAG, " mCurrentlocationInstance  " + mCurrentlocationInstance.toString());
                super.onReceiveLocation(location);
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, ITEM_ID_NORMAL_MAP, 0, "普通地图");
        menu.add(Menu.NONE, ITEM_ID_SATELITE_MAP, 0, "卫星地图");
        menu.add(Menu.NONE, ITEM_LOCATIO, 0, "定位到我的位置");
        menu.add(Menu.NONE, ITEM_SHOW_SHOPS, 0, "附近商家");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case ITEM_ID_NORMAL_MAP:
                mMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
                break;
            case ITEM_ID_SATELITE_MAP:
                mMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
                break;
            case ITEM_LOCATIO:
                mMap.clear();
                if (mCurrentlocationInstance != null) {
                    //定义Maker坐标点
                    LatLng point = new LatLng(mCurrentlocationInstance.getLatitude(), mCurrentlocationInstance.getLongitude());
                    //构建Marker图标
                    BitmapDescriptor bitmap = BitmapDescriptorFactory
                            .fromResource(R.mipmap.navi_map_gps_locked);
                    //构建MarkerOption，用于在地图上添加Marker
                    OverlayOptions option = new MarkerOptions()
                            .position(point) //必传参数
                            .icon(bitmap) //必传参数
                            .draggable(true)
                            //设置平贴地图，在地图中双指下拉查看效果
                            .flat(true)
                            .alpha(0.5f);
                    //在地图上添加Marker，并显示
                    mMap.addOverlay(option);
                    mMap.animateMapStatus(MapStatusUpdateFactory.newLatLng(point));
                } else {
                    Toast.makeText(this, "mCurrentlocationInstance 为null", Toast.LENGTH_SHORT).show();
                }
                break;

            case ITEM_SHOW_SHOPS:
                mAddressView.setVisibility(View.GONE);
                // 1.遍历商家，添加marker
                showShops();
                break;

            default:
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private static final String KEY_SHOP_INFO = "key_shop_info";

    private void showShops() {
        mMap.clear();
        List<AddressInfo> addressInfos = AddressInfoLab.generateDatas();
        for (AddressInfo addressInfo : addressInfos) {
            //定义Maker坐标点
            LatLng point = new LatLng(addressInfo.getLatitude(),
                    addressInfo.getLongitude());
            //构建Marker图标
            BitmapDescriptor bitmap = BitmapDescriptorFactory
                    .fromResource(R.mipmap.maker);

            Bundle bundle = new Bundle();
            bundle.putSerializable(KEY_SHOP_INFO, addressInfo);
            //构建MarkerOption，用于在地图上添加Marker
            OverlayOptions option = new MarkerOptions()
                    .position(point)
                    .extraInfo(bundle)
                    .icon(bitmap);
            //在地图上添加Marker，并显示
            mMap.addOverlay(option);
        }
        if (addressInfos.isEmpty()) {
            return;
        }
        LatLng point = new LatLng(addressInfos.get(0).getLatitude(),
                addressInfos.get(0).getLongitude());
        mMap.animateMapStatus(MapStatusUpdateFactory.newLatLng(point));
    }

    @Override
    protected void onStart() {
        super.onStart();
        locationInstance.strat();
        mSensorInstance.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        locationInstance.stop();
        mSensorInstance.stop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
    }
}