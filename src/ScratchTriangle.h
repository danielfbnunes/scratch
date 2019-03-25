#include "ScratchRegularPoligon.cpp"

class ScratchTriangle : ScratchRegularPoligon {
    public:
        ScratchTriangle() : ScratchRegularPoligon(3){};
        void setSideSize(double s);
};
