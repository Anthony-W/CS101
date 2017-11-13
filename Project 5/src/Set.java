
import java.util.ArrayList;
import java.lang.ClassCastException;

/**
 * For this assignment a set is generally defined as a list of values that is
 * sorted and does not contain any duplicate values. More specifically, a set
 * shall contain no pair of elements e1 and e2 such that e1.equals(e2), and at
 * most one null element.
 */
public class Set
{
    //
    // TODO members
    //
	ArrayList<Integer> _set_array;

    //
    // TODO constructors
    //
	public Set() {
		_set_array = new ArrayList<Integer>();
	}
	
	public Set(int size) {
		_set_array = new ArrayList<Integer>(size);
	}
	
	public Set(int low, int high) {
		int size = high - low + 1;
		//System.out.println(size);
		_set_array = new ArrayList<Integer>(size);
		//System.out.println(_set_array.size());
		for (int i = low; i <= high; i++) {
			_set_array.add(i);
		}
	}
	
    //
    // TODO miscellaneous methods
    //
    public Integer get(int index)
    {
        // TODO implementation
    	return _set_array.get(index);
    }

    //
    // TODO add() methods
    //
    boolean add(Integer o) {
    	if (o == null) return false;
    	if (_set_array.contains(o)) return false;
    	for (int i = 0; i < _set_array.size(); i++) {
			if (_set_array.get(i) > o) {
				_set_array.add(i, o);
				return true;
			}
		}
    	_set_array.add(o);
    	return true;
    }
    
    int add(Integer[] s) {
    	int numAdded = 0;
    	if (s == null) return 0;
    	for (int i = 0; i < s.length; i++) {
    		if (add(s[i])) numAdded++;
    	}
    	return numAdded;
    }
    
    //
    // TODO remove() methods
    //
    Integer remove(Integer o) {
    	if (!_set_array.contains(o)) return null;
    	for (int i = 0; i < _set_array.size(); i++) {
			if (_set_array.get(i).equals(o)) {
				Integer removedInt = _set_array.remove(i);
				return removedInt;
			}
		}
    	return null; //should never reach this
    	
    }
    
    int remove(Set s) {
    	if (s == null) return 0;
    	int numRemoved = 0;
    	for (int i = 0; i < s.size(); i++) {
    		if (remove(s.get(i)) != null) {
    			numRemoved++;
    			i--; //compensate for all values moving down once 
    		}
    	}
    	return numRemoved;
    }
    
    //
    // misc methods
    //
    boolean contains(Integer o) {
    	if (_set_array.contains(o)) return true;
    	else return false;
    }
    
    void clear() {
    	_set_array.clear();
    }
    
    boolean isEmpty() {
    	for (int i = 0; i < _set_array.size(); i++) {
    		if (_set_array.get(i) != null) return false;
    	}
    	return true;
    }
    
    int size() {
    	return _set_array.size();
    }
    
    public Set union(Set s)
    {
    	if (s == null) return this;
    	Set result = this;
    	for (int i = 0; i < s.size(); i++) {
    		result.add(s.get(i));
    	}
    	
    	return result;
    }

    public Set intersection(Set s)
    {
    	Set result = new Set();
    	if (s == null) return result;
    	
    	for (int i = 0; i < this.size(); i++) {
    		int numberToCheck = this.get(i);
    		if (s.contains(numberToCheck)) {
    			result.add(numberToCheck);
    		}
    	}
    	
    	return result;
    }

    public Set difference(Set s)
    {
    	return new Set(); //TODO
    }

    public Set exclusiveDifference(Set s)
    {
    	return new Set(); //TODO
    }

    public boolean subset(Set s)
    {
    	if (s == null) return true;
    	for (int i = 0; i < s.size(); i++) {
    		if (!this.contains(s.get(i))) {
    			return false;
    		}
    	}
    	return true;
    }

    public boolean superset(Set s)
    {
    	if (s == null) return false;
    	for (int i = 0; i < this.size(); i++) {
    		if (!s.contains(this.get(i))) {
    			return false;
    		}
    	}
    	return true;
    }

    public String toString()
    {
        String ret_string = "";

        for (int i = 0; i < _set_array.size(); i++)
        {
            ret_string += _set_array.get(i).toString() + (i != _set_array.size() - 1 ? " " : "");
        }

        return ret_string;
    }

    public boolean equals(Object o) throws ClassCastException
    {
        if (!(o instanceof Set))
        {
            throw new ClassCastException();
        }

        Set s = (Set) (o);

        for (int i = 0; i < _set_array.size(); i++)
        {
            if (!s.contains(_set_array.get(i)))
            {
                return false;
            }
        }

        for (int i = 0; i < s.size(); i++)
        {
            if (!_set_array.contains(s.get(i)))
            {
                return false;
            }
        }

        return true;
    }
}
