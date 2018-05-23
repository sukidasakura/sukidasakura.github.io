package com.paris.dream.web;

import com.paris.dream.UserService;
import com.paris.dream.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.concurrent.Callable;

/**
 * Created by Mashencai on 2018/5/22.
 */
// 用Controller进行标注，使其成为一个可处理http请求的控制器
@Controller
@RequestMapping("/user") // 处理来自/user URI的请求，路径是相对于Web容器部署根路径的。可以只写@RequestMapping，表示路径相对于根路径。
public class UserController {

    @Autowired
    private UserService userService; // 注入业务层的Bean

    // 必须定义无参构造函数！
    public UserController(){ }

    public UserController(UserService userService){
        this.userService = userService;
    }

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

    // 使用HttpMessageConverter<T>将请求信息转换并绑定到处理方法的入参中
    // 使用方式之一：使用@RequestBody/@ResponseBody对处理方法进行标注
    @RequestMapping(path = "/handle41")
    public String handle41(@RequestBody String requestBody){ // 将请求报文体转换为字符串绑定到requestBody入参中
        System.out.println(requestBody);
        return "success";
    }

    // 读取一张图片，并将图片数据输出到响应流中，客户端将显示这张图片
    @ResponseBody
    @RequestMapping(path = "/handle42/{imageId}")
    public byte[] handle42(@PathVariable("imageId") String imageId) throws IOException {
        System.out.println("load image of " + imageId);
        Resource res = new ClassPathResource("/image.jpg");
        byte[] fileData = FileCopyUtils.copyToByteArray(res.getInputStream());
        return fileData;
    }

    // 用HttpEntity<?>对handle41与42代码进行改造，完成相似功能
    // HttpEntity<?>不但可以访问请求和响应报文体的数据，还可以访问请求和响应报文头的数据
    @RequestMapping(path = "/handle43")
    public String handle43(HttpEntity<String> httpEntity){
        long contentLen = httpEntity.getHeaders().getContentLength();
        System.out.println(httpEntity.getBody());
        return "success";
    }// 使用StringHttpMessageConverter将请求报文体及报文头的信息绑定到httpEntity中，在方法中可以对相应信息进行访问

    @RequestMapping(path = "/handle44/{imageId}")
    public ResponseEntity<byte[]> handle44(@PathVariable("ImageId") String imageId) throws IOException {
        Resource res = new ClassPathResource("/image.jpg");
        byte[] fileData = FileCopyUtils.copyToByteArray(res.getInputStream());
        ResponseEntity<byte[]> responseEntity =
                new ResponseEntity<byte[]>(fileData, HttpStatus.OK);
        return responseEntity;
    } // 在方法中创建HttpEntity<byte[]>对象并返回，ByteArrayHttpMessageConverter负责将其输出到响应流中。


    // 模拟一个执行时间为10秒的服务器方法，如果客户端使用RestTemplate，则将以同步方式进行调用，
    // 即客户端代码需要等待服务器返回后才继续执行。
    @RequestMapping("/api")
    public Callable<User> api() {
        System.out.println("=====hello");
        return new Callable<User>() {
            @Override
            public User call() throws Exception {
                Thread.sleep(10L * 1000); // 暂停10秒
                User user = new User();
                user.setUserId("1L");
                user.setUserName("haha");
                return user;
            }
        };
    }

}
