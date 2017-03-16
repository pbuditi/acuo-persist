package com.acuo.persist.entity;

import com.acuo.common.model.margin.Types;
import com.acuo.persist.neo4j.converters.LocalDateConverter;
import com.acuo.persist.neo4j.converters.LocalDateTimeConverter;
import lombok.*;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.Convert;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@NodeEntity
@Data
@EqualsAndHashCode(callSuper = false, exclude = {"marginCalls", "marginStatement"})
@ToString(exclude = {"marginCalls", "marginStatement"})
public class MarginCall<T extends MarginCall> extends StatementItem<T> {

    @Property(name = "id")
    private String marginCallId;

    @Convert(LocalDateConverter.class)
    private LocalDate callDate;

    private Types.MarginType marginType;

    private String direction;

    @Convert(LocalDateConverter.class)
    private LocalDate valuationDate;

    private String currency;

    private Double excessAmount;

    private Double balanceAmount;

    private Double deliverAmount;

    private Double returnAmount;

    private Double pendingCollateral;

    private Double exposure;

    private String IMRole;

    private Integer parentRank;

    @Convert(LocalDateTimeConverter.class)
    private LocalDateTime notificationTime;

    private Double roundedReturnAmount;

    private Double roundedDeliverAmount;

    private Integer belowMTA;

    @Relationship(type = "FIRST")
    private Step firstStep;

    @Relationship(type = "MATCHED_TO_EXPECTED", direction = Relationship.OUTGOING)
    private MarginCall matchedToExpected;

    @Relationship(type = "CHILD_OF", direction = Relationship.INCOMING)
    private Set<ChildOf> children;

    @Relationship(type = "PART_OF", direction = Relationship.OUTGOING)
    private MarginStatement marginStatement;

    private Double marginAmount;

    private String status;

    public MarginCall(String marginCallId, LocalDate callDate, Types.MarginType marginType, String direction, LocalDate valuationDate, String currency,
                      Double excessAmount, Double balanceAmount, Double deliverAmount, Double returnAmount, Double pendingCollateral, Double exposure, Integer parentRank,
                      LocalDateTime notificationTime, Double marginAmount, String status) {
        this.marginCallId = marginCallId;
        this.callDate = callDate;
        this.marginType = marginType;
        this.direction = direction;
        this.valuationDate = valuationDate;
        this.currency = currency;
        this.excessAmount = excessAmount;
        this.balanceAmount = balanceAmount;
        this.deliverAmount = deliverAmount;
        this.returnAmount = returnAmount;
        this.pendingCollateral = pendingCollateral;
        this.exposure = exposure;
        this.parentRank = parentRank;
        this.notificationTime = notificationTime;
        this.marginAmount = marginAmount;
        this.status = status;
    }

    public MarginCall() {
    }
}
