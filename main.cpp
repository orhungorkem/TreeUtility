#include <iostream>
using namespace std;


void squarePassByValueExample(int i) {
    i = i * i;
}

void squarePassByReferenceExample(int &i) {
    i = i * i;
}

void squarePassByConstantReferenceExample(const int &i) {
    // i = i * i; -> This will not compile since i is a constant reference, we can use it but can not modify it
    std::cout << "In squarePassByConstantReferenceExample "<< i * i << std::endl;

}

void squarePointerExample(int *i) {
    *i = *i * *i;
}

int main() {

    int i = 5;
    squarePassByValueExample(i);
    std::cout << "In main "<< i << std::endl;

    i = 5;
    squarePassByReferenceExample(i);
    std::cout << "In main "<< i << std::endl;

    i = 5;
    squarePassByConstantReferenceExample(i);

    i = 5;
    squarePointerExample(&i);
    std::cout << "In main "<< i << std::endl;

    // Pointer example

    int a, b;
    int *pa, *pb;

    a   = 5;
    b   = a;
    pa  = &a;
    pb  = pa;
    *pb = 4;

    cout << endl;

    cout << a << " ";
    cout << b << " ";
    cout << *pa << " ";
    cout << *pb << endl;

    return 0;

/*
    int a = 10;
    int b = 20;
    int &c = a;
    c = b;
    std::cout << a << std::endl;


    int a = 10;
    int b = 20;
    int *c = &a;
    c = &b;
    std::cout << a << std::endl;
*/


}