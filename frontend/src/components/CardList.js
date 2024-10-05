import React from 'react';

function CardList({ tcgSetData, selectedTcg}) {
  
  if (!Array.isArray(tcgSetData) || tcgSetData.length === 0) {
    return null;
  }

  // const handleDownload = (imgURL, cardName, rarity) => {
  //   window.location.href = `https://szc-tcg-image-downloader.onrender.com/${selectedTcg}/download-image?imageUrl=${encodeURIComponent(imgURL)}&cardName=${encodeURIComponent(cardName)}&rarity=${encodeURIComponent(rarity)}`;
  // };

  const handleDownload = (imgURL, cardName, rarity) => {
    window.location.href = `http://localhost:8080/${selectedTcg}/download-image?imageUrl=${encodeURIComponent(imgURL)}&cardName=${encodeURIComponent(cardName)}&rarity=${encodeURIComponent(rarity)}`;
  };

  return (
    <div className="card-data-container">
      {tcgSetData.map((card) => (
        <div key={card.name} className="card-item">
          <strong>{card.name}</strong> - {card.rarity} <br />

          <button onClick={() => handleDownload(card.imgURL, card.name, card.rarity)}>Download Image</button>

          <img src={card.imgURL} alt={card.name} style={{ width: '150px' }} /><br />

          {card.tcgplayerUrl ? (
            <a href={card.tcgplayerUrl} target="_blank" rel="noopener noreferrer">Buy on TCGPlayer</a>
          ) : (
            <span>No TCGPlayer link available</span>
          )}
          

        </div>
      ))}
    </div>
  );
}

export default CardList;
