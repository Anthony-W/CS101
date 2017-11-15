
/***************************************************************
Anthony Wessel
Set.java
Project 5
Implements a sorted set of integers which contains no more than
  one occurrence of any value
***************************************************************/

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
	// internal storage
	ArrayList<Integer> _set_array;

	/*
	 * default constructor
	 */
	public Set()
	{
		// create array
		_set_array = new ArrayList<Integer>();
	}

	/*
	 * overloaded constructor
	 * 
	 * @param size the size of the array to be created
	 */
	public Set(int size)
	{
		// create array
		_set_array = new ArrayList<Integer>(size);
	}

	/*
	 * overloaded constructor creates a new array using the numbers between low and
	 * high (inclusive)
	 * 
	 * @param low starting number to be stored
	 * 
	 * @param high final number to be stored
	 */
	public Set(int low, int high)
	{
		// create array
		int size = high - low + 1;
		_set_array = new ArrayList<Integer>(size);

		// fill array
		for (int i = low; i <= high; i++)
		{
			_set_array.add(i);
		}
	}

	/*
	 * gets the number in this array at the given index
	 * 
	 * @param index index to use
	 * 
	 * @return number at input index
	 */
	public Integer get(int index)
	{
		return _set_array.get(index);
	}

	/*
	 * adds a single integer to this set
	 * 
	 * @param o integer to be added
	 * 
	 * @return TRUE or FALSE whether or not the integer was added
	 */
	boolean add(Integer o)
	{
		// null check
		if (o == null)
			return false;

		// already in set
		if (_set_array.contains(o))
			return false;

		// add the integer at the correct location
		for (int i = 0; i < _set_array.size(); i++)
		{
			if (_set_array.get(i) > o)
			{
				_set_array.add(i, o);
				return true;
			}
		}

		// add the integer at end
		_set_array.add(o);
		return true;
	}

	/*
	 * adds an array of integers to this set
	 * 
	 * @param s array of integers to add
	 * 
	 * @return number of integers successfully added
	 */
	int add(Integer[] s)
	{
		int numAdded = 0;

		// null check
		if (s == null)
			return 0;

		// call add(Integer) for each element of s
		for (int i = 0; i < s.length; i++)
		{
			if (add(s[i]))
				numAdded++;
		}

		return numAdded;
	}

	/*
	 * removes an integer from this set
	 * 
	 * @param o integer to remove
	 * 
	 * @return integer removed (null if not removed)
	 */
	Integer remove(Integer o)
	{
		// o not contained in array
		if (!_set_array.contains(o))
			return null;

		// find occurrence of o and remove it
		for (int i = 0; i < _set_array.size(); i++)
		{
			if (_set_array.get(i).equals(o))
			{
				Integer removedInt = _set_array.remove(i);
				return removedInt;
			}
		}

		return null; // should never reach this

	}

	/*
	 * removes a set of integers from this set
	 * 
	 * @param s set of integers to remove
	 * 
	 * @return number of integers successfully removed
	 */
	int remove(Set s)
	{
		// null check
		if (s == null)
			return 0;

		int numRemoved = 0;

		// call remove(Integer) for each element of s
		for (int i = 0; i < s.size(); i++)
		{
			if (remove(s.get(i)) != null)
			{
				numRemoved++;
				i--; // compensate for all values moving down once
			}
		}

		return numRemoved;
	}

	/*
	 * finds whether or not an integer is in this set
	 * 
	 * @param o integer to find
	 * 
	 * @return TRUE or FALSE whether or not the integer is in this set
	 */
	boolean contains(Integer o)
	{
		if (_set_array.contains(o))
			return true;
		else
			return false;
	}

	/*
	 * clears the array
	 */
	void clear()
	{
		_set_array.clear();
	}

	/*
	 * determines if this set is empty
	 * 
	 * @return TRUE or FALSE whether or not this set is empty
	 */
	boolean isEmpty()
	{
		// checks for any value in the set
		for (int i = 0; i < _set_array.size(); i++)
		{
			if (_set_array.get(i) != null)
				return false; // found a value
		}

		// no value found
		return true;
	}

	/*
	 * gets the size of this set
	 * 
	 * @return size of the set
	 */
	int size()
	{
		return _set_array.size();
	}

	/*
	 * combines two sets
	 * 
	 * @param s set to be combined with this set
	 * 
	 * @return combined set
	 */
	public Set union(Set s)
	{
		// null check
		if (s == null)
			return this;

		Set result = this;

		// adds any values from s that are not already in the result set
		for (int i = 0; i < s.size(); i++)
		{
			result.add(s.get(i));
		}

		return result;
	}

	/*
	 * creates a set with the numbers found in two sets
	 * 
	 * @param s set to be intersected with this set
	 * 
	 * @return intersected set
	 */
	public Set intersection(Set s)
	{
		Set result = new Set();

		// null check
		if (s == null)
			return result;

		// add any numbers found in both s and this set to result set
		for (int i = 0; i < this.size(); i++)
		{
			int numberToCheck = this.get(i);
			if (s.contains(numberToCheck))
			{
				result.add(numberToCheck);
			}
		}

		return result;
	}

	/*
	 * determines whether or not s is the subset of this set
	 * 
	 * @param s set to check
	 * 
	 * @return TRUE of FALSE whether or not s is a subset
	 */
	public boolean subset(Set s)
	{
		// null check
		if (s == null)
			return true;

		// loops through all values in s
		for (int i = 0; i < s.size(); i++)
		{
			// checks in this set for each value
			if (!this.contains(s.get(i)))
			{
				return false;
			}
		}
		return true;
	}

	/*
	 * determines whether or not s is the superset of this set
	 * 
	 * @param s set to check
	 * 
	 * @return TRUE of FALSE whether or not s is a superset
	 */
	public boolean superset(Set s)
	{
		// null check
		if (s == null)
			return false;

		// loops through all values in this set
		for (int i = 0; i < this.size(); i++)
		{
			// checks in s for each value
			if (!s.contains(this.get(i)))
			{
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
