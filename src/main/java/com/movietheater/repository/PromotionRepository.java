package com.movietheater.repository;

import com.movietheater.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Integer> {

    Promotion findByPromotionId(int promotionId);

    List<Promotion> findByTitleStartingWith(String title);

    List<Promotion> findByDetailStartingWith(String detail);

}
