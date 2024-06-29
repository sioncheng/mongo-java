package mongojava.github.com.repository;

import mongojava.github.com.entity.Points;

public interface PointsRepository {

    Points findByAccount(String account);

    boolean incAmount(String account, Integer inc);
}
