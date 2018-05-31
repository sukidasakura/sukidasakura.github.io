@Requestmapping像一个迎宾，将http请求正确地迎到主人面前（负责处理该请求的方法）；  
主人起身相迎，进而与http请求交杯换盏，把酒言欢；  
最后在欢声笑语中送走http请求（返回响应）。 


一般情况下，处理方法的返回值为ModelAndView或String。  
前者包含模型和逻辑视图名，而后者仅仅代表一个逻辑视图名。  

@RestMapping
@ResponseBody
两行相当于一行：
@RestController