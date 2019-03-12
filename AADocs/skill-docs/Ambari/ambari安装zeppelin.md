#### 安装zeppelin_test报错
    Traceback (most recent call last):
      File "/var/lib/ambari-agent/cache/stacks/HDP/2.0.6/hooks/before-ANY/scripts/hook.py", line 35, in <module>
        BeforeAnyHook().execute()
      File "/usr/lib/python2.6/site-packages/resource_management/libraries/script/script.py", line 329, in execute
        method(env)
      File "/var/lib/ambari-agent/cache/stacks/HDP/2.0.6/hooks/before-ANY/scripts/hook.py", line 26, in hook
        import params
      File "/var/lib/ambari-agent/cache/stacks/HDP/2.0.6/hooks/before-ANY/scripts/params.py", line 252, in <module>
        user_to_groups_dict[zeppelin_user] = [zeppelin_group, user_group]
      File "/usr/lib/python2.6/site-packages/resource_management/libraries/script/config_dictionary.py", line 73, in __getattr__
        raise Fail("Configuration parameter '" + self.name + "' was not found in configurations dictionary!")
    resource_management.core.exceptions.Fail: Configuration parameter 'zeppelin_user' was not found in configurations dictionary!
    Error: Error: Unable to run the custom hook script ['/usr/bin/python', '/var/lib/ambari-agent/cache/stacks/HDP/2.0.6/hooks/before-ANY/scripts/hook.py', 'ANY', '/var/lib/ambari-agent/data/command-5503.json', '/var/lib/ambari-agent/cache/stacks/HDP/2.0.6/hooks/before-ANY', '/var/lib/ambari-agent/data/structured-out-5503.json', 'INFO', '/var/lib/ambari-agent/tmp', 'PROTOCOL_TLSv1', '']

解决方法：
/var/lib/ambari-server/resources/stacks/HDP/2.0.6/hooks/before-ANY/scripts/params.py
注释掉其中所有关于zeppelin部分（这是原生带的安装zeppelin的配置）