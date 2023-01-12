package mngrailsdemo;

import io.micronaut.context.annotation.EachBean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.transaction.jdbc.DataSourceTransactionManager;
import io.micronaut.transaction.support.ResourceTransactionManager;

import javax.sql.DataSource;
import java.sql.Connection;

@Factory
class TransactionManagerFactory {

    @EachBean(DataSource.class)
    ResourceTransactionManager<DataSource, Connection> transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
