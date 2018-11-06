package design.patterns.strategy.quack;

/**
 * @Description:
 * @author: mashencai@supcon.com
 * @date: 2018年07月13日 16:10
 */
public class Quack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("Quack");
    }
}
