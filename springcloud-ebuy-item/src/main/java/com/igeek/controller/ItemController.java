package com.igeek.controller;

import com.igeek.pojo.TbItem;
import com.igeek.service.ItemService;
import com.igeek.util.datagrid.DataGridNode;
import com.igeek.util.tree.EasyUITreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;



    @RequestMapping("/list")
    public DataGridNode<TbItem> itemList(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "30") Integer rows){
        return itemService.selectItemsByPage(page,rows);
    }

    @RequestMapping("/cat/list")
    public List<EasyUITreeNode> itemCatList(@RequestParam(defaultValue = "0") Long parentId){
        return itemService.selectItemCats(parentId);
    }


}
