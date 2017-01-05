package com.acuo.persist.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity
@Data
@EqualsAndHashCode(callSuper = false)
public class FCM extends Entity<FCM> {

    @Index(unique = true, primary = true)
    @Property(name = "id")
    private String fcmId;

    private String name;

    private String shortName;

    private String jurisdiction;

}
