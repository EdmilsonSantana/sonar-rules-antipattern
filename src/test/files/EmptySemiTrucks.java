import java.util.List;

import org.hibernate.Query;

public class EmptySemiTrucks {

	private Query query;
	
	public Long sum1() { 
		Long result = 0L;
		for (int i = 0; i < 2; i++) {
			List<Long> list = query.list(); // Noncompliant
			result += list.get(i);
		}
		return result;
	}

	public Long sum2() {
		List<Long> list = query.list(); // compliant
		Long result = 0L;
		for (int i = 0; i < 2; i++) {
			result += list.get(i);
		}
		return result;
	}

}
