package com.accenture.ltt.collection.demo.equalshashcode;
import java.util.Objects;

class Employee {
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Override equals()
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Reflexive
        if (obj == null || getClass() != obj.getClass()) return false; // Null & type check
        Employee other = (Employee) obj;
        return id == other.id && Objects.equals(name, other.name);
    }

    // Override hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

public class EqualsHashCodeDemo {
    public static void main(String[] args) {
        Employee x = new Employee(101, "Priya");
        Employee y = new Employee(101, "Priya");
        Employee z = new Employee(101, "Priya");

        // 1. Reflexive
        System.out.println("Reflexive: x.equals(x) = " + x.equals(x)); // true

        // 2. Symmetric
        System.out.println("Symmetric: x.equals(y) = " + x.equals(y)); // true
        System.out.println("Symmetric: y.equals(x) = " + y.equals(x)); // true

        // 3. Transitive
        System.out.println("Transitive: x.equals(y) = " + x.equals(y)); // true
        System.out.println("Transitive: y.equals(z) = " + y.equals(z)); // true
        System.out.println("Transitive: x.equals(z) = " + x.equals(z)); // true

        // 4. Consistent
        System.out.println("Consistent: x.equals(y) repeated = " + x.equals(y)); // true
        System.out.println("Consistent: x.equals(y) repeated again = " + x.equals(y)); // true

        // 5. Null Comparison
        System.out.println("Null Comparison: x.equals(null) = " + x.equals(null)); // false

        // HashCode consistency
        System.out.println("x.hashCode() = " + x.hashCode());
        System.out.println("y.hashCode() = " + y.hashCode());
        System.out.println("z.hashCode() = " + z.hashCode());
    }
}