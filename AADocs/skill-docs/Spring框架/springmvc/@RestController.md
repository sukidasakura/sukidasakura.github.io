RestController注解，相当于@Controller + @ResponseBody两个注解的集合，返回json数据不需要再方法前面加@ResponseBody注解了。
但使用@RestController这个注解，就不能返回jsp,html页面，视图解析器无法解析jsp,html页面。