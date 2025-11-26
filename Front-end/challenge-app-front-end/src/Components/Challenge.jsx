import "../Styles/Challenge.css"


const Challenge = ({ challenges }) => {
    return ( 
        <div className="challenge-item">
  <h5>{challenges.month}</h5>
  <p>{challenges.description}</p>
</div>

    );
}
 
export default Challenge;
