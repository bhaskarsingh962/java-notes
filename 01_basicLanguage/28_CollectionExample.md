package 01_basicLanguage;

public class 28_Collection {
    
}



Explanation of all interfaces and classes in your diagram.

Their hierarchy (where they derive from).

How they work internally.

Key methods.

Examples of implementation.

A diagram to replicate the one you sent.

markdown
Copy
Edit
# Java Collection Framework — Classes & Interfaces

## 1. Introduction
The **Java Collection Framework (JCF)** provides a unified architecture for storing and manipulating groups of objects.  
It contains:
- **Interfaces** — define common behaviors.
- **Classes**  — concrete implementations.

---

## 2. Core Interfaces

### 2.1 `Collection` (Root Interface)
- **Parent** of all collection interfaces (`List`, `Set`, `Queue`).
- Defines basic operations like `add`, `remove`, `size`.
- **Key Methods:**
  ```java
  boolean add(E e)
  boolean remove(Object o)
  int size()
  boolean isEmpty()
  void clear()
  boolean contains(Object o)
  Iterator<E> iterator()
2.2 List Interface
Ordered collection allowing duplicate elements.

Maintains insertion order.

Implementations: ArrayList, LinkedList, Vector, Stack.

Key Methods:

java
Copy
Edit
void add(int index, E element)
E get(int index)
E set(int index, E element)
E remove(int index)
int indexOf(Object o)
List<E> subList(int fromIndex, int toIndex)
2.3 Set Interface
No duplicates allowed.

Implementations: HashSet, LinkedHashSet, TreeSet (via SortedSet).

Key Methods:

java
Copy
Edit
boolean add(E e)
boolean contains(Object o)
boolean remove(Object o)
int size()
2.4 SortedSet & NavigableSet
SortedSet: Maintains elements in sorted order.

NavigableSet: Extends SortedSet with navigation methods.

Key Methods in NavigableSet:

java
Copy
Edit
E first()
E last()
E ceiling(E e)
E floor(E e)
E higher(E e)
E lower(E e)
2.5 Queue Interface
FIFO (First-In-First-Out) ordering (mostly).

Implementations: PriorityQueue, LinkedList, ArrayDeque.

Key Methods:

java
Copy
Edit
boolean offer(E e)
E poll()
E peek()
2.6 Deque Interface
Double-ended queue — insertion/removal from both ends.

Implementation: ArrayDeque, LinkedList.

Key Methods:

java
Copy
Edit
void addFirst(E e)
void addLast(E e)
E removeFirst()
E removeLast()
E getFirst()
E getLast()
2.7 Map Interface (Separate Hierarchy)
Key-value pairs, no duplicate keys.

Implementations: HashMap, TreeMap, EnumMap.

Key Methods:

java
Copy
Edit
V put(K key, V value)
V get(Object key)
V remove(Object key)
boolean containsKey(Object key)
boolean containsValue(Object value)
Set<K> keySet()
Collection<V> values()
2.8 SortedMap & NavigableMap
SortedMap: Keys in sorted order.

NavigableMap: Extra methods for navigation.

Key Methods in NavigableMap:

java
Copy
Edit
Map.Entry<K,V> firstEntry()
Map.Entry<K,V> lastEntry()
Map.Entry<K,V> ceilingEntry(K key)
Map.Entry<K,V> floorEntry(K key)
3. Concrete Classes and How They Work
Class	Implements	Internal Working	When to Use
ArrayList	List	Resizable array	Fast random access, slower insert/remove in middle
LinkedList	List, Deque	Doubly-linked list	Frequent insert/remove in middle, slower random access
Vector	List	Synchronized ArrayList	Thread-safe alternative to ArrayList
Stack	Vector	LIFO stack	Last-In-First-Out operations
HashSet	Set	Hash table (backed by HashMap)	Fast lookups, no order
LinkedHashSet	Set	Hash table + linked list	Maintains insertion order
TreeSet	NavigableSet	Red-Black Tree	Sorted set
PriorityQueue	Queue	Heap	Priority-based ordering
ArrayDeque	Deque	Resizable array	Double-ended queue without capacity restriction
HashMap	Map	Hash table	Fast lookups, no order
LinkedHashMap	Map	Hash table + linked list	Maintains insertion order
TreeMap	NavigableMap	Red-Black Tree	Sorted map
EnumMap	Map	Array-based for enum keys	Highly efficient with enum keys

4. Hierarchy Diagram (Text Representation)
mathematica
Copy
Edit
Collection
├── List
│   ├── ArrayList
│   ├── LinkedList
│   └── Vector
│       └── Stack
├── Set
│   ├── HashSet
│   └── LinkedHashSet
│   └── SortedSet
│       └── TreeSet
├── Queue
│   ├── PriorityQueue
│   └── Deque
│       ├── LinkedList
│       └── ArrayDeque

Map
├── HashMap
│   └── LinkedHashMap
├── EnumMap
└── SortedMap
    └── NavigableMap
        └── TreeMap
5. Example Usage
java
Copy
Edit
import java.util.*;

public class CollectionExample {
    public static void main(String[] args) {
        // List Example
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        System.out.println(list);

        // Set Example
        Set<Integer> set = new HashSet<>();
        set.add(10);
        set.add(20);
        System.out.println(set);

        // Map Example
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        System.out.println(map);

        // Queue Example
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(5);
        queue.offer(10);
        System.out.println(queue.poll());
    }
}
6. Interview Questions
Q1: Difference between ArrayList and LinkedList?
A: ArrayList is backed by a dynamic array (fast access, slower insert/remove in middle), LinkedList by a doubly-linked list (slow access, faster insert/remove in middle).

Q2: How does HashSet work internally?
A: Uses HashMap internally with keys as set elements and a constant dummy object as value.

Q3: Can we sort a HashMap?
A: Not directly. Convert to TreeMap or use streams for sorting.

Q4: Difference between HashMap and TreeMap?
A: HashMap is unordered, TreeMap maintains sorted order of keys.

Q5: Difference between ArrayDeque and LinkedList as Deque?
A: ArrayDeque is array-based (faster, no capacity restriction), LinkedList is linked-node-based (more memory, slightly slower)