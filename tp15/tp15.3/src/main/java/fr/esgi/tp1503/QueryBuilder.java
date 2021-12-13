package fr.esgi.tp1503;

final class QueryBuilder {

    private String select;
    private String from;
    private String where;

    static QueryBuilder create() {
        return new QueryBuilder();
    }

    QueryBuilder select(String selectValue) {
        QueryBuilder queryBuilder = new QueryBuilder();
        queryBuilder.select = selectValue;
        queryBuilder.from = from;
        queryBuilder.where = where;
        return queryBuilder;
    }

    QueryBuilder from(String fromValue) {
        QueryBuilder queryBuilder = new QueryBuilder();
        queryBuilder.select = select;
        queryBuilder.from = fromValue;
        queryBuilder.where = where;
        return queryBuilder;
    }

    QueryBuilder where(String whereValue) {
        QueryBuilder queryBuilder = new QueryBuilder();
        queryBuilder.select = select;
        queryBuilder.from = from;
        queryBuilder.where = whereValue;
        return queryBuilder;
    }

    Query build() {
        return new Query(select, from, where);
    }
}
