package com.example.morelistview.treenode;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.morelistview.BeHierarchyCatalog;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 树节点多级列表适配器
 *
 * @param <T> 泛型，树节点数据的泛型
 */
public class TreeNodeAdapter<T> extends RecyclerView.Adapter<ViewHolder> {
    protected Context                                        context;// 上下文
    private   LayoutInflater                                 layoutInflater;// 视图渲染器
    private   List<TreeNodeDelegate<T>>                      treeNodeDelegateList = new ArrayList<>();// 所有布局类型
    private   List<BeHierarchyCatalog.DataBean.SectionsBean> showTreeNodeList     = new ArrayList<>();// 当前显示的树节点
    private   List<BeHierarchyCatalog.DataBean.SectionsBean> rootTreeNodeList;// 所有树节点
    private   int                                            maxSelectCount;// 多选个数 -->> 0：任意 非0：限制数量
    private   List<BeHierarchyCatalog.DataBean.SectionsBean> selectTreeNodeList   = new ArrayList<>();// 选中

    /**
     * 构造器
     *
     * @param context  上下文
     * @param rootList 树节点根列表（所有数据）
     */
    public TreeNodeAdapter(Context context, @NonNull List<BeHierarchyCatalog.DataBean.SectionsBean> rootList) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.rootTreeNodeList = rootList;
        init();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TreeNodeDelegate<T> holder = treeNodeDelegateList.get(viewType);
        View itemView = layoutInflater.inflate(holder.getLayoutId(), parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        TreeNodeDelegate<T> delegate = treeNodeDelegateList.get(viewType);
        delegate.convert(holder, showTreeNodeList.get(position));
    }

    @Override
    public int getItemCount() {
        return showTreeNodeList.size();
    }

    @Override
    public int getItemViewType(int position) {
        BeHierarchyCatalog.DataBean.SectionsBean treeNode = showTreeNodeList.get(position);
        for (int i = 0; i < treeNodeDelegateList.size(); i++) {
            TreeNodeDelegate<T> type = treeNodeDelegateList.get(i);
            if (type.isItemType(treeNode)) {
                return i;
            }
        }
        throw new IllegalArgumentException("No TreeNodeDelegate added that matches position=" + position + " in data source");
    }

    /**
     * 添加视图样式
     *
     * @param delegate 样式
     */
    public void addItemViewDelegate(TreeNodeDelegate<T> delegate) {
        delegate.adapter = this;
        treeNodeDelegateList.add(delegate);
    }

    /**
     * 移除视图样式
     *
     * @param delegate 样式
     */
    public void removeItemViewDelegate(TreeNodeDelegate<T> delegate) {
        treeNodeDelegateList.remove(delegate);
    }

    /**
     * 刷新
     */
    public void refreshTreeNode() {
        init();
        notifyDataSetChanged();
    }

    /**
     * 初始化展开的数据
     */
    private void init() {
        showTreeNodeList.clear();
        for (BeHierarchyCatalog.DataBean.SectionsBean tTreeNode : rootTreeNodeList) {
            showTreeNodeList.add(tTreeNode);
            if (tTreeNode.isExpand()) {
                showTreeNodeList.addAll(TreeNodeHelper.getExpendedChildren(tTreeNode));
            }
        }
    }

    /**
     * 展开树节点
     *
     * @param treeNode 树节点
     */
    public boolean expandTreeNode(BeHierarchyCatalog.DataBean.SectionsBean treeNode) {
        if (treeNode == null) return true;
        treeNode.setExpand(! treeNode.isExpand());
        int index = showTreeNodeList.indexOf(treeNode);
        List<BeHierarchyCatalog.DataBean.SectionsBean> children = TreeNodeHelper.getExpendedChildren(treeNode);
        if (index < 0 || index > showTreeNodeList.size() - 1 || children == null || children.size() == 0)
            return true;
        showTreeNodeList.addAll(index + 1, children);
        notifyItemRangeInserted(index + 1, children.size());
        notifyTreeNode(treeNode);
        return true;
    }

