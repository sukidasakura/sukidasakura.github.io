package com.paris.dream.aspectjaop.delareparents;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * 假如我们希望NativeWaiter能够同时充当售货员的角色，
 * 即通过切面技术为NativeWaiter新增Seller接口的实现。
 * 下面用@AspectJ的引介增强来实现这一功能。
 * 通过@DeclareParents为NativeWaiter添加了一个需要实现的Seller接口，并指定其默认实现类为SmartSeller，
 * 然后通过切面技术将SmaterSeller融合到NativeWaiter中。
 * Created by Sydney on 2018/5/17.
 */
@Aspect
public class EnableSellerAspect {
    // value:为NativeWaiter添加接口实现
    // defaultImpl:默认的接口实现类
    @DeclareParents(value = "com.paris.dream.aspectjaop.delareparents.NativeWaiter",
            defaultImpl = SmartSeller.class)
    public Seller seller; // 要实现的目标接口
}
