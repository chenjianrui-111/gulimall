package com.atguigu.gulimall.common.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

public class ListValueConstraintValidator implements ConstraintValidator<ListValue, Integer> {

    private Set<Integer> set = new HashSet<>();

    // 初始化方法
    @Override
    public void initialize(ListValue constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        int[] values = constraintAnnotation.values();

        for (int value : values) {
            set.add(value);
        }
    }

    /**
     * 判断是否校验成功
     * @param value   这个就是浏览器提交过来需要校验的值
     * @param context
     * @return
     */
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return set.contains(value);
    }
}
