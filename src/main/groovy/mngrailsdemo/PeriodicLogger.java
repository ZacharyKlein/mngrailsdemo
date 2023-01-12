package mngrailsdemo;

import io.micronaut.scheduling.annotation.Scheduled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import java.text.SimpleDateFormat;
import java.util.Date;

@Singleton
public class PeriodicLogger {
    private static final Logger LOG = LoggerFactory.getLogger(PeriodicLogger.class);

    @Scheduled(fixedDelay = "30s")
    void executeEveryThirty() {
        LOG.info("Simple Job every 30 seconds: {}", new SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(new Date()));
    }

    @Scheduled(fixedDelay = "15s", initialDelay = "5s")
    void executeEveryFifteen() {
        LOG.info("Simple Job every 15 seconds: {}", new SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(new Date()));
    }
}
