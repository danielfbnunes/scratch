#include "ScratchTexture.h"

void ScratchTexture :: turn(){
	sf::Vector2f scale = this->getScale();
	this->setScale(-scale.x, scale.y);
}



