package com.igeek.api;

import com.igeek.pojo.TbItem;
import com.igeek.service.client.ItemClientService;
import com.igeek.util.datagrid.DataGridNode;
import com.igeek.util.tree.EasyUITreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
    //@Autowired
    //private ItemClientService service;

    private static final String PROVIDER_URL_PREFIX = "http://EBUY-ITEM";
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("/list")
    public DataGridNode<TbItem> itemList(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "30") Integer rows){
        //return service.itemList(page,rows);
        /*BigDecimal price_01 = new BigDecimal("12.50");
        BigDecimal price_02 = new BigDecimal("11.30");
        BigDecimal subtract = price_01.subtract(price_02);
        System.out.println(subtract);*/
        return restTemplate.getForObject(PROVIDER_URL_PREFIX+"/list?page="+page+"&rows="+rows,DataGridNode.class);
    }

    @RequestMapping("/cat/list")
    public List<EasyUITreeNode> catList(@RequestParam(name = "id",defaultValue = "0") Long parentId){
        return restTemplate.getForObject(PROVIDER_URL_PREFIX+"/cat/list?parentId="+parentId,List.class);
    }

}
