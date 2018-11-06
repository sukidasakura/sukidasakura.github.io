package design.patterns.strategy;

/**
 * @Description:
 * @author: mashencai@supcon.com
 * @date: 2018年07月13日 16:39
 */
public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        /**
         * 这会调用MallardDuck继承来的performQuack方法，进而委托给该对象的
         * QuackBehavior对象处理（也就是说，调用继承来的quackBehavior引用对象的quack()）
         */
        mallard.performQuack();
        mallard.performFly();
    }
}