    /**
     * 收缩树节点
     *
     * @param treeNode 树节点
     */
    public boolean collapseTreeNode(BeHierarchyCatalog.DataBean.SectionsBean treeNode) {

        if (treeNode == null) return false;
        treeNode.setExpand(! treeNode.isExpand());
        int index = showTreeNodeList.indexOf(treeNode);
        List<BeHierarchyCatalog.DataBean.SectionsBean> children = TreeNodeHelper.getExpendedChildren(treeNode);
        if (index < 0 || index > showTreeNodeList.size() - 1 || children == null || children.size() == 0)
            return false;
        showTreeNodeList.removeAll(children);
        notifyItemRangeRemoved(index + 1, children.size());
        notifyTreeNode(treeNode);
        return false;
    }

    /**
     * 伸缩书记诶单
     *
     * @param treeNode 树节点
     */
    public boolean expandOrCollapseTreeNode(BeHierarchyCatalog.DataBean.SectionsBean treeNode) {
        boolean expan;// true 打开 false 关闭
        if (treeNode.isExpand()) {
            expan = collapseTreeNode(treeNode);
        } else {
            expan = expandTreeNode(treeNode);
        }
        return expan;
    }

    /**
     * 刷新树节点
     *
     * @param treeNode 树节点
     */
    public void notifyTreeNode(BeHierarchyCatalog.DataBean.SectionsBean treeNode) {
        int index = showTreeNodeList.indexOf(treeNode);
        if (index < 0 || index > showTreeNodeList.size() - 1) return;
        notifyItemChanged(showTreeNodeList.indexOf(treeNode));
    }

    /**
     * 展开所有层级的树节点
     */
    public void expandAllTreeNode() {
        TreeNodeHelper.expandAll(rootTreeNodeList);
        refreshTreeNode();
    }

    /**
     * 收缩所有层级的树节点
     */
    public void collapseAllTreeNode() {
        TreeNodeHelper.collapseAll(rootTreeNodeList);
        refreshTreeNode();
    }

    /**
     * 展开层级内的树节点
     *
     * @param level 层级
     */
    public void expandLevelTreeNode(int level) {
        TreeNodeHelper.expandLevel(rootTreeNodeList, level);
        refreshTreeNode();
    }

    /**
     * 设置可选树节点最大数量
     *
     * @param maxSelectCount 数量
     */
    public void setMaxSelectCount(int maxSelectCount) {
        this.maxSelectCount = maxSelectCount;
    }

    /**
     * 获取选中树节点集合
     *
     * @return 选中树节点集合
     */
    public List<BeHierarchyCatalog.DataBean.SectionsBean> getSelectTreeNodeList() {
        return selectTreeNodeList;
    }

    /**
     * 改变选中状态，并刷新
     * 当限制最多选中数量，超出的部分会把先加入的树节点移除
     *
     * @param treeNode 树节点
     * @param select   选中状态
     */
    public void selectTreeNode(BeHierarchyCatalog.DataBean.SectionsBean treeNode, boolean select) {
        treeNode.setSelect(select);
        if (select) {
            if (! selectTreeNodeList.contains(treeNode)) {// 添加并刷新
                selectTreeNodeList.add(treeNode);
                notifyTreeNode(treeNode);
            }
            if (maxSelectCount != 0) {// 多选且不限制数量
                if (selectTreeNodeList.size() > maxSelectCount) {// 删除首个已选并刷新
                    BeHierarchyCatalog.DataBean.SectionsBean first = selectTreeNodeList.get(0);
                    first.setSelect(false);
                    selectTreeNodeList.remove(first);
                    notifyTreeNode(first);
                }
            }
        } else {
            if (selectTreeNodeList.contains(treeNode)) {// 移除并刷新
                selectTreeNodeList.remove(treeNode);
                notifyTreeNode(treeNode);
            }
        }
    }

    /**
     * 改变树节点选中状态
     *
     * @param treeNode 树节点
     */
    public void changeSelectTreeNode(BeHierarchyCatalog.DataBean.SectionsBean treeNode) {
        selectTreeNode(treeNode, ! treeNode.isSelect());
    }
}
