import React from 'react';

function CardList({ tcgSetData }) {
  if (!Array.isArray(tcgSetData) || tcgSetData.length === 0) {
    return null;
  }

  return (
    <div className="card-data-container">
      {tcgSetData.map((card) => (
        <div key={card.name} className="card-item">
          <strong>{card.name}</strong> - {card.rarity} <br />
          <img src={card.imgURL} alt={card.name} style={{ width: '150px' }} /><br />
          <a href={card.tcgplayerUrl} target="_blank" rel="noopener noreferrer">Buy on TCGPlayer</a>
        </div>
      ))}
    </div>
  );
}

export default CardList;
