package design.patterns.strategy;

import design.patterns.strategy.fly.FlyWithWings;
import design.patterns.strategy.quack.Quack;

/**
 * @Description: 绿头鸭
 * @author: mashencai@supcon.com
 * @date: 2018年07月13日 16:25
 */
public class MallardDuck extends Duck {

    public MallardDuck(){
        // 绿头鸭使用Quack类处理呱呱叫，所以当performQuack()被调用时，叫的职责被委托给Quack对象。
        // 而我们得到了真正的呱呱叫。
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("I'm a real Mallard Duck");
    }
}
