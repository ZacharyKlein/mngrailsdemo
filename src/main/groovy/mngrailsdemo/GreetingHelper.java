package mngrailsdemo;

import io.micronaut.context.annotation.Value;
import io.micronaut.retry.annotation.Retryable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import javax.persistence.criteria.Expression;

@Singleton
public class GreetingHelper {

    private static final Logger log = LoggerFactory.getLogger(GreetingHelper.class);

    private final String prefix;

    private int counter = 0;

    public GreetingHelper(@Value("${greeting.prefix}") String prefix) {
        this.prefix = prefix;
    }

    @Retryable()
    public String createGreeting(String name) {
        // every 3rd request should result
        // in an exception.  this is helpful
        // to demonstrate @Retryable.
        if(++counter % 3 == 0) {
            log.debug("Simulating Error In Greeting Helper");
            throw new IllegalStateException();
        }

        return prefix + name;
    }
}
