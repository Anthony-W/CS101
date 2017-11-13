import java.util.Random;

public class Deck
{
    private final int DECK_SIZE = 52;
    private Card[] deck;

    // Top of the deck is index 0; bottom is index 51.
    private int currentTop;
    
    //
    // Allocates a default deck of 52 cards with four suits.
    //
    public Deck()
    {
        deck = new Card[DECK_SIZE];
        currentTop = 0;

        
        int index = 0;
        for (Card.SuitT suit : Card.SuitT.values())
        {
            for (Card.FaceT face : Card.FaceT.values())
            {
                deck[index++] = new Card(suit, face);
            }
        }
    }
    
    //
    // May assume a full deck.
    //
    // Shuffles by switching two random cards in the deck many times.
    //
    public void shuffle()
    {
        Random rng = new Random();
        
        final int ITERATIONS = 1000;
        for (int count = 0; count < ITERATIONS; count++)
        {
        	//pick the index of each card to switch
            int firstCardIndex = rng.nextInt(52);
            int secondCardIndex = rng.nextInt(52);
            
            //create a temporary variable and store first card value
            Card temp = deck[firstCardIndex];
            
            //switch cards
            deck[firstCardIndex] = deck[secondCardIndex];
            deck[secondCardIndex] = temp;
	
        }
    }

    //
    // Computes the number of cards that remain in the deck:
    // deck count minus the current top index
    //
    public int cardsRemaining()
    {
        return DECK_SIZE - currentTop;
    }
    
    //
    // Returns the top card from the deck.
    //
    public Card deal() throws DeckException
    {
    	//check if deck is empty
    	if (currentTop >= DECK_SIZE) throw new DeckException("No more cards in deck");
    	
    	//deal the card
        return deck[currentTop++];
    }

    //
    // Returns the top card from the deck.
    //
    public Card[] deal(int numCards) throws DeckException
    {
    	Card[] result = new Card[numCards];
    	for(int i = 0; i < numCards; i++)
    	{
    		//check if deck is empty
    		if (currentTop >= DECK_SIZE) throw new DeckException("No more cards in deck");
    		
    		//add next card to set to be dealt
    		result[i] = deck[currentTop++];
    	}
    	
    	//deal cards
    	return result;
    }
    
    
    //
    // Builds and returns a meaningful representation of the cards that
    // remain in the deck.
    //
    public String toString()
    {
        String retStr = "";
        for(int i = currentTop; i < DECK_SIZE; i++)
        {
        	retStr += deck[i].toString() + "\n";
        }
        
        
        return retStr;
    }
}
