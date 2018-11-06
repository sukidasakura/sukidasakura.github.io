@RequestBody
用于接收json串，如ajax请求的data参数，可直接接收转换到Pojo

比如在postman中要传递如下Pojo参数：
{
    "jobGroup":1,
    "jobCron":"1 1 1 * * ? *",
    "jobDesc":"test",
    "glueType":"GLUE_SHELL"
}


@ModelAttribute
用于直接接收url?后面的参数如url?id=123&name=456，可直接接收转换到Pojo