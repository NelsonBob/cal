package fr.esgi.tp1503;

final class Query {

    private final String select;
    private final String from;
    private final String where;

    public Query(String select, String from, String where) {
        this.select = select;
        this.from = from;
        this.where = where;
    }

    public String getSelect() {
        return select;
    }

    public String getFrom() {
        return from;
    }

    public String getWhere() {
        return where;
    }

    @Override
    public String toString() {
        return "Query{" +
                "select='" + select + '\'' +
                ", from='" + from + '\'' +
                ", where='" + where + '\'' +
                '}';
    }
}
