package com.example.morelistview.treenode;

import com.example.morelistview.BeHierarchyCatalog;

import java.util.ArrayList;
import java.util.List;

public class TreeNodeHelper {
    public static <T> List<BeHierarchyCatalog.DataBean.SectionsBean> getExpendedChildren(BeHierarchyCatalog.DataBean.SectionsBean parent) {
        List<BeHierarchyCatalog.DataBean.SectionsBean> childrenList = new ArrayList<>();
        List<BeHierarchyCatalog.DataBean.SectionsBean> children = parent.getChildrenList();
        if (children != null) {
            for (BeHierarchyCatalog.DataBean.SectionsBean child : children) {
                childrenList.add(child);
                if (child.isExpand()) {
                    childrenList.addAll(getExpendedChildren(child));
                }
            }
        }
        return childrenList;
    }

    public static <T> void expandAll(List<BeHierarchyCatalog.DataBean.SectionsBean> parentList) {
        if (parentList == null) return;
        for (BeHierarchyCatalog.DataBean.SectionsBean parent : parentList) {
            parent.setExpand(true);
            expandAll(parent.getChildrenList());
        }
    }

    public static <T> void collapseAll(List<BeHierarchyCatalog.DataBean.SectionsBean> parentList) {
        if (parentList == null) return;
        for (BeHierarchyCatalog.DataBean.SectionsBean parent : parentList) {
            parent.setExpand(false);
            collapseAll(parent.getChildrenList());
        }
    }

    public static <T> void expandLevel(List<BeHierarchyCatalog.DataBean.SectionsBean> parentList, int level) {
        if (parentList == null) return;
        for (BeHierarchyCatalog.DataBean.SectionsBean parent : parentList) {
            if (parent.getLevel() < level) {
                parent.setExpand(true);
                expandLevel(parent.getChildrenList(), level);
            }
        }
    }
}
