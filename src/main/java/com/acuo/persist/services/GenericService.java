package com.acuo.persist.services;

import com.acuo.common.util.ArgChecker;
import com.acuo.persist.entity.Entity;
import com.google.common.collect.ImmutableMap;
import com.google.inject.persist.Transactional;
import org.apache.commons.beanutils.BeanUtils;
import org.neo4j.ogm.session.Session;

import javax.inject.Inject;
import java.util.Collections;

public abstract class GenericService<T> implements Service<T> {

    private static final int DEPTH_LIST = 0;
    private static final int DEPTH_ENTITY = 1;
    private static final int DEPTH_CHILD = 1;

    @Inject
    protected Session session;

    @Transactional
    @Override
    public Iterable<T> findAll() {
        return session.loadAll(getEntityType(), DEPTH_LIST);
    }

    @Transactional
    @Override
    public T find(Long id) {
        return session.load(getEntityType(), id, DEPTH_ENTITY);
    }

    @Transactional
    @Override
    public T find(Long id, int depth) {
        return session.load(getEntityType(), id, depth);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        session.delete(session.load(getEntityType(), id));
    }

    @Transactional
    @Override
    public T createOrUpdate(T entity) {
        ArgChecker.notNull(entity, "entity");
        session.save(entity, -1);
        return find(((Entity) entity).getId());
    }

    public abstract Class<T> getEntityType();

    @Transactional
    @Override
    public T findById(String id) {
        String query = "MATCH (i:" + getEntityType().getSimpleName() + " {id: {id} }) return i";
        T entity = session.queryForObject(getEntityType(), query, ImmutableMap.of("id",id));
        if(entity != null)
            return find(((Entity) entity).getId(), DEPTH_ENTITY);
        else
            return null;
    }

    @Transactional
    @Override
    public T findById(String id, int depth) {
        String query = "MATCH (i:" + getEntityType().getSimpleName() + " {id: {id} }) return i";
        T entity = session.queryForObject(getEntityType(), query, ImmutableMap.of("id",id));
        if(entity != null)
            return find(((Entity) entity).getId(), depth);
        else
            return null;
    }
}