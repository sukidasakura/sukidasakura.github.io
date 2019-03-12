原生：

http://10.10.77.138:8080/api/v1/clusters/hdpCluster/components?fields=host_components/HostRoles/display_name，host_components/HostRoles/host_name&ServiceComponentInfo/service_name=HDFS


调用data_control_web工程 根据hostName获取
http://10.10.77.142:8090/data_control_web/ambari/host/getHostsList
参数
pageNo:1
pageSize:20
extraFields:{"Hosts/host_name":"data143","Hosts/ip":"","Hosts/host_status":""}

获取xxl 安装到哪里了
http://10.10.77.142:8090/data_control_web/ambari/service/getSummaryOfService?serviceName=KAFKA


新增执行器页面 获取机器地址下拉列表
http://10.10.77.135:8090/data_control_web/ambari/host/getHostsList?pageNo=1&pageSize=100


http://10.10.77.135:8090/data_control_web/ambari/service/getSummaryOfService?serviceName=XXL_JOB