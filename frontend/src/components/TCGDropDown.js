import React from "react";

function TCGDropDown({selectedTcg, handleTcgChange}){

    return(
        <select value={selectedTcg} onChange={handleTcgChange}>
            <option value="">--Select a TCG--</option>
            <option value="pokemon">Pokémon</option>
            <option value="lorcana">Lorcana</option>
            <option value="mtg">Mtg</option>
        </select>
    );

}

export default TCGDropDown;