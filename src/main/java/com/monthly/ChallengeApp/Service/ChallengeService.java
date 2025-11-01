package com.monthly.ChallengeApp.Service;

import com.monthly.ChallengeApp.Repository.ChallangeRepo;
import com.monthly.ChallengeApp.model.Challenge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChallengeService {

    @Autowired
    ChallangeRepo challangeRepo;

//    private List<Challenge> challenges = new ArrayList<>();
    private  Long nextId=1L;

    public ChallengeService(){
    }
    public List<Challenge>getAllChallenges(){
        return challangeRepo.findAll();
    }


    public boolean addChallenges(Challenge challenge){
        if(challenge!=null){
            challenge.setId(nextId++);
            challangeRepo.save(challenge);
            return true;
        }
        else return false;
    }

    public Challenge getChallenges(String month) {
        Optional<Challenge>challenge=challangeRepo.findByMonth(month);
        return challenge.orElse(null);
    }

    public boolean updateChallange(Long id, Challenge updateChallenge) {
        Optional<Challenge>challenge=challangeRepo.findById(id);
        if (challenge.isPresent()){
            Challenge challengeUpdate=challenge.get();
            challengeUpdate.setMonth(updateChallenge.getMonth());
            challengeUpdate.setDescription(updateChallenge.getDescription());
            challangeRepo.save(challengeUpdate);
            return true;
        }
        return false;
    }

    public boolean deleteChallange(Long id) {
        Optional<Challenge>challenge=challangeRepo.findById(id);
        if (challenge.isPresent()){
            challangeRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
