package book;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Product {
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
/*	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return id == other.id;
	}*/
	int id;
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	String name;  
    float price;  
    public Product(int id, String name, float price) {  
        super();
        this.id = id;  
        this.name = name;  
        this.price = price;  
    }
}  
public class Test1 {
	
    public static void main(String[] args) {  
        var products = Stream.of(
        		new Product(1,"HP Laptop",25000f),
        		new Product(3,"Keyboard",300f),
        		new Product(2,"Dell Mouse",150f),
        		new Product(4,"Sony Laptop",28000f),
//        		new Product(5,"Apple Laptop",90000f),
//        		new Product(5,"Apple Laptop",80000f),
        		new Product(5,"Apple Laptop",70000f)
        		)
        		.sorted((p1, p2) -> {
        			return p1.name.compareTo(p2.name);
        		})
        		.collect(Collectors.toList());
        
        System.out.println("Sorting on the basis of name...");
        
        var prices = products.stream()
        		.map(Product::getPrice)
        		.collect(Collectors.toList());
        System.out.println(prices);
        /*
        // equals override
        var ids = new HashSet<>();
        var list = products.stream()
	        .distinct()
	        .toList();
        list.forEach(System.out::println);
        
        var p1 = new Product(5,"Apple Laptop",90000f);
        var p2 = new Product(5,"Apple Laptop",80000f);
        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));
        
        // HashSet을 이용한 중복제거
        var ids = new HashSet<>();
        var list = new ArrayList<>();
        
        for(var product : products) {
        	if(!ids.contains(product.id)) {
        		ids.add(product.id);
        		list.add(product);
        		System.out.println(product);
        	}
        }
        */
    }
}
