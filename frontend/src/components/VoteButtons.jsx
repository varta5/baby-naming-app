import { createVote } from './../services/api';

function VoteButtons({ babyNameId, actionAfterVote, currentUser }) {

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

  async function handleVote(babyNameId, choice) {
    await createVote(babyNameId, choice, currentUser.id);
    actionAfterVote();
  }

  return (
    <>
      {choices.map((choice) => (
        <span class="vote-button" onClick={() => handleVote(babyNameId, choice.choice)}>{choice.buttonText}</span>
      ))}
    </>
  );
}

export default VoteButtons;
