package repositories;

import domain.Event;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import repositories.interfaces.IEventRepository;

import java.util.List;

/**
 * Created by Alisa on 5/14/2017.
 */
@Repository
public class EventRepository implements IEventRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Event> getAll() {
        String sql = "select * from Events";
        return jdbcTemplate.query(sql, (rs, i) -> new Event(rs.getInt("id"), rs.getString("name"), rs.getString("description"), getEventUsers(rs.getInt("id"))));
    }

    @Override
    public void save(Event event) {
        String sql = "insert into Events (name, description) values (?, ?)";
        jdbcTemplate.update(sql, event.getName(), event.getDescription());
    }

    @Override
    public Event findOne(Integer id) {
        String sql = "select * from Events where id=?";
        Event event = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Event.class), id);
        event.setUsers(getEventUsers(id));
        return event;
    }

    @Override
    public void update(Event event) {
        String sql = "update Events set Events.description = '" + event.getDescription() + "' where id=" + event.getId();
        jdbcTemplate.execute(sql);
    }

    private List<User> getEventUsers(Integer id) {
        String sql = "select Users.id as id, Users.name as name from Events \n" +
                "inner join Users on Events.id = Users.eventId \n" +
                "where Events.id =" + id;
        return jdbcTemplate.query(sql, (rs, i) -> new User(rs.getInt("id"), rs.getString("name")));
    }
}
