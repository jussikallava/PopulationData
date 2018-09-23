package fi.kallava.population.service;

import fi.kallava.population.Neo4jSessionFactory;
import org.neo4j.ogm.session.Session;

import java.util.HashMap;
import java.util.Map;

abstract class GenericService<T> implements Service<T> {

    private static final int DEPTH_LIST = 0;
    private static final int DEPTH_ENTITY = 1;
    protected Session session = Neo4jSessionFactory.getInstance().getDatabaseSession();

    @Override
    public Iterable<T> findAll() {
        return session.loadAll(getEntityType(), DEPTH_LIST);
    }

    @Override
    public T find(Long id) {
        return session.load(getEntityType(), id, DEPTH_ENTITY);
    }

    @Override
    public void delete(Long id) {
        session.delete(session.load(getEntityType(), id));
    }

    @Override
    public T createOrUpdate(T entity) {
        session.save(entity, DEPTH_ENTITY);
        return entity;
        //return find(entity.id);
    }

    public T getRandomEntity() {
        String query = "MATCH (a:"+getEntityType().getSimpleName()+")\n" +
                "RETURN a, rand() as r\n" +
                "ORDER BY r\n" +
                "LIMIT 1";
        Map<String, Object> params = new HashMap<>();
        params.put("entity", getEntityType().toString());
        try {
            return session.queryForObject(getEntityType(), query, params);
        } catch (Exception e) {
            throw e;
        }
    }

    abstract Class<T> getEntityType();


}
