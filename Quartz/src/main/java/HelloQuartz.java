import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @Description:
 * @author: mashencai@supcon.com
 * @date: 2018年07月27日 11:08
 */
public class HelloQuartz implements Job{

    private static final Logger logger = LoggerFactory.getLogger(HelloQuartz.class);

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDetail detail = jobExecutionContext.getJobDetail();
        String name = detail.getJobDataMap().getString("name");
//        logger.info("say hello to " + name + " at " + new Date());
        System.out.println("say hello to " + name + " at " + new Date());
    }
}
