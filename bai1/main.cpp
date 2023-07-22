#include <iostream>
using namespace std;

int main()
{
	float TotalKm;
    float Cost = 0;
    std::cin >> TotalKm;

    if (TotalKm <= 1)
    {
        Cost = TotalKm * 5000;
    }
    else if (TotalKm <= 30 && TotalKm > 1)
    {
        Cost = (TotalKm - 1) * 4000 + 1 * 5000;
    }
    else
    {
        Cost = 1 * 5000 + 29 * 4000 + (TotalKm - 30) * 3000;
    }

    std::cout<< Cost << std::endl;
	return 0;
}

