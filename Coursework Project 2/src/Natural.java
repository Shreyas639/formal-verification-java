import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;
@Invariant({"data >= 0", "data <= Integer.MAX_VALUE"})   // Ensures data is always valid
public class Natural implements Comparable<Natural> {
	private int data;

	// No contracts required for the following methods.

	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Natural)) return false;
		Natural n = (Natural) o;
		return data==n.data;
	}
	
	public int compareTo(Natural n) { 
		return Integer.compare(data, n.data); 
	}
	
	public Natural(Natural n) {
		this(n.data);
	}

	@Override
	public String toString() {
		return Integer.toString(data); 
	}
	// Add contracts to all following methods.
	
	@Requires("d >= 0")
	@Ensures ("data == d")
	public Natural(int d) {
		data = d;
	}
	@Requires({"data >= 0", "data < Integer.MAX_VALUE"})
	@Ensures({"data == old(data) + 1", "data <= Integer.MAX_VALUE"})
	public void increment() {
		data++; 
	}
	@Requires("data > 0")
	@Ensures({"data == old(data) - 1", "data >= 0"})
	public void decrement() {
		data--;
	}
	@Requires("data <= Integer.MAX_VALUE - n.data")
	@Ensures({"data == old(data) + n.data", "data <= Integer.MAX_VALUE"})
	public void add(Natural n) {
		data += n.data;
	}
	@Requires("data >= n.data")
	@Ensures("data == old(data) - n.data")
	public void subtract(Natural n) {
		data -= n.data;
	}
	@Requires ({"n != null", "Integer.MAX_VALUE / data >= n.data"})
	@Ensures("data == old(data) * n.data")
	public void multiply(Natural n) {
		data *= n.data;
	}
	@Requires({"n != null", "n.data > 0"})
	@Ensures({"data == old(data) / n.data", "data >= 0"})
	public void divide(Natural n) {
		data /= n.data;
	}
}
