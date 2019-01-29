package base.jdbc;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    int insertUsers(User user);
    Optional<User> searchUserById(long id);
    List<User> searchUsersByIdRangeWithLimit(long startId, long endId, int limit);
    long insertNumber(User user);

}
