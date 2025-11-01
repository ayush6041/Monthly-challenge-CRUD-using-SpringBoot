package com.monthly.ChallengeApp.Repository;

import com.monthly.ChallengeApp.model.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChallangeRepo extends JpaRepository<Challenge,Long> {
    Optional<Challenge> findByMonth(String month);
}
