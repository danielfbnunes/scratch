#include <string>
#include <SFML/Graphics.hpp> 

using namespace std;

enum BoundingBoxType {circ = 0, sqr = 1};

class ScratchSprite : public sf::Sprite {
    public :
        void move(double x, double y);
        void goTo(double x, double y);
        void rotate(double degrees);
        void size(double height, double width);
        double getWidth();
        double getHeight();
        void setHeight(double height);
        void setWidth(double width);
        void setName(string name);
	string getName();
        double getY();
        double getX();
        void setBoundingBoxType(BoundingBoxType type);
        double getBoundingBox();
        void setCollidability(bool type);
        bool getCollidability();
        void setGravity(double value);
        double getGravity();
        void crop(double x, double y, double width, double height);
        bool touching(ScratchSprite s);

   protected :       
           std::map<string, sf::Texture> costumes;
           std::map<string, sf::Texture>::iterator it;
           BoundingBoxType boundingBox;
           bool colidability;
           double gravity;
           sf::Texture actualTexture;
           string name;
}; 
