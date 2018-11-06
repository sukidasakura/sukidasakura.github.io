package design.patterns.strategy;

import design.patterns.strategy.fly.FlyBehavior;
import design.patterns.strategy.quack.QuackBehavior;

/**
 * @Description: 鸭子
 * @author: mashencai@supcon.com
 * @date: 2018年07月13日 16:05
 */
public abstract class Duck {

    // 为行为接口类型声明两个引用变量，所有鸭子子类都继承它们。
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck(){
    }

    public abstract void display();

    public void performFly(){
        flyBehavior.fly(); // 委托给行为类
    }


    public void performQuack(){
        quackBehavior.quack();
    }

}
