package com.acuo.persist.entity;

import com.acuo.common.model.margin.Types;
import com.acuo.persist.neo4j.converters.LocalDateConverter;
import com.acuo.persist.neo4j.converters.LocalDateTimeConverter;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.typeconversion.Convert;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NodeEntity
@Data
@EqualsAndHashCode(callSuper = false)
public class StatementItem extends Entity {

    @Convert(LocalDateConverter.class)
    protected LocalDate callDate;
    protected Types.MarginType marginType;
    protected String direction;
    protected String status;
    protected String currency;
    @Convert(LocalDateConverter.class)
    protected LocalDate valuationDate;
    protected Integer parentRank;
    protected Double marginAmount;
    @Convert(LocalDateTimeConverter.class)
    protected LocalDateTime notificationTime;
}