package com.acuo.persist.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity
@Data
@EqualsAndHashCode(callSuper = false)
public class InterestPayment extends StatementItem {
    @Property(name="id")
    private String interestPaymentId;
}
