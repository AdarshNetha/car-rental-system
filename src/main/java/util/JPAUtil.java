package util;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static EntityManagerFactory emf;

    public static EntityManagerFactory getEMF() {
        if (emf == null) {
            Map<String, String> props = new HashMap<>();
            props.put(
                "javax.persistence.jdbc.password",
                System.getenv("DB_PASSWORD")
            );
            emf = Persistence.createEntityManagerFactory("cars", props);
        }
        return emf;
    }
}
