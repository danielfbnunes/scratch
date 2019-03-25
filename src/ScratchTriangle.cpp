#include "ScratchTriangle.h"
#include <math.h>

void ScratchTriangle :: setSideSize(double height){
    float h = sqrt(pow(height, 2) - pow(height/2, 2));
    float b = sqrt(pow(height, 2) - pow(height/2, 2));
    this->CircleShape::setScale(h, b);
}


