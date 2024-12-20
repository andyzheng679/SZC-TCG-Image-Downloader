# Link: https://szc-tcg-image-downloader-1.onrender.com/

# Trading Card Game (TCG) Image Downloader, a new full-stack application I developed to help solve a real-world problem for trading card game enthusiasts and retailers!

After a conversation with the owner of my local game store, I learned that they were spending majority of their time searching for card images and checking prices on TCGPlayer. To make this process more efficient, I built TCG Image Downloader, an app that allows users to:

- ✨Select from various trading card games (like Pokémon, Magic: The Gathering, Lorcana, etc.). 
- ✨Choose a set and instantly view all the cards from that set.
- ✨Download high-resolution images of the cards.
- ✨Access direct links to TCGPlayer for pricing and purchasing options.

To bring this App to life, I utilized several APIs:
* Lorcana API for Lorcana sets
* Pokémon TCG Developer API for Pokémon cards
* Scryfall API for Magic: The Gathering data

I used React for the frontend and Spring Boot for the backend, and I containerized the app using Docker for easy deployment and scalability. Building this app gave me valuable experience in reading and understanding API documentation while creating a streamlined user experience.

<img src="https://github.com/andyzheng679/SZC-TCG-Image-Downloader/blob/eeffda1790cb875c03341219e6f554adb8aad6b8/Screenshot_2024-10-02_at_12.32.07_PM.png" />


#UpComing Updates:
- TestCases for ImageDownLoaderService, and Controller
- TestCases for FrontEnd and addidtional documentation
- Features:
- Tcgplayer link for Lorcana cards, not included in external API.
- Adding all variants of each card for Mtg.
- UI Changes(Color?).

#Recent Updates:
- Deleted redundant code in MtgService.
- TestCases for PokemonService, LorcanaService, MtgService.

#Past Updates:
- Added dark mode toggle
