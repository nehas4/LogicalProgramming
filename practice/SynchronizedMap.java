package practice;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SynchronizedMap implements Runnable {
	private Map<String, String> entityInfoMap = Collections.synchronizedMap(new HashMap<>());

	public SynchronizedMap(Map<String, String> entityInfoMap) {
		super();
		this.entityInfoMap = entityInfoMap;
	}

	public static void main(String[] args) throws Exception {
		Map map = new HashMap();
		map.put("A", 1);
		map.put("B", 2);
		map.put("C", 3);

//		Map synchronizedMap = Collections.synchronizedMap(map);
//		Thread t1 = new Thread(new A(synchronizedMap));
//		Thread t2 = new Thread(new A(synchronizedMap));
//		Thread t3 = new Thread(new A(synchronizedMap));
//		Thread t4 = new Thread(new A(synchronizedMap));

		Thread t1 = new Thread(new SynchronizedMap(map));
		Thread t2 = new Thread(new SynchronizedMap(map));
		Thread t3 = new Thread(new SynchronizedMap(map));
		Thread t4 = new Thread(new SynchronizedMap(map));

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

	@Override
	public void run() {

		System.out.println(this.entityInfoMap);

		this.entityInfoMap.put(Thread.currentThread().toString(), Thread.currentThread().toString());

		Set<String> entityIdSet = this.entityInfoMap.keySet();

		System.out.println(this.entityInfoMap);

	}
}
