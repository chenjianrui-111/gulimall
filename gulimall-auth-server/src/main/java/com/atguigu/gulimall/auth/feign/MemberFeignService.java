package com.atguigu.gulimall.auth.feign;


import com.atguigu.gulimall.auth.vo.SocialUser;
import com.atguigu.gulimall.auth.vo.UserLoginVo;
import com.atguigu.gulimall.auth.vo.UserRegisterVo;
import com.atguigu.gulimall.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 15983
 * @Description:
 * @Created: with IntelliJ IDEA.
 **/

@FeignClient("gulimall-member")
public interface MemberFeignService {

    @PostMapping(value = "/member/member/register")
    R register(@RequestBody UserRegisterVo vo);


    @PostMapping(value = "/member/member/login")
    R login(@RequestBody UserLoginVo vo);

    @PostMapping(value = "/member/member/oauth2/login")
    R oauthLogin(@RequestBody SocialUser socialUser) throws Exception;

    @PostMapping(value = "/member/member/weixin/login")
    R weixinLogin(@RequestParam("accessTokenInfo") String accessTokenInfo);
}
