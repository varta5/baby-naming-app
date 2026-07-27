import axios from 'axios';

function VoteButtons({ babyNameId }) {

  const choices = [
    {
      choice: 'NO',
      buttonText: '👎'
    }, {
      choice: 'MAYBE',
      buttonText: '🤷‍♂️'
    }, {
      choice: 'YES',
      buttonText: '👍'
    }
  ]

  async function castVote(babyNameId, choice) {
    const body = {
      name_id: babyNameId,
      choice: choice
    }
    const response = await axios.post('http://localhost:8080/api/v1/votes', body);
  }

  return (
    <>
      {choices.map((choice) => (
        <span class="vote-button" onClick={() => castVote(babyNameId, choice.choice)}>{choice.buttonText}</span>
      ))}
    </>
  );
}

export default VoteButtons;
