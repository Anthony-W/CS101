
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
		System.out.println(size);
		_set_array = new ArrayList<Integer>(size);
		System.out.println(_set_array.size());
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
    	for (int i = 0; i < s.length; i++) {
    		if (add(s[i])) numAdded++;
    	}
    	return numAdded;
    }
    
    //
    // TODO remove() methods
    //
    Integer remove(Integer o) {
    	return 0; //TODO
    }
    
    int remove(Set s) {
    	return 0; //TODO
    }
    
    //
    // misc methods
    //
    boolean contains(Integer o) {
    	if (_set_array.contains(o)) return true;
    	else return false;
    }
    
    void clear() {
    	
    }
    
    boolean isEmpty() {
    	return false; //TODO
    }
    
    int size() {
    	return 0; //TODO
    }
    
    public Set union(Set s)
    {
    	return new Set(); //TODO
    }

    public Set intersection(Set s)
    {
    	return new Set(); //TODO
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
    	return false; ///TODO
    }

    public boolean superset(Set s)
    {
    	return false; //TODO
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
