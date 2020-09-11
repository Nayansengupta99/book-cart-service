package com.cognizant.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.model.CartModel;
@Repository
@Transactional
public interface CartRepository extends JpaRepository<CartModel,Integer> {

@Modifying
@Query(value="insert into cart(userid,bookid) values(?1,?2)",nativeQuery = true)
public int insertCartItems(@Param("userid") Long userId,@Param("bookid") Long bookId);

@Query(value = "select * from cart c where c.userid=:userId", nativeQuery = true)
public CartModel findById(@Param("userId") Long userid);



}
