package util;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static EntityManagerFactory emf;

    private JPAUtil() {
        // prevent object creation
    }

    public static synchronized EntityManagerFactory getEMF() {
        if (emf == null) {
            Map<String, String> props = new HashMap<>();

            String password = System.getenv("DB_PASSWORD");

            if (password == null || password.isEmpty()) {
                throw new RuntimeException(
                    "DB_PASSWORD environment variable is not set"
                );
            }

            props.put("javax.persistence.jdbc.password", password);

            emf = Persistence.createEntityManagerFactory("cars", props);
        }
        return emf;
    }
}
