package com.atguigu.gulimall.member.dao;

import com.atguigu.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author cjr
 * @email cjr@gmail.com
 * @date 2023-05-25 02:13:26
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
