package com.example.autoconfiguration;


import com.example.autoconfiguration.model.User;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;


@ActiveProfiles("integration-test")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = {
        AutoconfigurationApplication.class})
public abstract class AbstractTestSupporter {


    protected static final User userWithName444 = new User() {{
        setId(444L);
        setName("444");
        setEmail("444@.444");
    }};

    private static final String GET_USER_BY_ID = "SELECT * FROM public.\"User\" WHERE id = ?";
    private static final String
	   IS_EXIST_IN_USER_TABLE =
	   "SELECT count(*) FROM public.\"User\" WHERE id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    protected Optional<User> getUserByIdJdbc(long id) {
        return jdbcTemplate.queryForObject(GET_USER_BY_ID,
	       new Object[]{id},
	       ((rs, rowNum) -> Optional.of(new User(rs.getLong("id"),
		      rs.getString("name"),
		      rs.getString("email")))));
    }

    protected Boolean isExistInDB(long id) {
        int
	       count =
	       jdbcTemplate.queryForObject(IS_EXIST_IN_USER_TABLE,
		      new Object[]{id},
		      Integer.class);

        return count > 0;
    }

}
