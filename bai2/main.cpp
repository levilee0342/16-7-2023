#include <iostream>

void formatSeconds(int seconds) {
    int hours = seconds / 3600;   
    int minutes = (seconds % 3600) / 60; 
    int remainingSeconds = seconds % 60;

    std::cout << hours << ":";

    if (minutes < 10) {
        std::cout << "0";
    }
    std::cout << minutes << ":";

    if (remainingSeconds < 10) {
        std::cout << "0";
    }
    std::cout << remainingSeconds << std::endl;
}

int main() {
    int totalSeconds;
    std::cin >> totalSeconds;

    formatSeconds(totalSeconds);

    return 0;
}

