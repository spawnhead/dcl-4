package net.sam.dcl.modern.config;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Загрузка пользователя из dcl_user по usr_login для parity с Legacy login.
 */
@Service
public class DclUserDetailsService implements UserDetailsService {

    private final JdbcTemplate jdbcTemplate;

    public DclUserDetailsService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String sql = "SELECT usr_id, usr_login, usr_passwd, usr_block FROM dcl_user WHERE usr_login = ?";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, username);
        if (rows.isEmpty()) {
            throw new UsernameNotFoundException("Пользователь не найден: " + username);
        }
        Map<String, Object> row = rows.get(0);
        String login = getString(row, "usr_login", username);
        String passwd = getString(row, "usr_passwd", "");
        Object blockObj = row.get("usr_block");
        boolean enabled = blockObj == null || !Integer.valueOf(1).equals(blockObj);

        return User.builder()
                .username(login)
                .password(passwd)
                .disabled(!enabled)
                .roles("USER")
                .build();
    }

    private static String getString(Map<String, Object> row, String key, String fallback) {
        Object v = row.get(key);
        if (v == null) {
            v = row.get(key.toLowerCase());
        }
        return v != null ? v.toString() : fallback;
    }
}
