#include "ScratchSprite.cpp"

class ScratchRegularPoligon : public ScratchSprite, public sf::CircleShape {
    public:
        ScratchRegularPoligon(int n) : sf::CircleShape(n){}
        void setSides(std::size_t nSides);
        std::size_t getSides();
    private:
        std::size_t nSides;
};






