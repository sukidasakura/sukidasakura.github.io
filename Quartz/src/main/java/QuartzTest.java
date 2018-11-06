import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @Description:
 * @author: mashencai@supcon.com
 * @date: 2018年07月27日 10:55
 */
public class QuartzTest {
    public static void main(String[] args) {
        try {
            // 创建scheduler
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            // 定义一个trigger
            Trigger trigger = newTrigger().withIdentity("trigger1", "group1")
                    .startNow() // 一旦加入scheduler，立即生效
                    .withSchedule(simpleSchedule() // 使用SimpleSchedule
                    .withIntervalInSeconds(5) // 每隔一秒执行一次
                    .repeatForever()) // 一旦执行，奔腾到老不停歇
                    .build();

            // 定义一个JobDetail
            JobDetail jobDetail = newJob(HelloQuartz.class) // 定义Job类为HelloQuartz类
                    .withIdentity("job1", "group1") // 定义name/group
                    .usingJobData("name", "quartz") // 定义属性
                    .build();

            // 加入这个调度
            scheduler.scheduleJob(jobDetail, trigger);

            // 启动之
            scheduler.start();

            Thread.sleep(10000);
            scheduler.shutdown(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
