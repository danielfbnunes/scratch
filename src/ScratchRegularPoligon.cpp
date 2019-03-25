#include "ScratchRegularPoligon.h"
#include <math.h>



void ScratchRegularPoligon :: setSides(std::size_t n){
    this->setPointCount(n);
    this->nSides = n;
}

std::size_t ScratchRegularPoligon :: getSides(){
    return this->nSides;
}

