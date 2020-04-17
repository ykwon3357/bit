package org.comstudy21.resource;

abstract class PairMap {
	protected Object keyArray[]; // key 들을 저장하는 배열
	protected Object valueArray[]; // value 들을 저장하는 배열

	abstract Object get(Object key); // key 값을 가진 value 리턴, 없으면 null 리턴

	abstract void put(Object ket, Object value); // key와 value를 쌍으로 저장. 기존에 key가
													// 있으면, 값을 value로 수정

	abstract Object delete(Object key); // key 값을 가진 아이템 (value와 함꼐) 삭제, 삭제된
										// value 값 리턴

	abstract int length(); // 현재 저장된 아이템의 개수 리턴
}

public class Map extends PairMap {
	protected int count = 0;

	public Map(int capacity) {
		keyArray = new Object[capacity];
		valueArray = new Object[capacity];
	}

	public Object get(Object key) {
		for (int i = 0; i < count; i++) {
			if (keyArray[i].equals(key))
				return valueArray[i];
		}
		return null;
	}

	public void put(Object key, Object value) {
		int i = 0;
		for (i = 0; i < count; i++) {
			if (keyArray[i].equals(key))
				break;
		}
		if (i == count) {
			if (i < keyArray.length) {
				keyArray[i] = key;
				valueArray[i] = value;
				count++;
			}
		} else {
			valueArray[i] = value;
		}

	}

	public Object delete(Object key) {
		int i = 0;
		for (i = 0; i < count; i++) {
			if (keyArray[i].equals(key))
				break;
		}
		if (i == count)
			return null;
		
		Object value =valueArray[i];
		for(int j=i;j<count-1;j++){
			keyArray[j]=keyArray[j+1];
			valueArray[j]=valueArray[j+1];
		}
		count--;
		return value;
	}

	public int length() {
		return count;
	}

}
