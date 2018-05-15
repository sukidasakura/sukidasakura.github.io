@Resource与@Autowired注解区别
https://blog.csdn.net/wangzuojia001/article/details/54312074

@Component("userDao")
public class UserDao{
}

等价于以下XML配置：
<bean id="userDao" class="com.paris..."/>

Spring提供了3个功能基本和@Component 等效的注解：
@Repository：用于对DAO实现类进行标注
@Service：用于对Service实现类进行标注
@Controller：用于对Contorller实现类进行标注