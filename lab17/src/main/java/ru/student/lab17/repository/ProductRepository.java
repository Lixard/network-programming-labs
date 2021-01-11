package ru.student.lab17.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.student.lab17.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
