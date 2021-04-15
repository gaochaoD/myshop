package com.nicholas.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nicholas.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * @Description: 商品mapper
 * @Author: denggc3
 * @CreateDate: 2021/4/12$ 16:12$
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/4/12$ 16:12$
 * @UpdateRemark: 更新内容
 * @Version: 1.0
 */

@Mapper
public interface IProductMapper extends BaseMapper<Product> {

    List<Product> getAll();


}
