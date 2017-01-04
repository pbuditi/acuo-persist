package com.acuo.persist.services;

import com.acuo.persist.entity.CallStatus;
import com.acuo.persist.spring.Call;
import com.acuo.persist.entity.MarginStatement;

public interface MarginStatementService extends Service<MarginStatement> {

    Iterable<MarginStatement> allStatementsFor(String clientId, CallStatus... statuses);

    MarginStatement statementFor(String marginStatementId, CallStatus... statuses);

    Iterable<Call> allCallsFor(String clientId, String dateTime);

}