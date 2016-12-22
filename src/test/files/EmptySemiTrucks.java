
public class EmptySemiTrucks {

	public int sum1() { // Noncompliant
		int result = 0;
		for (int i = 0; i < 2; i++) {
			result += find();
		}
		return result;
	}

	public int sum2() {
		int[] array = findAll();
		int result = 0;
		for (int i = 0; i < 2; i++) {
			result += array[i];
		}
		return result;
	}

	public int find() {
		return 2;
	}

	public int[] findAll() {
		return new int[] { 2, 2 };
	}
}
