package com.e.demo_greendao.manager;

import android.content.Context;

import com.e.demo_greendao.Myapplication;
import com.e.demo_greendao.model.GoodsModel;
import com.e.demo_greendao.model.GoodsModelDao;
import com.e.demo_greendao.utils.DataUtils;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * @author: majin
 * @date: 2020/4/27$
 * @desc:
 */
public class GreenDaoManager {

    private Context       mContext;
    private GoodsModelDao mGoodsModelDao;

    public GreenDaoManager(Context mContext) {
        this.mContext = mContext;
        mGoodsModelDao = Myapplication.daoSession.getGoodsModelDao();
    }

    /**
     * 添加所有数据到数据库
     */

    public void insertGoods() {
        String json = DataUtils.getJson("goods.json", mContext);
        List<GoodsModel> goodsModels = DataUtils.getGoodsModels(json);
        mGoodsModelDao.insertInTx(goodsModels);
    }

    /**
     * 查询数据
     */

    public List<GoodsModel> queryGoods() {
        QueryBuilder<GoodsModel> queryBuilder = mGoodsModelDao.queryBuilder();
        //按照Id查询
        QueryBuilder<GoodsModel> query = queryBuilder.orderAsc(GoodsModelDao.Properties.Id);
        return query.list();
    }

    /**
     * 筛选水果
     *
     * @return
     */
    public List<GoodsModel> queryFruits() {
        QueryBuilder<GoodsModel> queryBuilder = mGoodsModelDao.queryBuilder();
        QueryBuilder<GoodsModel> where = queryBuilder.where(GoodsModelDao.Properties.Type.eq("0")).orderAsc(GoodsModelDao.Properties.GoodsId);
        return where.list();
    }

    /**
     * 筛选零食
     *
     * @return
     */
    public List<GoodsModel> querySnacks() {
        QueryBuilder<GoodsModel> queryBuilder = mGoodsModelDao.queryBuilder();
        QueryBuilder<GoodsModel> where = queryBuilder.where(GoodsModelDao.Properties.Type.eq("1")).orderAsc(GoodsModelDao.Properties.GoodsId);
        return where.list();
    }

    /**
     * 删除指定数据
     */
    public void deleteGoodsInfo(GoodsModel goodsModel) {
        mGoodsModelDao.delete(goodsModel);
    }
    /**
     * 修改指定数据
     */
    public void updateGoodsInfo(GoodsModel goodsModel) {
        mGoodsModelDao.update(goodsModel);
    }
}
