package fr.esgi.tp1502;

public class Main {

    public static void main(String[] args) {
        QueryBuilder queryBuilder = new QueryBuilder().where("ID=1");

        var queryBuilder1 = queryBuilder
                .select("select ID")
                .from("T_USER");


        var queryBuilder2 = queryBuilder
                .select("select *")
                .from("T_USER")
                .where("ID=2");

        System.out.println(queryBuilder1.build());
        System.out.println(queryBuilder2.build());
    }
}
