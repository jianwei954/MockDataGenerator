import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Random;

/**
 * @author: create by djw
 * @version: v1.0
 * @description: PACKAGE_NAME
 * @date:2019/5/27
 */
@Slf4j
public class CharTest
{
    @Test
    public void charTest()
    {
        char char1 = '?';
        char char2 = '?';
        char char3 = 'a';
        log.info((char1==char2)+"");
        log.info((char1==char3)+"");
        Random random = new Random();
        log.info(random.nextFloat()+"");
        log.info(random.nextFloat()+"");
        log.info(random.nextFloat()+"");
        log.info(random.nextFloat()+"");
        log.info(random.nextFloat()+"");
        log.info(random.nextFloat()+"");
        log.info(random.nextBoolean()+"");
        log.info(random.nextBoolean()+"");
        log.info(random.nextBoolean()+"");
        log.info(random.nextBoolean()+"");
        log.info(random.nextBoolean()+"");
        log.info(random.nextInt(360)+"");
        log.info(random.nextInt(360)+"");
        log.info(random.nextInt(360)+"");
        log.info(random.nextInt(360)+"");
        log.info(random.nextInt(360)+"");
    }
}
