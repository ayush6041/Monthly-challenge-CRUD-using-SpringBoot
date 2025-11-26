// import logo from './logo.svg';
import { useEffect, useState } from 'react';
import './App.css';
import ChallengeList from './Components/ChallengeList';
import axios from 'axios';
import AddChallenge from './Components/AddChallenge';


function App() {
  const [challenges, setChallenges]=useState([]);

  useEffect(()=>{
    
    fetchChallenge();
  },[])
  
  const fetchChallenge= async()=>{
      const response=await axios.get('http://localhost:8080/challenges')
      setChallenges(response.data);
      // console.log(response.data);  

    };

  const handleChallengeAdded=()=>{
    fetchChallenge();
  }

  return (

  <div className="App">
    {/* 🌙 THEME TOGGLE BUTTON (TOP-RIGHT CORNER) */}
      <div className="theme-toggle">
        <button
          onClick={() => {
            const current = document.body.getAttribute("data-theme");
            document.body.setAttribute("data-theme", current === "dark" ? "light" : "dark");
          }}
        >
          🌙
        </button>
      </div>


    <h1 className="title">Monthly Challenges</h1>
    

   <div className="layout">
  <div className="left-panel">
    <AddChallenge onChallengeAdded={handleChallengeAdded}/>
  </div>
  <div className="right-panel">
    <ChallengeList challenges={challenges}/>
  </div>
</div>

  </div>
);

}

export default App;
