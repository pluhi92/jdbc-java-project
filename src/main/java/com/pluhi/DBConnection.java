package com.pluhi;

public class DBConnection {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/pluhis_database";
    static final String USER = "postgres";
    static final String PASSWORD = "Polipoknak22";
    static final String QUERY = """
            select person.first_name, person.surname, person.birthday, relationship_type.title, contact.contact
            from person, relationship_type, relationship, contact
            where contact.contact like '%@%' and
            relationship.id_relationship_type = relationship_type.id_relationship_type and
            relationship.id_person2 = person.id_person and
            contact.id_person = person.id_person""";

}
