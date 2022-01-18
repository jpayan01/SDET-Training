package coding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsDemo {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Marcela");
        names.add("Emma");
        names.add("David");
        names.add("Miriam");
        names.add("Juan");
        names.add("Pablo");

        List<String> name =names.stream().filter(x -> x.startsWith("M")).collect(Collectors.toList());
        System.out.println(name);
        //Or
        System.out.println("We can also do the following \n");
        names.stream().filter(x -> x.startsWith("E")).forEach(System.out::println);

        System.out.println("Filtering by Prices greater than $30,000 MXN \n");
        List<Product> productName = new ArrayList<>();
        productName.add(new Product(1, "Dell Laptop", 25000));
        productName.add(new Product(1, "Lenovo Laptop", 27000));
        productName.add(new Product(1, "Apple Laptop", 35000));
        productName.add(new Product(1, "Acer Laptop", 20000));
        productName.add(new Product(1, "Surface Laptop", 25000));
        productName.add(new Product(1, "Razr Laptop", 50000));

        productName.stream().filter(priceFilter -> priceFilter.price > 30000).forEach(x -> System.out.println(x.name));

    }
}

class Product{
    int id;
    String name;
    double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
