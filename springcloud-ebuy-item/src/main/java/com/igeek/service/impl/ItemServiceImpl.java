package com.igeek.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.igeek.mapper.TbItemCatMapper;
import com.igeek.mapper.TbItemMapper;
import com.igeek.pojo.TbItem;
import com.igeek.pojo.TbItemCat;
import com.igeek.pojo.TbItemCatExample;
import com.igeek.pojo.TbItemExample;
import com.igeek.service.ItemService;
import com.igeek.util.datagrid.DataGridNode;
import com.igeek.util.tree.EasyUITreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper tbItemMapper;

    @Autowired
    private TbItemCatMapper itemCatMapper;

    @Override
    public List<TbItem> selectAllItems() {
        TbItemExample exemple = new TbItemExample();

        return tbItemMapper.selectByExample(exemple);
    }

    @Override
    public DataGridNode<TbItem> selectItemsByPage(Integer page, Integer rows) {

        //设置分页参数
        PageHelper.startPage(page,rows);

        TbItemExample exemple = new TbItemExample();

        List<TbItem> tbItems = tbItemMapper.selectByExample(exemple);

        //获取pageInfo对象(包含当前分页对象)
        PageInfo<TbItem> pageInfo = new PageInfo<>(tbItems);

        DataGridNode<TbItem> dataGridNode = new DataGridNode<>(pageInfo.getTotal(),tbItems);

        return dataGridNode;
    }

    @Override
    public List<EasyUITreeNode> selectItemCats(Long parentId) {
        List<EasyUITreeNode> nodes = new ArrayList<>();

        //设置查询条件
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);

        List<TbItemCat> tbItemCats = itemCatMapper.selectByExample(example);
        for (TbItemCat itemCat : tbItemCats) {
            EasyUITreeNode node = new EasyUITreeNode(itemCat.getId(),itemCat.getName(),itemCat.getIsParent()?"closed":"open");
            nodes.add(node);
        }
        return nodes;
    }
}
