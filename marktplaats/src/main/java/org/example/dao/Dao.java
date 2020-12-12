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


    public T get(String id) {
        return entityManager.find(T(), id);
    }

    public void save(T e){
        entityManager.getTransaction().begin();
        entityManager.persist(e);
        entityManager.getTransaction().commit();
    }

    public T update(T e) {
        entityManager.getTransaction().begin();
        T merged = entityManager.merge(e);
        entityManager.getTransaction().commit();
        return merged;
    }

    public void remove(T e) {
        entityManager.getTransaction().begin();
        entityManager.remove(e);
        entityManager.getTransaction().commit();
    }

    public List<T> findAll() {
        return entityManager.createQuery("SELECT e FROM " + typeSimple() + " e ", T()).getResultList();
    }

    private String typeSimple() { return T().getSimpleName(); }

    @SuppressWarnings("unchecked")
    private Class<T> T() {
        return (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

}
