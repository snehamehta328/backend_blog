package com.example.blogBack.repository;

import com.example.blogBack.models.blog;

import com.example.blogBack.models.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<blog, Long>
{
    @Override
    List<blog> findAll();

    List<blog>findByUsers(user users);
    blog findByBlogId(Long id);
    List<blog>findAllByCategory(String product_category);
//    List<Products>findAllByCategoryAndPriceBetween(String cat,Double p1,Double p2);
//    List<Products>findByPriceBetween(Double product_price1,Double product_price2);
}
