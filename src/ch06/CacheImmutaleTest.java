package ch06;

/**
 * 缓存
 * @author YouZeng
 *
 */
class Immutale{
	//缓存容量
	private static int MAX_SIZE = 10;
	private String name;
	//缓存当前位置
	private static int pos;
	//缓存池
	private static Immutale[] cache = new Immutale[MAX_SIZE];
	private Immutale(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	/**
	 * 取对象
	 * @return
	 */
	public static Immutale valueOf(String name){
		//缓存中查找.
		for(int i = 0;i < MAX_SIZE;i += 1){
			if(cache[i] != null && cache[i].getName().equals(name)){
				return cache[i];
			}
		}
		//如果在缓存中不存在，则添加到缓存中.
		if(pos == MAX_SIZE){
			cache[0] = new Immutale(name);
			pos = 1;
		}else{
			cache[pos++] = new Immutale(name);
		}
		return cache[pos - 1];
	}
	public boolean equals(Object obj){
		if(this == obj){
			return true;
		}
		if(obj != null && obj.getClass() == Immutale.class){
			Immutale immutale = (Immutale)obj;
			return immutale.getName().equals(name);
		}
		return false;
	}
	public int hashCode(){
		return name.hashCode();
	}
}

public class CacheImmutaleTest {

	public static void main(String[] args) {
		Immutale im1 = Immutale.valueOf("hello");
		Immutale im2 = Immutale.valueOf("hello");
		System.out.println(im1 == im2);
	}
}
