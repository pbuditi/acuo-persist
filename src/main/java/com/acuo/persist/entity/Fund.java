package com.acuo.persist.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

@NodeEntity
@Data
@EqualsAndHashCode(callSuper = false)
public class Fund extends Entity<Fund> {

    @Property(name = "id")
    @Index(primary = true)
    private String fundId;

    private String name;

    @Relationship(type = "IS_COMPOSED_OF")
    private Set<Portfolio> portfolios;

}
