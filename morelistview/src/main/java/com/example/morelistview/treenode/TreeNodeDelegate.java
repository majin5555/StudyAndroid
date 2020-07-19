package com.example.morelistview.treenode;

import com.example.morelistview.BeHierarchyCatalog;

public abstract class TreeNodeDelegate<T> {
   public TreeNodeAdapter<T> adapter;
    /**
     * 是否是当前类型
     *
     * @param treeNode 树节点
     * @return 当前类型
     */
    public abstract boolean isItemType(BeHierarchyCatalog.DataBean.SectionsBean  treeNode);

    /**
     * 当前根视图布局id
     *
     * @return 布局id
     */
    public abstract int getLayoutId();

    /**
     * 视图适配
     *
     * @param holder   视图持有者
     * @param treeNode 树节点
     */
    public abstract void convert(ViewHolder holder,   BeHierarchyCatalog.DataBean.SectionsBean treeNode);
}
