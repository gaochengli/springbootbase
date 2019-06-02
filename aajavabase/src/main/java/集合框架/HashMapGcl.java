/**
 * 
 */
package 集合框架;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @author clgao
 *
 */
public class HashMapGcl<K,V> extends AbstractMap<K,V>implements Map<K,V>,Cloneable,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5130035526706101247L;
	
	/**
	 * 默认初始容量-必须是2的幂
	 */
	static final int default_initial_capacity = 1<<4; 
	
	/**
	 * 最大值2^30 1073741824
	 */
	static final int maximum_capacity = 1<<30;
	
	/**
	 * 默认负载因子
	 */
	static final float default_load_factor = 0.75f;
	
	/**
	 * 当前map包含的键值数量
	 */
	transient int size;
	
	/**
	 * 临界值：要调整大小的下一个大小值（容量*加载因子）。
	 */
	int threshold;
	
	/**
	 * hash表的负载因子
	 */
	final float loadFactor;
	
	/**
	 * 有初始容量和负载因子的构造器
	 * @param initialCapacity
	 * @param loadFactor
	 * @throws IllegalArgumentException 初始容量和负载因子为负等非法值
	 */
	public HashMapGcl(int initialCapacity,float loadFactor) {
		if(initialCapacity<0) {
			throw new IllegalArgumentException("非法的初始化容量"+initialCapacity);
		}
		if(initialCapacity>maximum_capacity) {
			initialCapacity = maximum_capacity;
		}
		if(loadFactor <= 0 || Float.isNaN(loadFactor)) {
			throw new IllegalArgumentException("非法的负载因子"+loadFactor);
		}
		this.loadFactor = loadFactor;
		this.threshold = tableSizeFor(initialCapacity);
	}
	
	/**
	 * 返回2的幂，为了能包括给定目标容量大小
	 * @param cap
	 * @return
	 */
	static final int tableSizeFor(int cap) {
		int n = cap - 1;
		n |= n >>> 1;
		n |= n >>> 2;
		n |= n >>> 4;
		n |= n >>> 8;
		n |= n >>> 16;
		return (n < 0) ? 1 : (n >= maximum_capacity) ? maximum_capacity : n+1;
	}
	/**
	 * 规定了初始容量，用了默认负载因子0.75的构造器
	 * @param initialCapacity
	 */
	public HashMapGcl(int initialCapacity) {
		this(initialCapacity,default_load_factor);
	}
	
	/**
	 * 所有的其他成员变量都是默认值
	 */
	public HashMapGcl() {
		this.loadFactor = default_load_factor;
	}
	/* (non-Javadoc)
	 * @see java.util.AbstractMap#entrySet()
	 */
	/**
	 * @author clgao
	 * 节点实现了Map中的Entry
	 * @param <K>
	 * @param <V>
	 */
	static class Node<K,V> implements Map.Entry<K, V>{
		//key的hashcode
		final int hash;
		final K key;
		V value;
		Node<K,V> next;
		Node(int hash,K key,V value,Node<K,V> next){
			this.hash = hash;
			this.key = key;
			this.value = value;
			this.next = next;
		}
		public final K getKey() {return key;}
		public V getValue() {return value;}
		public final String toString() {return key+"="+value;}
		
		public final int hashCode() {
			return Objects.hashCode(key)^Objects.hashCode(value);
		}
		public final boolean equals(Object o) {
			if(o == this) {
				return true;
			}
			if(o instanceof Map.Entry) {
				Map.Entry<?, ?> e = (Map.Entry<?, ?>)o;
				if(Objects.equals(key, e.getKey())&&Objects.equals(value, e.getValue())) {
					return true;
				}
			}
			return false;
		}
		public V setValue(V newValue) {
			V oldValue = value;
			value = newValue;
			return oldValue;
		}
		
	}
	
	@Override
	public Set<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

































































