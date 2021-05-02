package com.crew92.doordie.content.domain.configuration.db;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import static com.crew92.doordie.content.domain.configuration.db.DbConstants.MASTER;
import static com.crew92.doordie.content.domain.configuration.db.DbConstants.SLAVE;

public class RoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return TransactionSynchronizationManager.isCurrentTransactionReadOnly() ? SLAVE : MASTER;
    }

}
