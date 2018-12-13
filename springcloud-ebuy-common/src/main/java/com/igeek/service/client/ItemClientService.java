package com.igeek.service.client;

import com.igeek.pojo.TbItem;
import com.igeek.util.datagrid.DataGridNode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("EBUY-ITEM")
public interface ItemClientService {
    @RequestMapping("/list")
    public DataGridNode<TbItem> itemList(Integer page,Integer rows);
}
