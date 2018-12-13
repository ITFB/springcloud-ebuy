package com.igeek.service;

import com.igeek.pojo.TbItem;
import com.igeek.util.datagrid.DataGridNode;
import com.igeek.util.tree.EasyUITreeNode;

import java.util.List;

public interface ItemService {

    List<TbItem> selectAllItems();

    DataGridNode<TbItem> selectItemsByPage(Integer page, Integer rows);

    List<EasyUITreeNode> selectItemCats(Long parentId);
}
