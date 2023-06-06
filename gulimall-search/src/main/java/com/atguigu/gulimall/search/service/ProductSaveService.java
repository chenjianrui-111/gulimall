package com.atguigu.gulimall.search.service;



import com.atguigu.gulimall.common.es.SkuEsModel;

import java.io.IOException;
import java.util.List;

/**
 * @author 15983
 **/
public interface ProductSaveService {

    boolean productStatusUp(List<SkuEsModel> skuEsModels) throws IOException;
}
