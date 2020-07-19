package com.example.morelistview.treenode;

import android.content.Context;

import com.example.morelistview.BeHierarchyCatalog;

import java.util.List;

import androidx.annotation.NonNull;

public abstract class SimpleTreeNodeAdapter<T> extends TreeNodeAdapter<T> {
    /**
     * 构造器
     *
     * @param context  上下文
     * @param rootList 树节点根列表（所有数据）
     */
    public SimpleTreeNodeAdapter(Context context, int layoutId, @NonNull List<BeHierarchyCatalog.DataBean.SectionsBean> rootList) {
        super(context, rootList);
        final int layoutResId = layoutId;
        addItemViewDelegate(new TreeNodeDelegate<T>() {
            @Override
            public boolean isItemType(BeHierarchyCatalog.DataBean.SectionsBean treeNode) {
                return true;
            }

            @Override
            public int getLayoutId() {
                return layoutResId;
            }

            @Override
            public void convert(ViewHolder holder, BeHierarchyCatalog.DataBean.SectionsBean treeNode) {
                SimpleTreeNodeAdapter.this.convert(adapter, holder, treeNode);
            }
        });
    }

    public abstract void convert(TreeNodeAdapter<T> adapter, ViewHolder holder, BeHierarchyCatalog.DataBean.SectionsBean treeNode);
}
