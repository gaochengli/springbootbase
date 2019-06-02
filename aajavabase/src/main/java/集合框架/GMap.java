package 集合框架;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface GMap<K,V> {
	//查询操作
	int size();
	boolean isEmpty();
	boolean containsKey(K key);
	boolean containsValue(V value);
	V get(K key);
	//修改操作
	V put(K key,V value);
	V remove(K key);
	//大批量处理
	void putAll(GMap<? extends K,? extends V> map);
	void clear();
	//视图
	Set<K> keySet();
	Collection<V> values();
	Set<GEntry<K, V>> entrySet();
	//
	boolean equals(GMap o);
	int hashcode();
	
	interface GEntry<K,V>{
		
	}
}
