package fr.esgi.tp1502;

final class QueryBuilder {

    private String select;
    private String from;
    private String where;

    static QueryBuilder create() {
        return new QueryBuilder();
    }

    QueryBuilder select(String select) {
        this.select = select;
        return this;
    }

    QueryBuilder from(String from) {
        this.from = from;
        return this;
    }

    QueryBuilder where(String where) {
        this.where = where;
        return this;
    }

    Query build() {
        return new Query(select, from, where);
    }
}
