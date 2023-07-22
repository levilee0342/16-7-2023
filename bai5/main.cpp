#include <iostream>
#include <math.h>
using namespace std;
long decimalToBinary(int decimalnum)
{
    long binarynum = 0;
    int rem, temp = 1;
 
    while (decimalnum!=0)
    {
        rem = decimalnum%2;
        decimalnum = decimalnum / 2;
        binarynum = binarynum + rem*temp;
        temp = temp * 10;
    }
    return binarynum;
}
 
int main()
{
    int decimalnum;
    cin>>decimalnum;
    cout<<decimalToBinary(decimalnum);
}
