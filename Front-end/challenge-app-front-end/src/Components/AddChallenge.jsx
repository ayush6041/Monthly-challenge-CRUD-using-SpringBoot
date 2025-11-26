import axios from "axios";
import { useState } from "react";
import "../Styles/AddChallenge.css"



const AddChallenge = ({ onChallengeAdded }) => {
  const [month, setMonth] = useState("");
  const [description, setDescription] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.post("http://localhost:8080/challenges", { month, description });
      setMonth("");
      setDescription("");
      onChallengeAdded();
    } catch (error) {
      console.error("Error in adding challenge ", error);
    }
  };

return (
  <div className="add-challenge-wrapper">
    <div className="add-challenge-card">
      <h2 className="title">Add Challenge</h2>

      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label className="form-label">Month</label>
          <input
            type="text"
            value={month}
            onChange={(e) => setMonth(e.target.value)}
            required
          />
        </div>

        <div className="form-group">
          <label className="form-label">Description</label>
          <textarea
            rows="4"
            value={description}
            onChange={(e) => setDescription(e.target.value)}
            required
          ></textarea>
        </div>

        <button type="submit" className="add-btn">Add Challenge</button>
      </form>
    </div>
  </div>
);
};

export default AddChallenge;
