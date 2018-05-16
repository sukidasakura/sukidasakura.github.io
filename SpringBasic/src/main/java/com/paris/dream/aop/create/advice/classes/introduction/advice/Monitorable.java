package com.paris.dream.aop.create.advice.classes.introduction.advice;

/**
 * 回到first.example中性能监视的例子
 * 由于性能监视会影响业务系统的功能，所以性能监视是否启用应该是可控的
 * 利用引介增强来实现这一功能：维护人员可以手动打开或关闭性能监视的功能
 *
 * Created by Sydney on 2018/5/16.
 */
public interface Monitorable {
    void setMonitorActive(boolean active);
}
