package beautiful.phoebe.app.chromelog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChromeLogService {
	@Autowired
	private ChromeLogRepository chromeLogRepository;
	
	public void addChromeLogs(List<ChromeLog> chromeLogs) {
		chromeLogRepository.saveAll(chromeLogs);
	}
}
