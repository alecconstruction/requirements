package beautiful.phoebe.app.chromelog;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChromeLogRepository extends CrudRepository<ChromeLog, Integer> {

}
