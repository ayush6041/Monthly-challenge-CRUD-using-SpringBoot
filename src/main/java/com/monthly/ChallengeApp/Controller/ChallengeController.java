package com.monthly.ChallengeApp.Controller;

import com.monthly.ChallengeApp.Service.ChallengeService;
import com.monthly.ChallengeApp.model.Challenge;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/challenges")
public class ChallengeController {
    private ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @GetMapping
    public  ResponseEntity<List<Challenge>> getAllChalenges(){
        return new ResponseEntity<>(challengeService.getAllChallenges(),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> addChallenges(@RequestBody Challenge challenge){
        boolean isChallengeAdded= challengeService.addChallenges(challenge);
        if(isChallengeAdded) return new ResponseEntity<>("Challenged added Successfully",HttpStatus.OK);
        else return new ResponseEntity<>("Challenged not added successfully",HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/{month}")
    public ResponseEntity<Challenge> getChallenges(@PathVariable String month){
        Challenge challenge=challengeService.getChallenges(month);
        if (challenge!=null){
            return new ResponseEntity<>(challenge,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(challenge,HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<String>updateChallenge(@PathVariable Long id, @RequestBody Challenge updateChallenge){
        boolean isChallangedUpdated=challengeService.updateChallange(id,updateChallenge);
        if(isChallangedUpdated){
            return new ResponseEntity<>("Challange updated succesfully",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Challange not updated successfully",HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteChallenge(@PathVariable Long id){
        boolean isChallangeDeleted= challengeService.deleteChallange(id);
        if(isChallangeDeleted){
            return new ResponseEntity<>("Challenge deleted succesfully",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Challenge not deleted successfully",HttpStatus.NOT_FOUND);
        }
    }
}

