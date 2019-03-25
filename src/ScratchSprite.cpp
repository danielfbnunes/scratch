#include <cmath>
#include <iostream>
#include <string>
#include "ScratchSprite.h"

void ScratchSprite ::move(double x, double y ){
    sf::Vector2f actualPosition = this->getPosition();
    this->setPosition(actualPosition.x + x, actualPosition.y + y);
}

void ScratchSprite ::goTo(double x, double y){
    this->setPosition(x, y);
}

void ScratchSprite ::rotate(double degrees){
    this->setRotation(degrees);
}

void ScratchSprite ::size(double height, double width){
    this->setScale(height, width);
}

void ScratchSprite ::setWidth(double width){
    this->setScale(this->getHeight(), width);
}

void ScratchSprite ::setHeight(double height){
    this->setScale(height, this->getWidth());
}


double ScratchSprite ::getX(){
    return this->getPosition().x;
}

double ScratchSprite ::getY(){
    return this->getPosition().y;
}

double ScratchSprite ::getWidth(){
    return this->getScale().x;
}

double ScratchSprite ::getHeight(){
    return this->getScale().y;
}

void ScratchSprite ::setName(string name){
	this->name = name;
}

string ScratchSprite ::getName(){
	return this->name;
}

void ScratchSprite ::setBoundingBoxType(BoundingBoxType type){
     this->	boundingBox = type;
}

double ScratchSprite ::getBoundingBox(){
    return 0;
}

void ScratchSprite ::setCollidability(bool type){
     colidability = type;
}

bool ScratchSprite ::getCollidability(){
    return  colidability;
}

void ScratchSprite ::setGravity(double value){
     gravity = value;
}

double ScratchSprite ::getGravity(){
    return  gravity;
}

void ScratchSprite ::crop(double x, double y, double width, double height){
    sf::IntRect subRect(x, y, width, height);
    this->setTextureRect(subRect);
}

bool ScratchSprite ::touching(ScratchSprite s){
    return this->getGlobalBounds().intersects(s.getGlobalBounds());
} 






