import Challenge from "./Challenge";
import "../Styles/ChallengeList.css"


const ChallengeList = ({ challenges }) => {
  return (
    <div className="challenge-list">
  <h4 className="list-title">Challenges</h4>

  {challenges.length === 0 ? (
    <p className="text-muted">No challenges added yet...</p>
  ) : (
    challenges.map((c) => (
      <Challenge key={c.id} challenges={c} />
    ))
  )}
</div>
  );
};

export default ChallengeList;
