import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.java.contract.ContractImport;
import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;

@Invariant({"numbers != null", "numbers.stream().allMatch(n -> n != null)"})
public class NaturalList {
	private ArrayList<Natural> numbers;
	
	// No contracts required for the following methods.
	public NaturalList(NaturalList o) { 
		numbers = new ArrayList<Natural>();
		for(Natural n : o.numbers) 
			numbers.add(new Natural(n));
	}
	
	public NaturalList() {
		numbers = new ArrayList<Natural>();
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof NaturalList)) return false;
		NaturalList other = (NaturalList) o;
		return numbers.equals(other.numbers);
	}

	@Override
	public String toString() {
		return numbers.toString(); 
	}

	// Add contracts to all following methods.
	@Requires("n != null")
	@Ensures("numbers.contains(n)")
	public void push(Natural n) {
		numbers.add(n);
	}
	@Requires({"i >= 0", "i < numbers.size()"})
	@Ensures("result != null")
	public Natural get(int i) {
		return numbers.get(i);
	}
	@Requires({"i >= 0", "i < numbers.size()", "n != null"})
	@Ensures("numbers.get(i) == n")
	public void set(int i, Natural n) {
		numbers.set(i, n);
	}
	@Ensures("numbers.stream().sorted().toList().equals(numbers)")
	public void sort() {
		Collections.sort(numbers);
	}
	@Requires("n != null")
	@Ensures("numbers.equals(old(numbers))")
	
	public int search(Natural n) {
		return Collections.binarySearch(numbers, n);
	}
	


	}

