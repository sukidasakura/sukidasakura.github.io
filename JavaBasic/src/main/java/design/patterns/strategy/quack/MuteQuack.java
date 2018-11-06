package design.patterns.strategy.quack;

/**
 * @Description:
 * @author: mashencai@supcon.com
 * @date: 2018年07月13日 16:11
 */
public class MuteQuack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("<< Silence >>");
    }
}
