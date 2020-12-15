package org.example.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

public abstract class Dao<T> {

    @PersistenceContext
    private EntityManager entityManager;

    public Collection<T> getAll() {
        return entityManager.createNamedQuery(typeSimple() + ".findAll", T()).getResultList();
    }

    public T add(T a) {
        entityManager.persist(a);
        return a;
    }

    public boolean remove(String id) {
        T t = entityManager.find(T(), id);
        if (t == null) return false;

        entityManager.remove(t);
        return true;
    }

    private String typeSimple() { return T().getSimpleName(); }

    @SuppressWarnings("unchecked")
    private Class<T> T() {
        return (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

}
