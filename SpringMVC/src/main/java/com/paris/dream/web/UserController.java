package com.paris.dream.web;

import com.paris.dream.UserService;
import com.paris.dream.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;

/**
 * Created by Mashencai on 2018/5/22.
 */
// 用Controller进行标注，使其成为一个可处理http请求的控制器
@Controller
@RequestMapping("/user") // 处理来自/user URI的请求，路径是相对于Web容器部署根路径的。可以只写@RequestMapping，表示路径相对于根路径。
public class UserController {

    @Autowired
    private UserService userService; // 注入业务层的Bean

    @RequestMapping(method = RequestMethod.POST) // 处理/user的请求，请求的方法必须为POST
    // Spring MVC自动将表单中的数据按参数名和User属性名匹配的方式进行绑定，将参数值填充到User的相应属性中。
    // 调用UserService进行业务处理，进而返回ModelAndView
    public ModelAndView createUser(User user) {
        userService.createUser(user);
        ModelAndView modelAndView = new ModelAndView();
        // 视图解析器将user/createSuccess解析为WEB-INF/views/user/createSuccess.jsp的视图对象，createSuccess.jsp可以访问到模型中的数据。
        modelAndView.setViewName("user/createSuccess");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    // 这里不能忘了"/"符号！！
    @RequestMapping(value = "/register", method = RequestMethod.GET, params = "!myParam")
    public String register() {
        // 返回一个String类型的逻辑视图名，将由视图解析器解析为一个具体的视图对象。
        // 在本例中，被映射为WEB-INF/views/user/register.jsp
        return "user/register";
    }
}
